package com.playground.jobs.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playground.common.dao.MemberDao;
import com.playground.common.dto.Member;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public Member view(Member member) {
		return memberDao.view(member);
	}

	@Override
	public int update(Member mem) {
		return memberDao.update(mem);
	}

}
