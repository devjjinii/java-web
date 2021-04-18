package com.jin.web.controller;

import com.jin.web.config.GlobalConfig;
import com.jin.web.config.exception.BaseException;
import com.jin.web.http.Response;
import com.jin.web.http.ResponseCode;
import com.jin.web.param.UploadFileParam;
import com.jin.web.service.UploadFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

@RestController
@RequestMapping("/file")
@Api(tags = "파일 API")
public class FileController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private GlobalConfig config;

    @Autowired
    private UploadFileService uploadFileService;

    @PostMapping(value = "/upload")
    @ApiOperation(value = "업로드", notes = "파일 업로드")
    public Response<Boolean> save(@RequestParam("uploadFile") MultipartFile multipartFile) {
        logger.debug("multipartFile: {}", multipartFile);
        logger.debug("config: {}", config);

        if(multipartFile == null || multipartFile.isEmpty()) {
            throw new BaseException(ResponseCode.DATA_IS_NULL);
        }
        // 상위 날짜 폴더 생성
        String currentDate = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        String uploadFilePath = config.getUploadFilePath() + currentDate + "/";
        logger.debug("uploadFilePath : {}", uploadFilePath);

        String prefix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".") + 1, multipartFile.getOriginalFilename().length());
        String filename = UUID.randomUUID().toString() + "." + prefix;
        logger.info("filename : {}", filename);

        // 폴더 없으면 생성
        File folder = new File(uploadFilePath);
        if(!folder.isDirectory()) {
            folder.mkdirs();
        }

        String pathname = uploadFilePath + filename;
        String resourcePathname = config.getUploadResourcePath() + currentDate + "/" + filename;
        File dest = new File(pathname);
        try {
            multipartFile.transferTo(dest);
            // 파일 업로드 된 후 DB에 저장
            UploadFileParam param = new UploadFileParam();
            param.setFileName(filename); // 저장 파일명
            param.setPathName(pathname); // 파일 저장경로
            param.setOrgFilename(multipartFile.getOriginalFilename()); // 원본 파일명
            param.setContentType(multipartFile.getContentType()); // 컨텐츠 종류
            param.setSize((int) multipartFile.getSize()); // 파일 크기
            param.setResourcePathname(resourcePathname); // 브라우저에서 접속 가능한 static resource 접근 경로

            // 저장
            uploadFileService.upload(param);

        } catch (IOException e) {
            e.printStackTrace();
            logger.error("e", e);
        }

        return new Response<Boolean>(true);
    }

}
