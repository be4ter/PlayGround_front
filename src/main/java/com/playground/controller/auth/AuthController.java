package com.playground.controller.auth;

import com.playground.common.dto.Member;
import com.playground.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthController {
    @Autowired
    private MemberService memberService;

    @ResponseBody
    @GetMapping("/auth/{number}/{email}")
    public Member auth(@PathVariable Long number, @PathVariable String email) {
        Member member = memberService.findByEmail(email);
        System.out.println("member : " + member);
        member.isVerifyAuthNumber(number);
        memberService.authMember(member);
        return member;
    }
}
