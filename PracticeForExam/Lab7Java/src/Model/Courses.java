package Model;

import java.util.Objects;

public class Courses {

    private int id;
    private int professorid;
    private String name;
    private String participants;
    private String grades;

    public Courses(int id, int professorid, String name, String participants, String grades) {
        this.id = id;
        this.professorid = professorid;
        this.name = name;
        this.participants = participants;
        this.grades = grades;
    }


    public Courses()
    {

    }

    public int getId() {
        return id;
    }

    public int getProfessorid() {
        return professorid;
    }

    public String getName() {
        return name;
    }

    public String getParticipants() {
        return participants;
    }

    public String getGrades() {
        return grades;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProfessorid(int professorid) {
        this.professorid = professorid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", professorid=" + professorid +
                ", name='" + name + '\'' +
                ", participants='" + participants + '\'' +
                ", grades='" + grades + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Courses)) return false;
        Courses courses = (Courses) o;
        return id == courses.id &&
                professorid == courses.professorid &&
                Objects.equals(name, courses.name) &&
                Objects.equals(participants, courses.participants) &&
                Objects.equals(grades, courses.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, professorid, name, participants, grades);
    }
}
