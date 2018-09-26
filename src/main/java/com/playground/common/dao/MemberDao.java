package com.playground.common.dao;

import com.playground.common.dto.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberDao {
    List<Member> list(Member memberDto);

    Member view(Member memberDto);

    void insert(Member memberDto);

    int update(Member memberDto);

    int delete(Member memberDto);

    int count(Member memberDto);

    Member findByEmail(String memberid);

    void authMember(Member member);
}
