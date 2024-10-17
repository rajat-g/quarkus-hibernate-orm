package org.acme.hibernate.orm.panache.entity;

import java.io.Serial;
import java.io.Serializable;

public class Ticket implements Serializable {

    /**
     *
     */
    @Serial
    private static final long serialVersionUID = -4462015835563523624L;

    private String registrationCode;

    private double price;

    public String getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
