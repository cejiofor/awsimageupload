package com.ejiofor.awsimageupload.datastore;

import com.ejiofor.awsimageupload.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileDataStore {
    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static {
        USER_PROFILES.add(new UserProfile(UUID.fromString("c90b622b-7f5a-40a2-9cf1-49547bf91847"), "janetjones", null));
        USER_PROFILES.add(new UserProfile(UUID.fromString("735daa1f-f547-4dfe-a95f-7b94be507a49"), "antoniojunior", null));

    }

    public List<UserProfile> getUserProfiles(){
        return USER_PROFILES;
    }
}
