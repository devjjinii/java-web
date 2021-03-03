package com.jin.web.service;

import com.jin.web.dto.Board;
import com.jin.web.param.BoardParam;
import com.jin.web.param.BoardSearchParam;
import com.jin.web.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public List<Board> getList(BoardSearchParam param) { return boardRepository.getList(param); }

    public Board get(int boardId) { return boardRepository.get(boardId); }

    public void save (BoardParam board) {
        // boradId
        Board boardId = boardRepository.get(board.getBoardId());
        if (boardId == null) {
            boardRepository.save(board);
        } else {
            boardRepository.update(board);
        }
    }

   // public void update(Board board) { boardRepository.update(board); }

    public void delete(int boardId) {
        boardRepository.delete(boardId);
    }
}
