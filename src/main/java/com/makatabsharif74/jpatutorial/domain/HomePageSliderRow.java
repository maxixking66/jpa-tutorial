package com.makatabsharif74.jpatutorial.domain;

import com.makatabsharif74.jpatutorial.base.domain.BaseEntity;
import com.makatabsharif74.jpatutorial.domain.enumeration.HomePageSliderRowType;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class HomePageSliderRow extends BaseEntity<Long> {

    private String name;

    private Integer rowOrder;

    private HomePageSliderRowType rowType;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "row_id")
    private List<HomePageSliderRowSection> rowSections = new ArrayList<>();

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

    public List<HomePageSliderRowSection> getRowSections() {
        return rowSections;
    }

    public void setRowSections(List<HomePageSliderRowSection> rowSections) {
        this.rowSections = rowSections;
    }
}
