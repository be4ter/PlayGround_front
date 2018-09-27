package com.playground.controller.login;

import com.playground.common.dto.Member;
import com.playground.exception.UnableLoginException;
import com.playground.service.MemberService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
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

    @GetMapping("/{memberid}")
    public String loginCheck(@PathVariable String memberid, HttpSession session) {
        Member member = memberService.findByMemberid(memberid);
        Member loginedMember = (Member) session.getAttribute("loginedUser");
        if (member == null) {
            return "사용자가 존재하지 않습니다.";
        }
        if (loginedMember == null) {
            return "로그인 한 멤버가 아닙니다.";
        }
        if (!member.equals(loginedMember)) {
            return "멤버 객체가 일치 하지 않습니다.";
        }
        return "success";
    }

    @DeleteMapping()
    public String logout(HttpSession session) {
        Member loginedMember = (Member) session.getAttribute("loginedUser");
        if (loginedMember == null) {
            return "로그인 한 멤버가 아닙니다.";
        }
        session.removeAttribute("loginedUser");
        return "success";
    }
}
