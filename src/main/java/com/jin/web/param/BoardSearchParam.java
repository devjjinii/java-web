package com.jin.web.param;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BoardSearch 추가 이유
 *  - 검색을 위한 파라미터 추가
 * */
@Data
//@NoArgsConstructor
public class BoardSearchParam {

    private String searchKeyword; // 검색조건

    public BoardSearchParam() {
    }
}
