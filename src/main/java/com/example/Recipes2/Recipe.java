package com.example.Recipes2;

public class Recipe {
    private long id;
    private String name;
    private Cuisine cuisine;
    private int numOfIngredients;
    private boolean isVegetarian;
    private Difficulty difficulty;
    private String description;
    private String ingredients;
    private String imageName;

    public Recipe (Long id, String name, Cuisine cuisine, Integer numOfIngredients,
                   boolean isVegetarian, Difficulty difficulty, String description, String ingredients, String imageName) {
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

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public int getNumOfIngredients() {
        return numOfIngredients;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public Difficulty getDifficulty() {
        return difficulty;
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
