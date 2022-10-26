package com.thunderdragon.projectshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.thunderdragon.projectshop.entity.Board;
import com.thunderdragon.projectshop.service.BoardService;

@Controller
public class BoardController {

    @Autowired
    private BoardService service;

    @RequestMapping(value = "/board/register", method = RequestMethod.GET)
    public void registerForm(Board board, Model model) throws Exception {

    }

    @RequestMapping(value = "/board/register", method = RequestMethod.POST)
    public String register(Board board, Model model) throws Exception {
        service.register(board);

        model.addAttribute("msg", "등록이 완료되었습니다.");

        return "board/success";
    }

    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public String list(Model model) throws Exception {
        model.addAttribute("list", service.list());
        return "board/list";
    }

    @RequestMapping(value = "/board/read", method = RequestMethod.GET)
    public String read(int boardNo, Model model) throws Exception {
        model.addAttribute(service.read(boardNo));
        return "board/read";
    }

    @RequestMapping(value = "/board/remove", method = RequestMethod.GET)
    public String remove(int boardNo, Model model) throws Exception {
        service.remove(boardNo);
        model.addAttribute("msg", "삭제가 완료되었습니다.");

        return "board/success";
    }

    @RequestMapping(value = "/board/modify", method = RequestMethod.GET)
    public void modifyForm(int boardNo, Model model) throws Exception {
        model.addAttribute(service.read(boardNo));
    }

    @RequestMapping(value = "/board/modify", method = RequestMethod.POST)
    public String modify(Board board, Model model) throws Exception {
        service.modify(board);

        model.addAttribute("msg", "수정이 완료되었습니다.");

        return "board/success";
    }

}
