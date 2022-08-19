package com.technicalTestApi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Document(collection = "tutorials")
public class Product implements Serializable {
    @Id
    private String id;
    private String nom;
    private Integer price;

    public Product() {
    }

    public Product(String id, String nom, Integer price) {
        this.id = id;
        this.nom = nom;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
