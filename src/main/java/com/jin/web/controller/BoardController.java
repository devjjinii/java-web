package com.jin.web.controller;

import com.jin.web.dto.Board;
import com.jin.web.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping(value = "/list")
    public List<Board> getList() {
        return boardService.getList();
    }

    @GetMapping(value = "/{boardId}")
    public Board get(@PathVariable int boardId) {
        return boardService.get(boardId);
    }

    @PostMapping(value = "/save")
    public int save(Board board) {
         boardService.save(board);
         return board.getBoardId();
    }

    @PostMapping(value = "/delete/{boardId}")
    public boolean delete(@PathVariable int boardId) {
        Board board = boardService.get(boardId);
        if(board == null) {
            return false;
        }
        boardService.delete(boardId);
        return true;
    }
}
