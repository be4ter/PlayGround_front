package com.playground.common.dto;

import com.playground.common.dto.upper.AbstractDto;

import java.time.LocalDateTime;

public class Edu extends AbstractDto {
    private String eduCode;
    private String seasonCode;
    private String eduName;
    private String descript;
    private String teacherName;
    private String eduLevel;
    private String eduContents;
    private String recruitStartDate;
    private String recruitEndDate;
    private String eduStartDate;
    private String eduEndDate;
    private String eduTime;
    private String eduPlace;
    private String eduState;
    private String eduCapaity;

    public Edu(String eduName) {
        eduCode = "Test";
        seasonCode = "Test222";
        this.eduName = eduName;
        descript = "Test";
        teacherName = "Test";
        eduLevel = "Test";
        eduContents = "Test Success";
        recruitEndDate = String.valueOf(LocalDateTime.now());
        recruitStartDate = "2018-01-01";
        eduStartDate = String.valueOf(LocalDateTime.now());
        eduEndDate = "2018-12-31";
        eduTime = String.valueOf(LocalDateTime.now());
        eduPlace = "서울대 입구역 1번 출구";
        eduState = "마감";
        eduCapaity = "10";
//        setRegId("tmdghks24@naver.com");
//        setRegDt(String.valueOf(LocalDateTime.now()));
    }

    public String getEduCode() {
        return eduCode;
    }

    public void setEduCode(String eduCode) {
        this.eduCode = eduCode;
    }

    public String getSeasonCode() {
        return seasonCode;
    }

    public void setSeasonCode(String seasonCode) {
        this.seasonCode = seasonCode;
    }

    public String getEduName() {
        return eduName;
    }

    public void setEduName(String eduName) {
        this.eduName = eduName;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(String eduLevel) {
        this.eduLevel = eduLevel;
    }

    public String getEduContents() {
        return eduContents;
    }

    public void setEduContents(String eduContents) {
        this.eduContents = eduContents;
    }

    public String getRecruitStartDate() {
        return recruitStartDate;
    }

    public void setRecruitStartDate(String recruitStartDate) {
        this.recruitStartDate = recruitStartDate;
    }

    public String getRecruitEndDate() {
        return recruitEndDate;
    }

    public void setRecruitEndDate(String recruitEndDate) {
        this.recruitEndDate = recruitEndDate;
    }

    public String getEduStartDate() {
        return eduStartDate;
    }

    public void setEduStartDate(String eduStartDate) {
        this.eduStartDate = eduStartDate;
    }

    public String getEduEndDate() {
        return eduEndDate;
    }

    public void setEduEndDate(String eduEndDate) {
        this.eduEndDate = eduEndDate;
    }

    public String getEduTime() {
        return eduTime;
    }

    public void setEduTime(String eduTime) {
        this.eduTime = eduTime;
    }

    public String getEduPlace() {
        return eduPlace;
    }

    public void setEduPlace(String eduPlace) {
        this.eduPlace = eduPlace;
    }

    public String getEduState() {
        return eduState;
    }

    public void setEduState(String eduState) {
        this.eduState = eduState;
    }

    public String getEduCapaity() {
        return eduCapaity;
    }

    public void setEduCapaity(String eduCapaity) {
        this.eduCapaity = eduCapaity;
    }

    @Override
    public String getRegId() {
        return super.getRegId();
    }

    @Override
    public String getRegDt() {
        return super.getRegDt();
    }

    @Override
    public String getUptId() {
        return super.getUptId();
    }

    @Override
    public String getUptDt() {
        return super.getUptDt();
    }
}
