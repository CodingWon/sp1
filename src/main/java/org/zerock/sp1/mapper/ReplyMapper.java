package org.zerock.sp1.mapper;

import org.zerock.sp1.domain.Reply;

import java.util.List;

public interface ReplyMapper {

    List<Reply> selectListOfBoard(Integer bno);

    void insert(Reply reply);
}
