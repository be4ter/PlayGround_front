package com.playground.service;

import com.playground.common.dto.Member;

public interface MemberService {
    Member view(Member member);

    int update(Member mem);

    void insert(Member member);

    Member findByEmail(String email);

    void authMember(Member member);
}
