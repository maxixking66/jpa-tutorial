package com.makatabsharif74.jpatutorial.domain;

import com.makatabsharif74.jpatutorial.base.domain.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedEntityGraphs(
        value = {
                @NamedEntityGraph(
                        name = HomePageSlider.FETCH_ALL_GRAPH,
                        attributeNodes = {
                                @NamedAttributeNode(value = "rows", subgraph = "rows_sub_graph")
                        }
                        ,
                        subgraphs = {
                                @NamedSubgraph(
                                        name = "rows_sub_graph",
                                        attributeNodes = {
                                                @NamedAttributeNode(value = "rowSections", subgraph = "rowSections_sub_graph")
                                        }
                                ),
                                @NamedSubgraph(
                                        name = "rowSections_sub_graph",
                                        attributeNodes = {
                                                @NamedAttributeNode(value = "sectionDetails")
                                        }
                                )
                        }
                )
        }
)
public class HomePageSlider extends BaseEntity<Long> {

    public static final String FETCH_ALL_GRAPH = "FETCH_ALL_GRAPH";

    private Boolean isActive;

    private String name;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "home_pages_slider_id")
    private Set<HomePageSliderRow> rows = new HashSet<>();

    public HomePageSlider() {
    }

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

    public Set<HomePageSliderRow> getRows() {
        return rows;
    }

    public void setRows(Set<HomePageSliderRow> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "HomePageSlider{" +
                "id=" + getId() + ", " +
                "rows=" + rows +
                '}';
    }
}
