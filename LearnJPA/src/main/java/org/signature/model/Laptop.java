package org.signature.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Laptop {
    @Id
    private int lid;
    private String l_name;
    private int price;

    public void setLid(int lid) {
        this.lid = lid;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", l_name='" + l_name + '\'' +
                ", price=" + price +
                '}';
    }
}
