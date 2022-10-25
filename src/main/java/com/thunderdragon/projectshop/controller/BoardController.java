package com.thunderdragon.projectshop.controller;


import com.thunderdragon.projectshop.entity.Board;
import com.thunderdragon.projectshop.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@RequestMapping("/board")
@Controller
@RequiredArgsConstructor
public class BoardController {
    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "/board/register", method = RequestMethod.GET)
    public void registerForm(Board board, Model model) throws Exception {}

    @RequestMapping(value = "/board/register", method = RequestMethod.POST)
    public String register(Board board, Model model) throws Exception {
        boardService.register(board);
        model.addAttribute("msg","등록이 완료되었습니다.");
        return "board/success";
    }
    @GetMapping("/board")
    public String list(Model model) throws Exception{
        model.addAttribute("list",boardService.list());
        return "board/list";
    }
    @GetMapping("/board/read")
    public String read(int boardNo,Model model) throws Exception{
        model.addAttribute(boardService.read(boardNo));
        return "board/read";
    }
    @PostMapping(value = "/board/remove")
    public String remove(@RequestParam("boardNo") int boardNo, Model model) throws Exception {
        boardService.remove(boardNo);
        model.addAttribute("msg","삭제가 완료되었습니다.");
        return "board/success";
    }
    @GetMapping("/board/modify")
    public String modifyForm(int boardNo,Model model) throws Exception{
        model.addAttribute(boardService.read(boardNo));
        return "board/modify";
    }
    @PostMapping(value = "/board/modify")
    public String modify(Board board, Model model) throws Exception {
        boardService.modify(board);
        model.addAttribute("msg","수정이 완료되었습니다.");
        return "board/success";
    }
}
