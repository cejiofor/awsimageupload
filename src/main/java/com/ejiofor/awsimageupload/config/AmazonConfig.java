package com.ejiofor.awsimageupload.config;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {
    @Bean // Instantiate this class with defined config to inject in other classes
    public AmazonS3 s3() {
        return AmazonS3ClientBuilder
                .standard()
                .build();
    }
}
