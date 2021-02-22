package com.jin.web.repository;

import com.jin.web.dto.Board;
import com.jin.web.param.BoardParam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository {

    List<Board> getList(); // 리스트 조회

    Board get(int boardId); // 단건 조회

    void save(BoardParam board); // 저장

    void update(BoardParam board); // 수정

    void delete(int boardId); // 삭제
}
