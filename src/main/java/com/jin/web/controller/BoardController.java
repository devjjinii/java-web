package com.jin.web.controller;

import com.jin.web.config.RequestConfig;
import com.jin.web.config.exception.BaseException;
import com.jin.web.dto.Board;
import com.jin.web.http.Response;
import com.jin.web.http.ResponseCode;
import com.jin.web.param.BoardParam;
import com.jin.web.param.BoardSearchParam;
import com.jin.web.service.BoardService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@Api(tags = "게시판 API")
public class BoardController {

    Logger logger = LoggerFactory.getLogger(BoardController.class);
    @Autowired
    private BoardService boardService;

    @GetMapping(value = "/list")
    @ApiOperation(value = "목록 조회", notes = "게시물 전체 리스트를 확인할 수 있다.")
    public Response<List<Board>> getList(@ApiParam BoardSearchParam param) {
//        return new ResponseEntity<>(boardService.getList(), HttpStatus.OK);
        logger.info("getList");
        return new Response<>(boardService.getList(param));
    }

    @GetMapping(value = "/{boardId}")
    @ApiOperation(value = "상세 조회", notes = "해당 번호의 게시물을 확인할 수 있다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "boardId", value = "게시물 번호", example = "1")
    })
    public Response<Board> get(@PathVariable int boardId) {
        Board board = boardService.get(boardId);
        if(board == null) {
            throw new BaseException(ResponseCode.DATA_IS_NULL, new String[] {"게시물"});
        }
        return new Response<>(boardService.get(boardId));
    }

    @PostMapping(value = "/save")
    @RequestConfig // 만든 config
    @ApiOperation(value = "등록 / 수정", notes = "신규 게시물 저장 및 해당 게시글을 수정할 수 있다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name="boardId", value = "게시물 번호", example = "1"),
            @ApiImplicitParam(name="boardType", value= "게시물 종류"),
            @ApiImplicitParam(name="title", value = "제목", example = "제목"),
            @ApiImplicitParam(name="contents", value = "내용", example = "내용")
    })
    public Response<Integer> save(BoardParam board) {

        // 제목 필수체크
        if(StringUtils.isEmpty(board.getTitle())) {
            throw new BaseException(ResponseCode.VALIDATE_CHECK, new String[] {"title", "제목"});
        }
        // 내용 필수체크
        if(StringUtils.isEmpty(board.getContents())) {
            throw new BaseException(ResponseCode.VALIDATE_CHECK, new String[] {"content", "내용"});
        }
         boardService.save(board);
         return new Response<>(board.getBoardId());
    }

    @PostMapping(value = "/delete/{boardId}")
    @RequestConfig
    @ApiOperation(value = "삭제", notes = "해당 게시글을 삭제할 수 있다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name="boardId", value = "게시물 번호", example = "1"),
    })
    public Response<Boolean> delete(@PathVariable int boardId) {
        Board board = boardService.get(boardId);
        if(board == null) {
            return new Response<>(false);
        }
        boardService.delete(boardId);
        return new Response<>(true);
    }
}
