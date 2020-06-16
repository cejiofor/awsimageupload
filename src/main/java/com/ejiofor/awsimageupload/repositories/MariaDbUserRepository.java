package com.ejiofor.awsimageupload.repositories;

import com.ejiofor.awsimageupload.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class MariaDbUserRepository{

    public List<UserProfile> getUserProfiles() {
        return null;
    }

    public UUID registerUser(UserProfile userProfile) {
        return null;
    }

    public UserProfile getUserById(UUID uuid) {
        return null;
    }

    public Boolean updateUser(UserProfile userProfile) {
        return null;
    }

    public Boolean removeUser(UUID uuid) {
        return null;
    }
}
