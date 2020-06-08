package com.ejiofor.awsimageupload.profile;

public class UserProfileExeception extends Exception {
    public UserProfileExeception() {
    }

    public UserProfileExeception(String message) {
        super(message);
    }

    public UserProfileExeception(String message, Throwable cause) {
        super(message, cause);
    }

    public UserProfileExeception(Throwable cause) {
        super(cause);
    }

    public UserProfileExeception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
