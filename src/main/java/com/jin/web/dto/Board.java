package com.jin.web.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Board {

    private int boardId;
    private String title;
    private String contents;
    private Date regDate;
}
