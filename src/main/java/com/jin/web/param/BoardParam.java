package com.jin.web.param;

import com.jin.web.dto.BoardType;
import lombok.Data;

/**
 * BoardParam 추가 이유
 *  - Swagger에 reg_date를 노출하지 않기위함.
 * */
@Data
public class BoardParam {

    private int boardId;
    private BoardType boardType; // 타입 추가
    private String title;
    private String contents;
}
