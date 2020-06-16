package com.ejiofor.awsimageupload.repositories;

import com.ejiofor.awsimageupload.profile.UserProfile;

import java.util.List;
import java.util.UUID;

public interface UserRepository {
    List<UserProfile> getAllUsers();

    UUID registerUser(UserProfile userProfile);

    UserProfile getUserById(UUID uuid);

    Boolean updateUser(UserProfile userProfile);

    Boolean removeUser(UUID uuid);
    

}
