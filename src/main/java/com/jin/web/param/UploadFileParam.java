package com.jin.web.param;

import lombok.Data;

@Data
public class UploadFileParam {

    private String pathName;
    private String fileName;
    private String orgFilename;
    private int size;
    private String contentType;
    private String resourcePathname;

}
