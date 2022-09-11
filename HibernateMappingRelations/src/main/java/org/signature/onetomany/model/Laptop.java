package org.signature.onetomany.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {

    @Id
    private int lap_id;
    private String lap_name;
    @ManyToOne
    private Student student;

    public void setLap_id(int lap_id) {
        this.lap_id = lap_id;
    }

    public void setLap_name(String lap_name) {
        this.lap_name = lap_name;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lap_id=" + lap_id +
                ", lap_name='" + lap_name + '\'' +
                ", student=" + student +
                '}';
    }
}
