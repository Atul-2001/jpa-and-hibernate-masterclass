package org.signature.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Lap") //if table name was not assigned then final table name is Lap if assigned then taken form @Table
@Table(name = "LapTable")
public class Laptop {
    @Id
    @GeneratedValue
    private int lid;
    private String lname;
    private int price;

    public void setLid(int lid) {
        this.lid = lid;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", lname='" + lname + '\'' +
                ", price=" + price +
                '}';
    }
}
