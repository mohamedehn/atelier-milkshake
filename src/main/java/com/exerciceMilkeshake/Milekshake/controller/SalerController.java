package com.exerciceMilkeshake.Milekshake.controller;

import com.exerciceMilkeshake.Milekshake.entity.Recipe;
import com.exerciceMilkeshake.Milekshake.entity.Saler;
import com.exerciceMilkeshake.Milekshake.repository.SalerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalerController {

    //injection de dépendance
    public final SalerRepository repository;
    public SalerController(SalerRepository injectedRepository){
        this.repository = injectedRepository;
    }

    // ici on injectera les vendeurs de bases déjà présents
    @GetMapping("/allsalers")
    public String init() {
        repository.save(new Saler(1, "John", 30));
        repository.save(new Saler(2, "Steve", 25));

        return "Vendeurs présents!";
    }

    //route qui récupère l'ensemble des vendeurs
    @GetMapping("/salers")
    public List<Saler> getAllSaler(){
        List<Saler> salers = repository.findAll();
        return salers;
    }

    // route qui récupère un vendeur en fonction de l'id
    @GetMapping("/saler/{id}")
    public Saler getSaler(@PathVariable int id){
        Saler saler = repository.findById(id).get();
        return saler;
    }

    // route pour ajouter un vendeur
    @PostMapping("/saler/add")
    public void createSaler(@RequestBody Saler saler){
        repository.save(saler);
    }

    // Route pour supprimer un vendeur
    @DeleteMapping("/saler/{id}")
    public boolean deleteSaler(@PathVariable int id){
        repository.deleteById(id);
        return true;
    }

    // route pour modifier un vendeur
    @PutMapping("/saler/update/{id}")
    public Saler updateSaler(@PathVariable int id, @RequestBody Saler saler){
        Saler salerToUpdate = repository.findById(id).get();
        salerToUpdate.setName(saler.getName());
        salerToUpdate.setAge(saler.getAge());
        return repository.save(salerToUpdate);
    }
}
