package com.animal.adoption.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
class CharacRatingKey implements Serializable {

    @Column(name = "cat_id")
    Long cattId;

    @Column(name = "charac_id")
    Long characId;

    // standard constructors, getters, and setters
    // hashcode and equals implementation

    public CharacRatingKey() {}

    public Long getCattId() {
        return cattId;
    }

    public void setCattId(Long cattId) {
        this.cattId = cattId;
    }

    public Long getCharacId() {
        return characId;
    }

    public void setCharacId(Long characId) {
        this.characId = characId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CharacRatingKey)) return false;
        CharacRatingKey that = (CharacRatingKey) o;
        return getCattId().equals(that.getCattId()) && getCharacId().equals(that.getCharacId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCattId(), getCharacId());
    }
}