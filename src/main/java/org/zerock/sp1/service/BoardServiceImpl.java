package org.zerock.sp1.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.sp1.domain.Board;
import org.zerock.sp1.dto.BoardDTO;
import org.zerock.sp1.dto.ListDTO;
import org.zerock.sp1.dto.ListResponseDTO;
import org.zerock.sp1.mapper.BoardMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardMapper boardMapper;
    private final ModelMapper modelMapper;

    @Override
    public ListResponseDTO<BoardDTO> getList(ListDTO listDTO) {
        List<Board> boardList = boardMapper.selectList(listDTO);

        List<BoardDTO> dtoList =
                boardList.stream()
                        .map(board -> modelMapper.map(board,BoardDTO.class))
                        .collect(Collectors.toList());

        return ListResponseDTO.<BoardDTO>builder()
                .dtoList(dtoList)
                .total(boardMapper.getTotal(listDTO))
                .build();
    }

    @Override
    public BoardDTO selectOne(Integer bno) {
        Board vo = boardMapper.selectOne(bno);

        BoardDTO dto = modelMapper.map(vo,BoardDTO.class);
        return dto;
    }

    @Override
    public void update(BoardDTO boardDTO) {

        boardMapper.update(Board.builder()
                .bno(boardDTO.getBno())
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent()).build());

    }

    @Override
    public void remove(Integer bno) {
        boardMapper.remove(bno);
    }
}
