package com.example.Recipes2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
    public String recipe(Model model, @PathVariable int id) {
        Recipe recipe = repository.getRecipe(id);
        model.addAttribute("recipe", recipe);

        return "Recipe";
    }

    @GetMapping ("/Home/Cart")
    public String getCart(HttpSession session, @RequestParam (required = false) Integer id){
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



    @GetMapping("/Add")
    public String addRecipes(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "Form";
    }


    @PostMapping("/saveRecipe")
    public String set(@Valid Recipe recipe, BindingResult result) {
        if (result.hasErrors()) {
            return "Form";
        }
        repository.save(recipe);
        return "redirect:/Add";
    }

}