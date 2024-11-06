package ru.hogwarts.school.model;

import java.util.Objects;
@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String color;
    public Faculty() {

    }

        public Faculty(String name, String color) {
            this.name = name;
            this.color = color;
        }
    }
    public Long getId() {return id;}
    public void  setName(long id) {this.id = id;}

    public String getName() {return name;}
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {this.name = name;}

    public String getColor() {return color;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(id, faculty.id) && Objects.equals(name, faculty.name) && Objects.equals(color, faculty.color);
    }

    @Override
    public int hashCode() {return Objects.hash(id, name, color);}

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }



