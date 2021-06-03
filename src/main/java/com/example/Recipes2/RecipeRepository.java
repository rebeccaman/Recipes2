package com.example.Recipes2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RecipeRepository {

    @Autowired
    private DataSource dataSource;

    public List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT RECIPE.ID, RECIPE.NAME, CUISINE.NAME AS CUISINE, NUMOFINGREDIENTS,ISVEGETARIAN, DIFFICULTY.NAME AS DIFFICULTY,DESCRIPTION,INGREDIENTS,IMAGE_NAME FROM RECIPE JOIN CUISINE ON RECIPE.CUISINE_ID = CUISINE.ID JOIN DIFFICULTY ON RECIPE.DIFFICULTY_ID = DIFFICULTY.ID")) {

            while (rs.next()){
                recipes.add(rsRecipe(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipes;
    }


    public Recipe getRecipe(int id) {
        Recipe recipe = null;
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT RECIPE.ID, RECIPE.NAME, CUISINE.NAME AS CUISINE, NUMOFINGREDIENTS,ISVEGETARIAN, DIFFICULTY.NAME AS DIFFICULTY,DESCRIPTION,INGREDIENTS,IMAGE_NAME FROM RECIPE JOIN CUISINE ON RECIPE.CUISINE_ID = CUISINE.ID JOIN DIFFICULTY ON RECIPE.DIFFICULTY_ID = DIFFICULTY.ID WHERE RECIPE.ID = " + id)) {

            if (rs.next()){
                recipe = rsRecipe(rs);
            }git st

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipe;
    }

    private Recipe rsRecipe(ResultSet rs) throws SQLException {
        return new Recipe(rs.getLong("id"),
                rs.getString("name"),
                rs.getString("cuisine"), //cuisine name by a join statement
                rs.getInt("numOfIngredients"),
                rs.getBoolean("isVegetarian"),
                rs.getString("difficulty"),
                rs.getString("description"),
                rs.getString("ingredients"),
                rs.getString("image_name"));
    }


   /* public List<Recipe> getRecipes() {
        return recipes;
    }

    public Recipe getRecipe(Long id) {
        for (Recipe recipe : recipes) {
            if (recipe.getId() == id) {
                return recipe;
            }
        }
        return null;
    } */


}
