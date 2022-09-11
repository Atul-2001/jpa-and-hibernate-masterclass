package org.signature.manytomany.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Laptop {

    @Id
    private int lap_id;
    private String lap_name;
    @ManyToMany
    private List<Student> student;

    public Laptop() {
        student = new ArrayList<>();
    }

    public void setLap_id(int lap_id) {
        this.lap_id = lap_id;
    }

    public void setLap_name(String lap_name) {
        this.lap_name = lap_name;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public List<Student> getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lap_id=" + lap_id +
                ", lap_name='" + lap_name + '\'' +
                '}';
    }
}
