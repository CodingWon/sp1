package org.zerock.sp1.mapper;

import org.zerock.sp1.domain.Board;

import java.util.List;

public interface BoardMapper {

    void insert(Board board);

    List<Board> selectList();

}
