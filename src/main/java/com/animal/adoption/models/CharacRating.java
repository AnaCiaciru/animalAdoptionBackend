package com.animal.adoption.models;

import javax.persistence.*;

@Entity
public class CharacRating {
    @EmbeddedId
    CharacRatingKey id;

    @ManyToOne
    @MapsId("catId")
    @JoinColumn(name = "cat_id")
    Cat cat;

    @ManyToOne
    @MapsId("characId")
    @JoinColumn(name = "charac_id")
    Characteristic charac;

    int rating;

    public CharacRating() {}

    public CharacRatingKey getId() {
        return id;
    }

    public void setId(CharacRatingKey id) {
        this.id = id;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Characteristic getCharac() {
        return charac;
    }

    public void setCharac(Characteristic charac) {
        this.charac = charac;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return new String(String.valueOf(rating));
    }
}
