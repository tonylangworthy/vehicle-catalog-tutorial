package com.webbdealer.catalog.entities;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "trims")
public class Trim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50, nullable = false, unique = true)
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "trim", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @EqualsAndHashCode.Exclude
    private Set<YearModelTrim> yearModelTrims = new HashSet<>();

    public Trim() {}

    public Trim(String name) {
        this.name = name;
    }

}
