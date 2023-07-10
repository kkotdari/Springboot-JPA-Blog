package com.kkot.blog.controller.api;

import com.kkot.blog.config.auth.PrincipalDetails;
import com.kkot.blog.dto.ResponseDTO;
import com.kkot.blog.model.Board;
import com.kkot.blog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardApiController {
    @Autowired
    private BoardService boardService;

    @PostMapping("/api/board")
    public ResponseDTO<Integer> postBoard(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetails principal) {
        boardService.write(board, principal.getUser());
        return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1); // 자바오브젝트를 JSON으로 변환해서 리턴 (Jackson 라이브러리)
    }

    @PutMapping("/api/board/{id}")
    public ResponseDTO<Integer> update(@PathVariable int id, @RequestBody Board requestBoard) {
        boardService.update(id, requestBoard);
        return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
    }
    @DeleteMapping("/api/board/{id}")
    public ResponseDTO<Integer> delete(@PathVariable int id) {
        boardService.delete(id);
        return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
    }
}
