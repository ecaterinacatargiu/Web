package Model;

import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public class UserProfile {

    private String name;
    private String email;
    private String picture;
    private String age;
    private String hometown;
    private String password;

    public UserProfile(String name, String email, String picture, String age, String hometown, String password)
    {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.age = age;
        this.hometown = hometown;
        this.password = password;
    }


    public UserProfile()
    {

    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPicture() {
        return picture;
    }

    public String getAge() {
        return age;
    }

    public String getHometown() {
        return hometown;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", picture='" + picture + '\'' +
                ", age=" + age +
                ", hometown='" + hometown + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserProfile)) return false;
        UserProfile that = (UserProfile) o;
        return
                Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(picture, that.picture) &&
                Objects.equals(age, that.age) &&
                Objects.equals(hometown, that.hometown);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, picture, age, hometown);
    }
}
