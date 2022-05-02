package org.zerock.sp1.service;

import org.springframework.transaction.annotation.Transactional;
import org.zerock.sp1.domain.Reply;
import org.zerock.sp1.dto.ReplyDTO;

import java.util.List;

@Transactional
public interface ReplyServce {
    List<ReplyDTO> getListOfBoard(Integer bno);

    void register(ReplyDTO replyDTO);

}
