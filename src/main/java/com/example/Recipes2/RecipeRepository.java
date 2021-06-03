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
             ResultSet rs = stmt.executeQuery("SELECT id, title, author, price FROM book")) {

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
             ResultSet rs = stmt.executeQuery("SELECT id, title, author, price FROM book WHERE id = " + id)) {

            if (rs.next()){
                recipe = rsRecipe(rs);
            }

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
                rs.getString("difficulty_id"),
                rs.getString("description"),
                rs.getString("ingredients"),
                rs.getString("image_name"));
    }

    /*
    public List<Recipe> getRecipes() {
        return recipes;
    }

    public Recipe getRecipe(Long id) {
        for (Recipe recipe : recipes) {
            if (recipe.getId() == id) {
                return recipe;
            }
        }
        return null;
    }

     */
}
