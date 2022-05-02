package org.zerock.sp1.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.sp1.dto.BoardDTO;
import org.zerock.sp1.dto.ListDTO;
import org.zerock.sp1.dto.ListResponseDTO;
import org.zerock.sp1.dto.PageMaker;
import org.zerock.sp1.service.BoardService;

import java.util.List;

@Log4j2
@Controller
@RequestMapping("/board/")
@RequiredArgsConstructor

public class BoardController {

    private final BoardService service;

    @GetMapping("/")
    public String basic() {
        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public void list(ListDTO listDTO, Model model) {
        log.info("board list...............");
        log.info(listDTO);

        ListResponseDTO<BoardDTO> responseDTO = service.getList(listDTO);
        model.addAttribute("dtoList", responseDTO.getDtoList());
        int total = responseDTO.getTotal();
        model.addAttribute("pageMaker", new PageMaker(listDTO.getPage(), total));
    }

    @GetMapping("/read/{bno}")
    public String read(@PathVariable Integer bno, ListDTO listDTO, Model model) {


        BoardDTO boardDTO = service.selectOne(bno);
        log.info(boardDTO);
        model.addAttribute("boardDTO", boardDTO);
        return "/board/read";
    }

    @PostMapping("/modify/{bno}")
    public String modifyPost(@PathVariable("bno") Integer bno, BoardDTO boardDTO, ListDTO listDTO, RedirectAttributes rttr) {
        boardDTO.setBno(bno);
        log.info("modify" + boardDTO);
        service.update(boardDTO);
        rttr.addFlashAttribute("result", "modified");
        return "redirect:/board/read/" + bno + listDTO.getLink();
    }

    @GetMapping("/modify/{bno}")
    public String modify(@PathVariable Integer bno, ListDTO listDTO, Model model) {

        log.info("modfiy-------------****************************** : " + bno);
        log.info(listDTO);
        BoardDTO boardDTO = service.selectOne(bno);
        model.addAttribute("boardDTO", boardDTO);
        return "/board/modify";
    }

    @GetMapping("/register")
    public void registerGET() {
    }

    @PostMapping("/register")
    public String registerPOST(BoardDTO boardDTO, RedirectAttributes rttr) {
        log.info("----------------");
        log.info(boardDTO);

        rttr.addFlashAttribute("result", 123);
        return "redirect:/board/list";
    }

    @GetMapping({"/remove/bno"})
    public String getNotSupported() {
        return "/board/list";
    }

    @PostMapping("/remove/{bno}")
    public String removePost(@PathVariable("bno") Integer bno, RedirectAttributes rttr) {

        service.remove(bno);
        rttr.addFlashAttribute("result", "removed");
        return "redirect:/board/list";
    }
}
