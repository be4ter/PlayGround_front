package com.playground.jobs.login;

import com.playground.common.dto.Member;

public interface LoginService {
    public Member view(Member member);

    public int update(Member mem);

    public void insert(Member member);
}
