package com.makatabsharif74.jpatutorial.domain;

import com.makatabsharif74.jpatutorial.base.domain.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class HomePageSliderRowSection extends BaseEntity<Long> {

    private String name;

    private Integer rowOrder;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<HomePageSliderRowSectionDetail> sectionDetails = new ArrayList<>();

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

    public List<HomePageSliderRowSectionDetail> getSectionDetails() {
        return sectionDetails;
    }

    public void setSectionDetails(List<HomePageSliderRowSectionDetail> sectionDetails) {
        this.sectionDetails = sectionDetails;
    }
}
