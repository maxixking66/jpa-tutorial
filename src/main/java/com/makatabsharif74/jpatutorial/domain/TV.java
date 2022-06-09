package com.makatabsharif74.jpatutorial.domain;

import javax.persistence.Entity;

@Entity
public class TV extends Electronic {

    private Integer inch;

    public Integer getInch() {
        return inch;
    }

    public void setInch(Integer inch) {
        this.inch = inch;
    }

    @Override
    public String toString() {
        return "TV{" +
                super.toString() + ", " +
                "inch=" + inch +
                '}';
    }
}
