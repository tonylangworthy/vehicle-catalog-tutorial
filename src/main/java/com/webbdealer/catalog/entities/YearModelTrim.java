package com.webbdealer.catalog.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "year_model_trim")
public class YearModelTrim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "year", length = 4, nullable = false)
    private String year;

//    @JsonBackReference
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "make_id", nullable = false)
//    private Make make;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trim_id", nullable = false)
    private Trim trim;

//    @JsonManagedReference
//    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
//    @JoinTable(
//        name = "ymm_trim",
//        joinColumns = @JoinColumn(name = "ymm_id"),
//        inverseJoinColumns = @JoinColumn(name = "trim_id"))
//    private Set<Trim> trims = new HashSet<>();

//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @OneToMany(mappedBy = "yearModelTrim", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//    @JsonManagedReference
//    private Set<Vehicle> vehicles = new HashSet<>();
//
//    @EqualsAndHashCode.Exclude
//    @OneToMany(mappedBy = "yearModelTrim", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//    @JsonManagedReference
//    private Set<Style> styles = new HashSet<>();
//
    public YearModelTrim() { }

    public YearModelTrim(String year, Model model, Trim trim) {
        this.year = year;
        this.model = model;
        this.trim = trim;
    }

}
