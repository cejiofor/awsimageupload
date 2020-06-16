package com.ejiofor.awsimageupload.repositories;

import com.ejiofor.awsimageupload.profile.UserProfile;

import java.util.List;
import java.util.UUID;

public class MariaDbUserRepository implements UserRepository{
    @Override
    public List<UserProfile> getAllUsers() {
        return null;
    }

    @Override
    public UUID registerUser(UserProfile userProfile) {
        return null;
    }

    @Override
    public UserProfile getUserById(UUID uuid) {
        return null;
    }

    @Override
    public Boolean updateUser(UserProfile userProfile) {
        return null;
    }

    @Override
    public Boolean removeUser(UUID uuid) {
        return null;
    }
}
