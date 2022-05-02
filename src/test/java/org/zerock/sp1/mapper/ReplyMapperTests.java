package org.zerock.sp1.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.sp1.domain.Reply;
import org.zerock.sp1.dto.ReplyDTO;
import org.zerock.sp1.service.ReplyServce;

import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml")
public class ReplyMapperTests {

    @Autowired(required = false)
    private ReplyMapper replyMapper;
    @Autowired
    private ReplyServce replyServce;

    @Test
    public void test1(){
        List<Reply> vo = replyMapper.selectListOfBoard(262133);
        for (Reply r: vo) {
            log.info(r);
        }
    }

    @Test
    public void test2(){
        ReplyDTO replyDTO = new ReplyDTO();
        replyDTO.setBno(262133);
        replyDTO.setReplyText("댁슬 서비를 통한 탯글 추가");
        replyDTO.setReplyer("USER44");
        replyServce.register(replyDTO);

    }
}
