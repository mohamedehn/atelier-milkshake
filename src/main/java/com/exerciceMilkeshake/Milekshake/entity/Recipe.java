package com.exerciceMilkeshake.Milekshake.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column
    private String name;
    @Column
    private int quantity;
    @Column
    private String mainIngredient;

    public Recipe(){}

    public Recipe(int id, String name, int quantity, String mainIngredient){
        super();
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.mainIngredient = mainIngredient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMainIngredient() {
        return mainIngredient;
    }

    public void setMainIngredient(String mainIngredient) {
        this.mainIngredient = mainIngredient;
    }

    @Override
    public String toString(){
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                ", mainIngredient='" + mainIngredient + '\'' +
                '}';
    }
}
