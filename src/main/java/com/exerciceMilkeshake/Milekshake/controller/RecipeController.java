package com.exerciceMilkeshake.Milekshake.controller;

import com.exerciceMilkeshake.Milekshake.entity.Recipe;
import com.exerciceMilkeshake.Milekshake.repository.RecipeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {

    //Injection de dépendance
    public final RecipeRepository repository;
    public RecipeController(RecipeRepository injectedRepository){
        this.repository = injectedRepository;
    }

    // ici on injectera les recette de bases déjà présente
    @GetMapping("/")
    public String init() {
        repository.save(new Recipe(1, "Milkshake fraise", 3, "fraise"));
        repository.save(new Recipe(2, "Milkshake banane", 6, "banane"));
        repository.save(new Recipe(3, "Milkshake poire", 7, "poire"));
        repository.save(new Recipe(4, "Milkshake chocolat", 2, "chocolat"));

        return "Recettes déjà présentes!";
    }

    //route qui récupère l'ensemble des recettes
    @GetMapping("/recipes")
    public List <Recipe> getAllRecipe(){
        List<Recipe> recipes = repository.findAll();
        return recipes;
    }

    // route qui récupère une recette en fonction de l'id
    @GetMapping("/recipe/{id}")
    public Recipe getRecipe(@PathVariable int id){
        Recipe recipe = repository.findById(id).get();
        return recipe;
    }

    // route pour ajouter une recette
    @PostMapping("/recipe/add")
    public void createRecipe(@RequestBody Recipe recipe){
        repository.save(recipe);
    }

    // Route pour supprimer une recette
    @DeleteMapping("/recipe/{id}")
    public boolean deleteRecipe(@PathVariable int id){
        repository.deleteById(id);
        return true;
    }

    // route pour modifier une recette
    @PutMapping("/recipe/update/{id}")
    public Recipe updateRecipe(@PathVariable int id, @RequestBody Recipe recipe){
        Recipe recipeToUpdate = repository.findById(id).get();
        recipeToUpdate.setName(recipe.getName());
        recipeToUpdate.setQuantity(recipe.getQuantity());
        recipeToUpdate.setMainIngredient(recipe.getMainIngredient());
        return repository.save(recipeToUpdate);
    }
}
