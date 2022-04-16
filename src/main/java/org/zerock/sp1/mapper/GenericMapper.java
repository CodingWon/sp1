package org.zerock.sp1.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.sp1.domain.Board;

import java.util.List;

public interface GenericMapper<E,K> {
    void insert(E board);

    List<E> selectList(@Param("skip") int skip, @Param("size")int size);

    void delete(K bno);

    E selectOne(K bno);

    void update(E board);
}
