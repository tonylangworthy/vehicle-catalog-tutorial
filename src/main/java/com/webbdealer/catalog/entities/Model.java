package  com.webbdealer.catalog.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Data
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "models")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50, nullable = false, unique = true)
    private String name;

    @Lob
    @JsonIgnore
    private String years;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "vehicle_make_id", nullable = false)
    @JsonBackReference
    private Make make;

    @JsonManagedReference
    @OneToMany(mappedBy = "trim", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @EqualsAndHashCode.Exclude
    private Set<YearModelTrim> yearModelTrims = new HashSet<>();

    public Model() { }

    public Model(String name) {
        this.name = name;
    }

    public Model(String name, Make make) {
        this.name = name;
        this.make = make;
    }
}
