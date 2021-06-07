package com.example.Recipes2;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class Recipe {
    private long id;
    @Size(min=1,max=100)
    private String name;
    @Size(min=1,max=100)
    private String cuisine;
    @Positive
    private int numOfIngredients;
    private Boolean isVegetarian;
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

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumOfIngredients() {
        return numOfIngredients;
    }


    public Boolean getIsVegetarian() {
        return isVegetarian;
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
