package entities;

import javax.persistence.*;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;
    private String email;
    private int memberNr;
    private boolean isMemberActive;

    @ManyToOne
    private FitnessCenter fitnessCenter;

    public Member() {
    }

    public Member(Integer id, String name, String email, int memberNr, boolean isMemberActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.memberNr = memberNr;
        this.isMemberActive = isMemberActive;
    }

    public Member(String name, String email) {
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

    public FitnessCenter getFitnessCenter() {
        return fitnessCenter;
    }

    public void setFitnessCenter(FitnessCenter fitnessCenter) {
        this.fitnessCenter = fitnessCenter;
    }
}
