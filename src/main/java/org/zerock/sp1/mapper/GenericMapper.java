package org.zerock.sp1.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.sp1.domain.Board;
import org.zerock.sp1.dto.ListDTO;

import java.util.List;

public interface GenericMapper<E,K> {
    void insert(E board);

    List<E> selectList (ListDTO listDTO);

    int getTotal(ListDTO listDTO);

    void remove(K bno);

    E selectOne(K bno);

    void update(E board);
}
