package com.playground.common.dto;

import com.playground.common.dto.upper.AbstractDto;

import java.time.LocalDateTime;
import java.util.Random;

public class Member extends AbstractDto {

    private String memberid;
    private String memberName;
    private String mobile1;
    private String mobile2;
    private String email;
    private String emailDomain;
    private String emailAuth;
    private String passwd;
    private String memberType;
    private String lastLogin;
    private String refundBanknm;
    private String refundAccount;
    private String refundName;
    private String authCode;

    public Member() {

    }

    public Member(String email, String password, String name, String memberType) {
        String[] emails = email.split("@");
        memberid = emails[0];
        memberName = name;
        mobile1 = "010";
        mobile2 = "12345678";
        this.email = emails[0];
        emailDomain = emails[1];
        emailAuth = "false";
        passwd = password;
        this.memberType = memberType;
        setRegDt(String.valueOf(LocalDateTime.now()));
        setRegId(email);
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        this.authCode = String.valueOf(random.nextLong());
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMobile1() {
        return mobile1;
    }

    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }

    public String getMobile2() {
        return mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailDomain() {
        return emailDomain;
    }

    public void setEmailDomain(String emailDomain) {
        this.emailDomain = emailDomain;
    }

    public String getEmailAuth() {
        return emailAuth;
    }

    public void setEmailAuth(String emailAuth) {
        this.emailAuth = emailAuth;
    }


    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getRefundBanknm() {
        return refundBanknm;
    }

    public void setRefundBanknm(String refundBanknm) {
        this.refundBanknm = refundBanknm;
    }

    public String getRefundAccount() {
        return refundAccount;
    }

    public void setRefundAccount(String refundAccount) {
        this.refundAccount = refundAccount;
    }

    public String getRefundName() {
        return refundName;
    }

    public void setRefundName(String refundName) {
        this.refundName = refundName;
    }

    public boolean equalsPassword(String password) {
        return this.passwd.equals(password);
    }

    public boolean authMember() {
        return emailAuth.equals("true");
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public boolean isVerifyAuthNumber(Long number) {
        System.out.println("number : " + number);
        if (this.authCode.equals(String.valueOf(number))) {
            this.emailAuth = "true";
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberid='" + memberid + '\'' +
                ", memberName='" + memberName + '\'' +
                ", mobile1='" + mobile1 + '\'' +
                ", mobile2='" + mobile2 + '\'' +
                ", email='" + email + '\'' +
                ", emailDomain='" + emailDomain + '\'' +
                ", emailAuth='" + emailAuth + '\'' +
                ", passwd='" + passwd + '\'' +
                ", memberType='" + memberType + '\'' +
                ", lastLogin='" + lastLogin + '\'' +
                ", refundBanknm='" + refundBanknm + '\'' +
                ", refundAccount='" + refundAccount + '\'' +
                ", refundName='" + refundName + '\'' +
                ", authCode=" + authCode +
                '}';
    }
}
