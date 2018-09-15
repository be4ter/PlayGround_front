package com.playground.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.playground.common.dto.Member;

@Mapper
public interface MemberDao {
	public List<Member> list(Member memberDto);
	public Member view(Member memberDto);
	public void insert(Member memberDto);
	public int update(Member memberDto);
	public int delete(Member memberDto);
	public int count(Member memberDto);
}
