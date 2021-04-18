package com.jin.web.repository;

import com.jin.web.param.UploadFileParam;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadRepository {

    void upload(UploadFileParam param);
}
