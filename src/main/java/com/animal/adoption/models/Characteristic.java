package com.animal.adoption.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "characteristics")
public class Characteristic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "charac")
    Set<CharacRating> ratings;

    public Characteristic() {
    }

    public String getRatings() {
        return ratings.toString();
    }

    public void setRatings(Set<CharacRating> ratings) {
        this.ratings = ratings;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        return name;
    }

        public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}