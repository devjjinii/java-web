package com.jin.web.controller;

import com.jin.web.dto.Board;
import com.jin.web.param.BoardParam;
import com.jin.web.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@Api(tags = "게시판 API")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping(value = "/list")
    @ApiOperation(value = "목록 조회", notes = "게시물 전체 리스트를 확인할 수 있다.")
   public List<Board> getList() {
        return boardService.getList();
    }

    @GetMapping(value = "/{boardId}")
    @ApiOperation(value = "상세 조회", notes = "해당 번호의 게시물을 확인할 수 있다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "boardId", value = "게시물 번호", example = "1")
    })
    public Board get(@PathVariable int boardId) {
        return boardService.get(boardId);
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "등록 / 수정", notes = "신규 게시물 저장 및 해당 게시글을 수정할 수 있다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name="boardId", value = "게시물 번호", example = "1"),
            @ApiImplicitParam(name="title", value = "제목", example = "제목"),
            @ApiImplicitParam(name="contents", value = "내용", example = "내용")
    })
    public int save(BoardParam board) {
         boardService.save(board);
         return board.getBoardId();
    }

    @PostMapping(value = "/delete/{boardId}")
    @ApiOperation(value = "삭제", notes = "해당 게시글을 삭제할 수 있다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name="boardId", value = "게시물 번호", example = "1"),
    })
    public boolean delete(@PathVariable int boardId) {
        Board board = boardService.get(boardId);
        if(board == null) {
            return false;
        }
        boardService.delete(boardId);
        return true;
    }
}
