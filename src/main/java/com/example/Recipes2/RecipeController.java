package com.example.Recipes2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RecipeController {

    @Autowired
    RecipeRepository repository;

    @GetMapping("/Home")
    public String recipes(Model model) {
        List<Recipe> recipes = repository.getRecipes();
        model.addAttribute("recipes", recipes);
        return "Recipes";
    }

    @GetMapping("/Home/recipe/{id}")
    public String recipe(Model model, @PathVariable Long id) {
        Recipe recipe = repository.getRecipe(id);
        model.addAttribute("recipe", recipe);

        return "Recipe";
    }

    @GetMapping ("/Home/Cart")
    public String getCart(HttpSession session, @RequestParam (required = false) Long id){
        if (id ==null){
            return "Cart";
        }
        List<Recipe> CartList = (List<Recipe>)session.getAttribute("cart");
        if (CartList == null) {
            CartList = new ArrayList<>();
            session.setAttribute("cart", CartList);
        }
        Recipe recipe = repository.getRecipe(id);
        CartList.add(recipe);
        return "redirect:/Home/Cart";
    }

}