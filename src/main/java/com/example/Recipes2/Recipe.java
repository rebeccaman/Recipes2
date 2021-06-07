package com.example.Recipes2;

public class Recipe {
    private long id;
    private String name;
    private String cuisine;
    private int numOfIngredients;
    private Boolean isVegetarian;
    private String difficulty;
    private String description;
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
