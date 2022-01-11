package dtos;

import entities.Member;

public class MemberDTO {
    private Integer id;
    private String name;
    private String email;
    private int memberNr;
    private boolean isMemberActive;



    public MemberDTO(Member member) {
        this.name = member.getName();
        this.email = member.getEmail();
    }

    public MemberDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMemberNr() {
        return memberNr;
    }

    public void setMemberNr(int memberNr) {
        this.memberNr = memberNr;
    }

    public boolean isMemberActive() {
        return isMemberActive;
    }

    public void setMemberActive(boolean memberActive) {
        isMemberActive = memberActive;
    }
}
