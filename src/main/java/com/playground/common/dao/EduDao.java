package com.playground.common.dao;

import com.playground.common.dto.Edu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EduDao {
    void insert(Edu edu);

    Edu update(Edu edu);

    void delete(Edu edu);

    List<Edu> getEduList(Edu edu);
}
