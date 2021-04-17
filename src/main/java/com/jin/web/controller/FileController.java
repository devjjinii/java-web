package com.jin.web.controller;

import com.jin.web.config.GlobalConfig;
import com.jin.web.config.exception.BaseException;
import com.jin.web.http.Response;
import com.jin.web.http.ResponseCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/file")
@Api(tags = "파일 API")
public class FileController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private GlobalConfig config;

    @PostMapping(value = "/save")
    @ApiOperation(value = "업로드", notes = "파일 업로드")
    public Response<Boolean> save(@RequestParam("uploadFile") MultipartFile multipartFile) {
        logger.debug("multipartFile: {}", multipartFile);
        logger.debug("config: {}", config);

        if(multipartFile == null || multipartFile.isEmpty()) {
            throw new BaseException(ResponseCode.DATA_IS_NULL);
        }

        String uploadFilePath = config.getUploadFilePath();
        logger.debug("uploadFilePath : {}", uploadFilePath);

        String prefix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".") + 1, multipartFile.getOriginalFilename().length());
        String filename = UUID.randomUUID().toString() + "." + prefix;
        logger.info("filename : {}", filename);

        String pathname = uploadFilePath + filename;
        File dest = new File(pathname);
        try {
            multipartFile.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("e", e);
        }

        return new Response<Boolean>(true);
    }

}
