package org.zerock.sp1.mapper;


import lombok.Builder;
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
        List<Board> boardList = boardMapper.selectList(10,20);
        boardList.forEach(board -> log.info(board));
    }

    @Test
    public void testSelectOne(){
        int bno = 140;
        Board board = boardMapper.selectOne(bno);
        log.info(board);
    }

    @Test
    public void testDelte(){
        int bno = 32;
        boardMapper.delete(bno);
    }
    @Test
    public void testUpdate(){
        Board board = Board.builder().title("안녕하세요").content("반갑습니다.").bno(3).build();
        boardMapper.update(board);
        log.info(board);
    }

}
