package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("workintech/animal")
public class AnimalController {
    private Map<Integer, Animal> animals = new HashMap<>();

    @GetMapping
    public List<Animal> getAllAnimals(){
        return new ArrayList<>(animals.values());
    }

    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable int id){
        return animals.get(id);
    }

    @PostMapping()
    public void addAnimal(@RequestBody Animal newAnimal){
        animals.put(newAnimal.getId(),newAnimal);
    }

    @PutMapping("/{id}")
    public void updateAnimal(@PathVariable int id, @RequestBody Animal updatedAnimal){
        animals.put(updatedAnimal.getId(),updatedAnimal);
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable int id) {
        animals.remove(id);
    }
}
