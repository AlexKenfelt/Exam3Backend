package dtos;

import entities.Guide;

public class GuideDTO {
    //Variables
    private Long id;
    private String name;
    private String gender;

    //Constructors


    public GuideDTO(Long id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public GuideDTO(Guide guide) {
        this.id = guide.getId();
        this.name = guide.getName();
        this.gender = guide.getGender();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "GuideDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
