package com.kkot.blog.service;

import com.kkot.blog.model.Board;
import com.kkot.blog.model.User;
import com.kkot.blog.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public void write(Board board, User user) { // title, content, count 그리고 User 데이터가 필요함
        board.setUser(user);
        board.setCount(0);
        boardRepository.save(board);
    }

    public Page<Board> list(Pageable pageable){
        return boardRepository.findAll(pageable);
    }

    public Board detail(int id){
        return boardRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("글 상세보기 실패 id: " + id);
        });
    }

    @Transactional
    public void update(int id, Board requestBoard){
        // 1. 해당 Board 객체 영속화
        Board board = boardRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("글 찾기 실패 id: " + id);
        });
        // 2. 해당 객체 필드 값 변경
        board.setTitle(requestBoard.getTitle());
        board.setContent(requestBoard.getContent());
        // 3. 해당 함수 종료 시(Service가 종료될 때) 트랜잭션 종료 -> 더티체킹 -> 자동 업데이트 flush
    }
    public void delete(int id){
        boardRepository.deleteById(id);
    }
}
