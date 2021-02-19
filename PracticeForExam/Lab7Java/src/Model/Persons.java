package Model;

import java.util.Objects;

public class Persons {

    private int id;
    private String name;
    private String role;

    public Persons(int id, String name, String role)
    {
        this.id = id;
        this.name = name;
        this.role  = role;
    }

    public Persons()
    {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persons)) return false;
        Persons persons = (Persons) o;
        return id == persons.id &&
                Objects.equals(name, persons.name) &&
                Objects.equals(role, persons.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role);
    }
}
