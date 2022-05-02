package org.zerock.sp1.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.sp1.domain.Reply;
import org.zerock.sp1.dto.ReplyDTO;
import org.zerock.sp1.mapper.BoardMapper;
import org.zerock.sp1.mapper.ReplyMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyServceImpl implements ReplyServce{

    private final ReplyMapper replyMapper;
    private final ModelMapper modelMapper;
    private final BoardMapper boardMapper;

    @Override
    public List<ReplyDTO> getListOfBoard(Integer bno) {
        List<Reply> vo = replyMapper.selectListOfBoard(bno);

        List<ReplyDTO> dtoList = vo.stream().map(reply -> modelMapper.map(reply,ReplyDTO.class)).collect(Collectors.toList());

        return dtoList;
    }

    @Override
    public void register(ReplyDTO replyDTO) {
        Reply vo = modelMapper.map(replyDTO , Reply.class);

        replyMapper.insert(vo);
        boardMapper.updateReplyCount(vo.getBno(), 1);


    }


}
