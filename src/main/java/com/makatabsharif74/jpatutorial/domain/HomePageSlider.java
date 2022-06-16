package com.makatabsharif74.jpatutorial.domain;

import com.makatabsharif74.jpatutorial.base.domain.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class HomePageSlider extends BaseEntity<Long> {

    private Boolean isActive;

    private String name;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<HomePageSliderRow> rows = new ArrayList<>();

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<HomePageSliderRow> getRows() {
        return rows;
    }

    public void setRows(List<HomePageSliderRow> rows) {
        this.rows = rows;
    }
}
