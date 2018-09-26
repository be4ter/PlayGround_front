package com.playground.controller.member;

import com.playground.common.dto.Member;
import com.playground.service.MemberService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {
    private Log log = LogFactory.getLog(this.getClass());

    @Autowired
    private MailSender mailSender;

    @Autowired
    private MemberService memberService;

    @PostMapping("/create")
    public Member create(String email, String password, String name, String memberType) {
        Member member = new Member(email, password, name, memberType);
        sendMail(email, member);
        memberService.insert(member);
        return member;
    }

    public void sendMail(String email, Member member) {
        String message = "http://localhost:8080/auth/" + member.getAuthCode() + "/" + email;
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("developerhwan@gmail.com"); // sender email
        msg.setTo(email); // receive email
        msg.setSubject("Send mail from Spring Boot"); // title
        msg.setText(message); // contents
        this.mailSender.send(msg);
    }
}
