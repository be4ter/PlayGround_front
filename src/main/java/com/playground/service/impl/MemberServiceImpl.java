package com.playground.service.impl;

import com.playground.common.dao.MemberDao;
import com.playground.common.dto.Member;
import com.playground.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDao memberDao;

    @Override
    public Member view(Member member) {
        return memberDao.view(member);
    }

    @Override
    public int update(Member member) {
        return memberDao.update(member);
    }

    @Override
    public void insert(Member member) {
        memberDao.insert(member);
    }

    @Override
    public Member findByEmail(String email) {
        return memberDao.findByEmail(email.split("@")[0]);
    }

    @Override
    public void authMember(Member member) {
        memberDao.authMember(member);
    }

    @Override
    public Member findByMemberid(String memberid) {
        return memberDao.findByMemberId(memberid);
    }

    @Override
    public void delete(Member member) {
        memberDao.delete(member);
    }

}
