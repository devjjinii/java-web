package com.jin.web.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Board {

    private int boardId;
    private BoardType boardType; // 타입 추가
    private String title;
    private String contents;
    private Date regDate;
}
