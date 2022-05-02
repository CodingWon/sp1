package org.zerock.sp1.service;

import org.zerock.sp1.domain.Board;
import org.zerock.sp1.dto.BoardDTO;
import org.zerock.sp1.dto.ListDTO;
import org.zerock.sp1.dto.ListResponseDTO;

import java.util.List;

public interface BoardService {

    ListResponseDTO<BoardDTO> getList(ListDTO listDTO);

    BoardDTO selectOne(Integer bno);

    void update(BoardDTO boardDTO);

    void remove(Integer bno);
}
