package com.exerciceMilkeshake.Milekshake.controller;

import com.exerciceMilkeshake.Milekshake.entity.Recipe;
import com.exerciceMilkeshake.Milekshake.repository.RecipeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RecipeController {

    //Injection de dépendance
    public final RecipeRepository repository;
    public RecipeController(RecipeRepository injectedRepository){
        this.repository = injectedRepository;
    }


    //route qui récupère l'ensemble des recettes
    @GetMapping("/recipes")
    public List <Recipe> getAllRecipe(){
        List<Recipe> recipes = repository.findAll();
        if(!recipes.isEmpty()){
            return recipes;
        }else {
            throw new RuntimeException("There is nos recipes");
        }
    }

    // route qui récupère une recette en fonction de l'id
    @GetMapping("/recipe/{id}")
    public Recipe getRecipe(@PathVariable int id){
        Optional<Recipe> recipe = repository.findById(id);
        if (recipe.isPresent()){
            return recipe.get();
        }else {
            throw new RuntimeException("The recipe number" +" " +id +" " +"doesn't exist!");
        }

    }

    // route pour ajouter une recette
    @PostMapping("/recipe/add")
    public void createRecipe(@RequestBody Recipe recipe){
        repository.save(recipe);
    }

    // Route pour supprimer une recette
    @DeleteMapping("/recipe/{id}")
    public void deleteRecipe(@PathVariable int id){
        Optional<Recipe> recipe = repository.findById(id);
        if (recipe.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("The recipe number" +" " +id +" " +"wasn't found!");
        }
    }

    // route pour modifier une recette
    @PutMapping("/recipe/update/{id}")
    public Recipe updateRecipe(@PathVariable int id, @RequestBody Recipe recipe){
        Optional <Recipe> recipeToUpdate = repository.findById(id);
        if (recipeToUpdate.isPresent()) {
            Recipe recipeUpdated = recipeToUpdate.get();
            recipeUpdated.setName(recipe.getName());
            recipeUpdated.setQuantity(recipe.getQuantity());
            recipeUpdated.setMainIngredient(recipe.getMainIngredient());
            return repository.save(recipeUpdated);
        }else {
            throw new RuntimeException("The recipe number" +" " +id +" " +"wasn't found!");
        }
    }
}
