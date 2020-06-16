package com.ejiofor.awsimageupload.profile;

import com.amazonaws.services.dynamodbv2.xspec.M;
import com.ejiofor.awsimageupload.repositories.MariaDbUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserProfileDataAccessService {
    @Autowired
    private final MariaDbUserRepository mariaDbUserRepository;

    public UserProfileDataAccessService(MariaDbUserRepository mariaDbUserRepository) {
        this.mariaDbUserRepository = mariaDbUserRepository;
    }

    public List<UserProfile> getUserProfiles() {
        return mariaDbUserRepository.getUserProfiles();
    }

    public UUID registerUser(UserProfile userProfile) {
        return mariaDbUserRepository.registerUser(userProfile);
    }

    public UserProfile getUserById(UUID uuid) {
        return mariaDbUserRepository.getUserById(uuid);
    }

    public Boolean updateUser(UserProfile userProfile) {
        return mariaDbUserRepository.updateUser(userProfile);
    }

    public Boolean removeUser(UUID uuid) {
        return mariaDbUserRepository.removeUser(uuid);
    }

    //    private final FakeUserProfileDataStore fakeUserProfileDataStore;
    //
    //    @Autowired
    //    public UserProfileDataAccessService(FakeUserProfileDataStore fakeUserProfileDataStore){
    //        this.fakeUserProfileDataStore = fakeUserProfileDataStore;
    //    }
    //
    //    List<UserProfile> getUserProfiles(){
    //        return fakeUserProfileDataStore.getUserProfiles();
    //    }
}

