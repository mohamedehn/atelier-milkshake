package com.exerciceMilkeshake.Milekshake.repository;

import com.exerciceMilkeshake.Milekshake.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
}
