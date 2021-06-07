package com.example.Recipes2;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class Recipe {
    private long id;
    @Size(min=1,max=100)
    private String name;
    @Size(min=1,max=100)
    private String cuisine;
    @PositiveOrZero
    private int numOfIngredients;
    private Boolean isVegetarian = false;
    @Size(min=1,max=100)
    private String difficulty;
    @Size(min=1,max=1000)
    private String description;
    @Size(min=1,max=100)
    private String ingredients;
    private String imageName;


    public Recipe(long id, String name, String cuisine, int numOfIngredients, Boolean isVegetarian, String difficulty, String description, String ingredients, String imageName) {
        this.id = id;
        this.name = name;
        this.cuisine = cuisine;
        this.numOfIngredients = numOfIngredients;
        this.isVegetarian = isVegetarian;
        this.difficulty = difficulty;
        this.description = description;
        this.ingredients = ingredients;
        this.imageName = imageName;
    }

    public Recipe() {};

    public String getCuisine() {
        return cuisine;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public void setNumOfIngredients(int numOfIngredients) {
        this.numOfIngredients = numOfIngredients;
    }

    public Boolean getVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumOfIngredients() {
        return numOfIngredients;
    }




    public String getDescription() {
        return description;
    }

    public String getIngredients() {
        return ingredients;
    }
    public String getImageName() {
        return imageName;
    }
}
