package com.ejiofor.awsimageupload.profile;

import com.ejiofor.awsimageupload.bucket.BucketName;
import com.ejiofor.awsimageupload.filestore.FileStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.apache.http.entity.ContentType.*;

@Service
public class UserProfileService {
    private final UserProfileDataAccessService userProfileDataAccessService;
    private final FileStore fileStore;

    @Autowired
    public UserProfileService(UserProfileDataAccessService userProfileDataAccessService, FileStore fileStore) {
        this.userProfileDataAccessService = userProfileDataAccessService;
        this.fileStore = fileStore;
    }

    List<UserProfile> getUserProfiles(){
        return userProfileDataAccessService.getUserProfiles();
    }

    public void uploadProfileImage(UUID userProfileId, MultipartFile file) throws UserProfileExeception {
        isFileEmpty(file);
        isImageFile(file);
        UserProfile user = getUserProfile(userProfileId);
        Map<String, String> metadata = extractMetadata(file);

        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), user.getUserProfileId());
        String fileName = String.format("%s-%s", file.getOriginalFilename(), UUID.randomUUID());

        try {
            fileStore.save(path, fileName, Optional.of(metadata), file.getInputStream());
            user.setUserProfileImageLink(fileName);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
         /*
        // 1. check if image is not empty
        boolean emptyFile = file.isEmpty();
        if(emptyFile){
            throw new UserProfileExeception("Image file is empty");
        }

        // 2. check if file is an image
        String contentType = file.getContentType().split("/")[0];
        if (!contentType.equals("image")){
            throw new UserProfileExeception("File is not a valid image types");
        }

        // 3. check whether user exits in database
        boolean userExists = false;
        List<UserProfile> profiles = getUserProfiles();
        for (UserProfile profile: profiles){
            if(userProfileId.equals(profile.getUserProfileId())){
                userExists = true;
            }
        }

        // 4. grab some metadata from file if any
        ObjectMetadata objMetadata = new ObjectMetadata();
        objMetadata.setContentType(file.getContentType());
        objMetadata.addUserMetadata("title", file.getName());
//        request.setMetadata(metadata);


        // 5. Store the image in s3 and update database (userProfileImageLink) with s3 image link
//        fileStore.save();
        */
    }

    public byte[] downloadProfileImage(UUID userProfileId) throws UserProfileExeception{
        UserProfile user = getUserProfile(userProfileId);
        byte[] imageBytes;
        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), user.getUserProfileId());
        imageBytes = user.getUserProfileImageLink()
                .map(key -> fileStore.download(path, key))
                .orElse(new byte[0]);
        return imageBytes;
    }

    private Map<String, String> extractMetadata(MultipartFile file) {
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));
        return metadata;
    }

    private UserProfile getUserProfile(UUID userProfileId) {
        return userProfileDataAccessService
                .getUserProfiles()
                .stream()
                .filter(userProfile -> userProfile.getUserProfileId().equals(userProfileId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("User profile %s not found", userProfileId)));
    }

    private void isImageFile(MultipartFile file) {
        if(!Arrays.asList(IMAGE_JPEG.getMimeType(), IMAGE_PNG.getMimeType(), IMAGE_GIF.getMimeType()).contains(file.getContentType())){
            throw new IllegalStateException("File must be an image");
        }
    }

    private void isFileEmpty(MultipartFile file) {
        if(file.isEmpty()){
            throw new IllegalStateException("Cannot upload empty file");
        }
    }
}

