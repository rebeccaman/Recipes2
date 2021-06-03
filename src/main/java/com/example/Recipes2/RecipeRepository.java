package com.example.Recipes2;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RecipeRepository {
    private List<Recipe> recipes;


    public RecipeRepository() {
        recipes = new ArrayList<>();
        recipes.add(new Recipe(1L, "Pasta Carbonara", Cuisine.ITALIAN, 5, false, Difficulty.EASY, "1. Fry the garlic with the bacon. " +
                "2. Whip the egg and cream and pour it over the bacon. 3. Cook the pasta 4. Mix all together 5. Serve!", "Bacon, Cream, Egg, Pasta, Garlic", "Carbonara.png"));
        recipes.add(new Recipe(2L, "Hamburger", Cuisine.AMERICAN, 4, false, Difficulty.EASY, "1. Mix the meat with spices and form 4 burgers." +
                "2. Fry in oil or butter 2-3 minutes on each side. 3. Roast the bread and accesories of your choice.", "Meat, bread", "Hamburger.png"));
        recipes.add(new Recipe(3L, "Manhattansalad", Cuisine.AMERICAN, 3,true, Difficulty.EASY, "1. Rince the sladleafs and put on a plate. Add orange, pepper sellery and nuts" +
                "2. Put the fruit and vegetables on the salad 3. Add the dressing.", "Salad, oranges,pepper, selleri, dressing", "Manhattansalad.png"));
        recipes.add(new Recipe(4L, "Ratatouille", Cuisine.FRENCH, 8, true, Difficulty.MEDIUM, "1. Cook and stir garlic and eggplant in olive oil until eggplant is soft. 2. Spread eggplant mixture evenly on the bottom of the dish. Sprinkle with Parmesan cheese. 3. Continue layering in this fashion, with onion, mushrooms, zucchini, and tomatoes, covering each layer with a sprinkling of salt and cheese.", "Garlic, Eggplant, Olive oil, Zucchini, Tomato, Parmesan, Onion, Mushroom", "Ratatouille.png"));
        recipes.add(new Recipe(5L, "French Onion Soup",Cuisine.FRENCH,  9, true, Difficulty.MEDIUM, "1. Cook onions in butter and olive oil until tender and translucent, not brown. 2. Add vegetarian broth and sherry. 3.Distribute the soup into small bowls, place one slice of bread in each bowl. 4. On top of the bread add three layers of cheese: Provolone, Swiss and Parmesan. Have it in the oven until the cheese is crispy brown.", "Butter, Olive oil, Onions, Vegetarian broth, Sherry, Bread, Provolone cheese, Swiss cheese, Parmesan Cheese", "FrenchOnionSoup.png"));
        recipes.add(new Recipe(6L, "Paneer Butter Masala", Cuisine.ASIAN, 6,  true, Difficulty.MEDIUM, "1. Fry the garlic and panner with butter. " +
                "2. Add the curry mix to the pan and spices as per taste. 3. Cook the curry well 4. Mix all together 5. Serve!", "Panner, Cream, Asian curry masala, Indian Spices, Garlic,butter", "Paneerbuttermasala.jpg"));
        recipes.add(new Recipe(7L, "Asian Dumplings", Cuisine.ASIAN, 5, true, Difficulty.MEDIUM, "1.Chop all the veggies & chilli. " +
                "2. Make a dough with flour, adding salt and roll them into small circles. 3. Add the veggies, salt, pepper to the circles and shape them to a dumpling 4. Steam them for 20 mins 5. Serve hot!", "Vegies, All purpose Flour,Green chilli, Salt, Pepper", "AsianDumplings.jpg"));
        recipes.add(new Recipe(8L, "Spagetti Pomodoro", Cuisine.ITALIAN, 6, true, Difficulty.EASY, "1. Chop onoin and fry it in a caserol with some butter. 2 Add sugar and tomatoes " +
                "3. Add half of the basil and let it cook for 5-10 min. 4. Cook the pasta. 5. Mix the pasta and the sauce 6. Serve with mozzarella and rest of the basil", "Garlic, Butter, Sugar, Basil, Pasta, Mozarella", "SpagettiPomodoro.png"));
        recipes.add(new Recipe(9L, "Risotto", Cuisine.ITALIAN, 7, true, Difficulty.MEDIUM, "1. Cook the broth and keep it warm. 2. Chop onion and garlic. Fry  with butter for 10 min. Add the rise and fry additionally 10 min." +
                "3. Turn upp the heat and add wine and some of the broth. Stirr often! Once the fluid is gone - add more broth. 4. Keep adding broth until it is finished and the rice is creamy. 5. Add the rest of the butter and the cheese. Serve immedietly!", "Arboriorice, Vegetable broth, Yellow Onion, Garlic, Butter, White Wine, Parmesan","Risotto.png"));
        recipes.add(new Recipe(10L, "Salsa Chicken", Cuisine.MEXICAN, 5, false, Difficulty.EASY, "1. Preheat oven to 375 degrees F. 2. Sprinkle taco seasoning on both sides of chicken breasts, and pour salsa over all" +
                "Bake in the oven for 25-35 minutes or until chicken is tender. 4. Sprinkle chicken evenly with cheese and continue baking for 3-5 minutes. 5. Top with sour cream and serve with rice.", "Chicken breasts, Taco Seasoning Mix, Salsa, Cheddar Cheese, Sour Cream","SalsaChicken.png"));
        recipes.add(new Recipe(11L, "Chorizo Street Tacos", Cuisine.MEXICAN, 5, false, Difficulty.MEDIUM, "1. Remove chorizo case and cruble the meet 2. Mix chorizo and chipotle peppers in adobo sauce together in a bowl" +
                "3. Het a skillet over medium high heat, add chorizo mixture and cook until cripp (5-7 min). Transfer chorizo to a plate, reserving grease in the skillet. 4. Heat tortillas in the grease until warm. Fill with chorizo, onion and cilantro", "Chorizo Sausage, Chipotle Peppers in Adobo Sauce, Corn Tortillas, Onoin, Cilantro","ChorizoStreetTacos.png"));
        recipes.add(new Recipe(12L, "American Pancakes", Cuisine.AMERICAN, 7, true, Difficulty.DIFFICULT, "1. Sift the flour, baking poweder, salt and caster sugar into a large bowl. 2. Whisk with milk, egg and melted butter. 3. Add a knob of butter in a medium heated  frying pan. Add a ladle of batter and wait until it starts bubbling. " +
                "Turn it over and cook until both sides are golden brown. 4. Repeat until all batter is used up. 5. Serve with maple syrup and extra butter!", "Flour, Baking Powder, Salt, Sugar, Milk, Egg, Butter", "AmericanPancakes.jpg"));

    }

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
}
