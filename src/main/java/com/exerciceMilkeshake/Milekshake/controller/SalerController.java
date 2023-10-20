package com.exerciceMilkeshake.Milekshake.controller;

import com.exerciceMilkeshake.Milekshake.entity.Saler;
import com.exerciceMilkeshake.Milekshake.repository.SalerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SalerController {

    //injection de dépendance
    public final SalerRepository repository;
    public SalerController(SalerRepository injectedRepository){
        this.repository = injectedRepository;
    }


    //route qui récupère l'ensemble des vendeurs
    @GetMapping("/salers")
    public List<Saler> getAllSaler(){
        List<Saler> salers = repository.findAll();
        if (!salers.isEmpty()){
            return salers;
        }else {
            throw new RuntimeException("There is nos salers");
        }
    }

    // route qui récupère un vendeur en fonction de l'id
    @GetMapping("/saler/{id}")
    public Saler getSaler(@PathVariable int id){
        Optional<Saler> saler = repository.findById(id);
        if (saler.isPresent()){
            return saler.get();
        }else {
            throw new RuntimeException("The saler number" +" " +id +" " +"doesn't exist!");
        }
    }

    // route pour ajouter un vendeur
    @PostMapping("/saler/add")
    public void createSaler(@RequestBody Saler saler){
        repository.save(saler);
    }

    // Route pour supprimer un vendeur
    @DeleteMapping("/saler/{id}")
    public void deleteSaler(@PathVariable int id){
        Optional<Saler> saler = repository.findById(id);
        if (saler.isPresent()){
            repository.deleteById(id);
        }else {
            throw new RuntimeException("The saler number" +" " +id +" " +"wasn't found!");
        }
    }

    // route pour modifier un vendeur
    @PutMapping("/saler/update/{id}")
    public Saler updateSaler(@PathVariable int id, @RequestBody Saler saler){
        Optional<Saler> salerToUpdate = repository.findById(id);
        if (salerToUpdate.isPresent()){
            Saler salerUpdated = salerToUpdate.get();
            salerUpdated.setName(saler.getName());
            salerUpdated.setAge(saler.getAge());
            return repository.save(salerUpdated);
        }else {
            throw new RuntimeException("The saler number" +" " +id +" " +"wasn't found!");
        }
    }
}
