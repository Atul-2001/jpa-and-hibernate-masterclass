package org.signature.manytoone.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    private int rollNo;
    private String name;
    private int percentage;
    @OneToMany(mappedBy = "student")
    private List<Laptop> laptop;

    public Student() {
        laptop = new ArrayList<>();
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public void setLaptop(List<Laptop> laptop) {
        this.laptop = laptop;
    }

    public List<Laptop> getLaptop() {
        return laptop;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}
