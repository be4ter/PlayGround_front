package com.playground.controller.login;

import com.playground.common.dto.Member;
import com.playground.exception.UnableLoginException;
import com.playground.service.MemberService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    private Log log = LogFactory.getLog(this.getClass());

    @Autowired
    private MemberService memberService;

    @ResponseBody
    @PostMapping("")
    public Member login(String email, String password, HttpSession httpSession) {
        Member member = memberService.findByEmail(email);
        if (member == null) {
            throw new UnableLoginException("가입된 회원이 아닙니다.");
        }

        if (!member.equalsPassword(password)) {
            throw new UnableLoginException("비밀번호가 틀립니다.");
        }
        if (!member.authMember()) {
            throw new UnableLoginException("회원 인증을 하세요");
        }
        httpSession.setAttribute("loginedUser", member);
        return member;
    }
}
