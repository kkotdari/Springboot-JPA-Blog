package com.kkot.blog.controller;

import com.kkot.blog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/")
    public String index(Model model, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) { // 컨트롤러에서 세션을 어떻게 찾는가
        model.addAttribute("boards", boardService.list(pageable));
        return "index";
    }

    @GetMapping("/board/{id}")
    public String findById(@PathVariable int id, Model model) {
        model.addAttribute("board", boardService.detail(id));
        return "board/detail";
    }

    @GetMapping("/board/save-form")
    public String saveForm(){
        return "/board/save-form";
    }

    @GetMapping("/board/{id}/update-form")
    public String updateForm(@PathVariable int id, Model model) {
        model.addAttribute("board", boardService.detail(id));
        return "/board/update-form";
    }
}
