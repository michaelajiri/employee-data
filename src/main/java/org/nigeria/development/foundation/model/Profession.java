package org.nigeria.development.foundation.model;

import javax.persistence.*;

@Entity
public class Profession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String professionName;

    public Profession() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfessionType() {
        return professionName;
    }

    public void setProfessionType(String professionName) {
        this.professionName = professionName;
    }

    @Override
    public String toString() {
        return "Profession{" +
                "id=" + id +
                ", professionName='" + professionName + '\'' +
                '}';
    }
}