package springboot.boot2.model;

import jakarta.persistence.*;
import java.util.Objects;
import jakarta.validation.constraints.*;
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 11, message = "Name should be between 2 to 11")
    private String name;

    @Column(name = "age")
    private long age;

    @Column(name = "pet")
    private String pet;

    @Column(name = "hobby")
    @NotEmpty(message = "hobby should be empty")
    private String hobby;

    public User(String name, int age, String pet, String hobby) {
        this.name = name;
        this.age = age;
        this.pet = pet;
        this.hobby = hobby;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && Objects.equals(name, user.name) && Objects.equals(pet, user.pet) && Objects.equals(hobby, user.hobby);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, pet, hobby);
    }
}
