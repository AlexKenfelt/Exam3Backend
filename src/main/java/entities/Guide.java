package entities;

import javax.persistence.*;
import java.io.Serializable;


@NamedQueries({
        @NamedQuery(name = "Guide.getAllRows", query = "SELECT g from Guide g")
})

@Table(name = "guide")
@Entity
public class Guide implements Serializable {

    //Varibels
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    //Constructor


    public Guide() {
    }

    public Guide(Long id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public Guide(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    //Getter and Setter


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Guide{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}