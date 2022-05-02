package org.zerock.sp1.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zerock.sp1.dto.ReplyDTO;
import org.zerock.sp1.mapper.ReplyMapper;
import org.zerock.sp1.service.ReplyServce;

import java.util.List;
import java.util.Map;

@Log4j2
@RestController
@RequestMapping("/replies/")
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyServce replyServce;

    @GetMapping(value = "/list/{bno}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReplyDTO> getListOfBoard(@PathVariable("bno") Integer bno){
        return replyServce.getListOfBoard(bno);
    }

    @PostMapping("/")
    public Map<String,String> register(@RequestBody ReplyDTO replyDTO){
        log.info("============================");
        log.info(replyDTO);

        replyServce.register(replyDTO);
        return Map.of("result","insert");
    }
}
