package com.ejiofor.awsimageupload.profile;

import jdk.nashorn.internal.runtime.options.Option;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class UserProfile {
    private UUID userProfileId;
    private String userName;
    private String userProfileImageLink; //s3 key

    public UserProfile(UUID userProfileId,
                       String userName,
                       String userProfileImageLink) {
        this.userProfileId = userProfileId;
        this.userName = userName;
        this.userProfileImageLink = userProfileImageLink;
    }

    public UUID getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(UUID userProfileId) {
        this.userProfileId = userProfileId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Optional<String> getUserProfileImageLink() {
        // This might be null, allowing to code against it using optionals and streams
        return Optional.ofNullable(userProfileImageLink);
    }

    public void setUserProfileImageLink(String userProfileImageLink) {
        this.userProfileImageLink = userProfileImageLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
//        return userProfileId.equals(that.userProfileId) &&
//                userName.equals(that.userName) &&
//                userProfileImageLink.equals(that.userProfileImageLink);
        //Using this method calls a null check that the prior method above does not
        return Objects.equals(userProfileId, that.userProfileId) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userProfileImageLink, that.userProfileImageLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userProfileId, userName, userProfileImageLink);
    }
}
