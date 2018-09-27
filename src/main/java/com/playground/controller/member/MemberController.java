package com.playground.controller.member;

import com.playground.common.dto.Member;
import com.playground.service.MemberService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/member")
public class MemberController {
    private Log log = LogFactory.getLog(this.getClass());

    @Autowired
    private MailSender mailSender;

    @Autowired
    private MemberService memberService;

    @PostMapping()
    public Member create(String email, String password, String name, String memberType) {
        Member member = new Member(email, password, name, memberType);
        sendMail(email, member);
        memberService.insert(member);
        return member;
    }

    @PutMapping()
    public Member update(String name) {
        return null;
    }

    @DeleteMapping()
    public String delete(String email, String password, HttpSession session) {
        Member member = memberService.findByEmail(email);
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
        if(!member.equalsPassword(password)) {
            return "비밀먼호가 일치하지 않습니다.";
        }
        memberService.delete(member);
        return "";
    }

    public void sendMail(String email, Member member) {
        String message = "http://localhost:8080/auth/" + member.getAuthCode() + "/" + email;
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("developerhwan@gmail.com"); // sender email
        msg.setTo(email); // receiver email
        msg.setSubject("Send mail from Spring Boot"); // email title
        msg.setText(message); // contents
        this.mailSender.send(msg);
    }
}
