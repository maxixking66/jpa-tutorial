package com.makatabsharif74.jpatutorial.domain;

import com.makatabsharif74.jpatutorial.base.domain.BaseEntity;
import com.makatabsharif74.jpatutorial.domain.enumeration.HomePageSliderRowType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class HomePageSliderRow extends BaseEntity<Long> {

    private String name;

    private Integer rowOrder;

    @Enumerated(value = EnumType.STRING)
    private HomePageSliderRowType rowType;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "row_id")
    private Set<HomePageSliderRowSection> rowSections = new HashSet<>();

    public HomePageSliderRow() {
    }

    public HomePageSliderRow(Set<HomePageSliderRowSection> rowSections) {
        this.rowSections = rowSections;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRowOrder() {
        return rowOrder;
    }

    public void setRowOrder(Integer rowOrder) {
        this.rowOrder = rowOrder;
    }

    public HomePageSliderRowType getRowType() {
        return rowType;
    }

    public void setRowType(HomePageSliderRowType rowType) {
        this.rowType = rowType;
    }

    public Set<HomePageSliderRowSection> getRowSections() {
        return rowSections;
    }

    public void setRowSections(Set<HomePageSliderRowSection> rowSections) {
        this.rowSections = rowSections;
    }

    @Override
    public String toString() {
        return "HomePageSliderRow{" +
                "id=" + getId() + ", " +
                "rowSections=" + rowSections +
                '}';
    }
}
