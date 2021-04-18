package com.jin.web.service;

import com.jin.web.param.UploadFileParam;
import com.jin.web.repository.UploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadFileService {

    @Autowired
    private UploadRepository uploadRepository;

    /**
     * 파일 업로드
     * **/
    public void upload(UploadFileParam param) {
        uploadRepository.upload(param);
    }
}
