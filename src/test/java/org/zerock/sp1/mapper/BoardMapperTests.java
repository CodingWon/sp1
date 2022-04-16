package org.zerock.sp1.mapper;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.sp1.domain.Board;

import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml")
public class BoardMapperTests {

    @Autowired(required = false)
    private BoardMapper boardMapper;

    @Test
    public void testInsert(){
        Board board = Board.builder().title("제목").content("내용").writer("user1").build();
        log.info(board);
        boardMapper.insert(board);
    }

    @Test
    public void testSelctList(){
        List<Board> boardList = boardMapper.selectList(10);
        boardList.forEach(board -> log.info(board));
    }

}
