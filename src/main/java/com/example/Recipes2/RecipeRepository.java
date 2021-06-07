package com.example.Recipes2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
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
                rs.getString("difficulty"),
                rs.getString("description"),
                rs.getString("ingredients"),
                rs.getString("image_name"));
    }

/*

INSERT INTO RECIPE(NAME, CUISINE_ID, NUMOFINGREDIENTS, ISVEGETARIAN, DIFFICULTY_ID, DESCRIPTION, INGREDIENTS, IMAGE_NAME) VALUES  ('KÖTTBULLAR', (SELECT ID FROM CUISINE WHERE NAME = 'ITALIAN') ,  3, FALSE, 2, 'RECIPE TEXT', 'INGREDIENTS', 'KOTTBULLAR.PNG')
*/

    public void save(Recipe recipe) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO RECIPE(NAME, CUISINE_ID, NUMOFINGREDIENTS, ISVEGETARIAN, DIFFICULTY_ID, DESCRIPTION, INGREDIENTS, IMAGE_NAME) VALUES " +
                     " (?,(SELECT ID FROM CUISINE WHERE NAME = ?), ?,?, (SELECT ID FROM CUISINE WHERE NAME = ?), ?, ?, ?) ")) {
            ps.setString(1,recipe.getName());
            ps.setString(2, recipe.getCuisine());
            ps.setInt(3, recipe.getNumOfIngredients());
            ps.setBoolean(4, recipe.getVegetarian());
            ps.setString(5,recipe.getDifficulty());
            ps.setString(6,recipe.getDescription());
            ps.setString(7,recipe.getIngredients());
            ps.setString(8, recipe.getImageName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
