package com.kkot.blog.controller.api;

import com.kkot.blog.config.auth.PrincipalDetails;
import com.kkot.blog.dto.ReplySaveRequestDTO;
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
    public ResponseDTO<Integer> postBoard(@RequestBody Board requestBoard, @AuthenticationPrincipal PrincipalDetails principal) {
        boardService.write(requestBoard, principal.getUser());
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

    // 댓글 부분
    // 데이터 받을 때 컨트롤러에서 dto를 만들어서 받는게 좋다.
    // dto 사용하지 않은 이유는!!
    @PostMapping("/api/board/{boardId}/reply")
    public ResponseDTO<Integer> replySave(@RequestBody ReplySaveRequestDTO replySaveRequestDto) {
        boardService.writeReply(replySaveRequestDto);
        return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
    }

    @DeleteMapping("/api/board/{boardId}/reply/{replyId}")
    public ResponseDTO<Integer> replyDelete(@PathVariable int replyId) {
        boardService.deleteReply(replyId);
        return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
    }
}
