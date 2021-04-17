package com.jin.web.config;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Properties;

public class GlobalConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ResourceLoader resourceLoader;

    private String uploadFilePath;

    @PostConstruct
    public void init() {
        String[] activeProfiles = applicationContext.getEnvironment().getActiveProfiles();
        String activeProfile  = "local";
        if(ObjectUtils.isNotEmpty(activeProfiles)) {
            activeProfile = activeProfiles[0];
        }
        String resourcePath = String.format("classpath:globals/global-%s.properties",activeProfile);
        try {
            Resource resource = resourceLoader.getResource(resourcePath);
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);
            uploadFilePath = properties.getProperty("uploadFile.path");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUploadFilePath() {
        return uploadFilePath;
    }
}
