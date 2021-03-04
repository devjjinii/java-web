package com.jin.web.param;

import com.jin.web.dto.BoardType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * BoardSearch 추가 이유
 *  - 검색을 위한 파라미터 추가
 * */
@Data
//@NoArgsConstructor
public class BoardSearchParam {

    private String searchKeyword; // 검색조건
    private List<BoardType> boardTypes; // 게시판 종류 배열

    public BoardSearchParam() {
    }
}
