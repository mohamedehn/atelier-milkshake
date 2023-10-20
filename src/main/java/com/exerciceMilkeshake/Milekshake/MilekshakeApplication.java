package com.exerciceMilkeshake.Milekshake;

import com.exerciceMilkeshake.Milekshake.entity.Recipe;
import com.exerciceMilkeshake.Milekshake.entity.Saler;
import com.exerciceMilkeshake.Milekshake.repository.RecipeRepository;
import com.exerciceMilkeshake.Milekshake.repository.SalerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MilekshakeApplication {

	public RecipeRepository recipeRepository;
	public SalerRepository salerRepository;

	public MilekshakeApplication(RecipeRepository recipeRepository, SalerRepository salerRepository){
		this.recipeRepository = recipeRepository;
		this.salerRepository = salerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MilekshakeApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() throws Exception{
		return (String[] args) ->{
			//ajouter des recettes à l'initialisation du serveur
			recipeRepository.save(new Recipe(1, "Milkshake fraise", 3, "fraise"));
			recipeRepository.save(new Recipe(2, "Milkshake banane", 6, "banane"));
			recipeRepository.save(new Recipe(3, "Milkshake poire", 7, "poire"));
			recipeRepository.save(new Recipe(4, "Milkshake chocolat", 2, "chocolat"));
			//ajouter des vendeurs à l'initialisation du serveur
			salerRepository.save(new Saler(1, "John", 30));
			salerRepository.save(new Saler(2, "Steve", 25));
		};
	}

}


