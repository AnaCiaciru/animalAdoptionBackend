package com.animal.adoption.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cat  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String gender;
    private int age;
    private String imageUrl;

    public Cat(){}

    public Cat(Long id, String name, String gender, int age, String imageUrl) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.imageUrl = imageUrl;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "cat_charac",
            joinColumns = @JoinColumn(name = "cat_id"),
            inverseJoinColumns = @JoinColumn(name = "charac_id"))
    private Set<Characteristic> characs = new HashSet<>();

    @OneToMany(mappedBy = "cat")
    private Set<CharacRating> ratings = new HashSet<>();

    public String getRatings() {
        return ratings.toString();
    }
    public void setRatings(Set<CharacRating> ratings) {
        this.ratings = ratings;
    }
    public String getCharacs() {
        return characs.toString();
    }

    public void setCharacs(Set<Characteristic> characs) {
        this.characs = characs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", imageUrl='" + imageUrl + '\'' +
                ", characs=" + characs +
                ", ratings=" + ratings +
                '}';
    }
}
