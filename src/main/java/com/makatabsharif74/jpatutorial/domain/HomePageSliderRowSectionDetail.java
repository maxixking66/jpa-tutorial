package com.makatabsharif74.jpatutorial.domain;

import com.makatabsharif74.jpatutorial.base.domain.BaseEntity;

import javax.persistence.Entity;

@Entity
public class HomePageSliderRowSectionDetail extends BaseEntity<Long> {

    private String image;

    private String link;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "HomePageSliderRowSectionDetail{" + getId() + "}";
    }
}
