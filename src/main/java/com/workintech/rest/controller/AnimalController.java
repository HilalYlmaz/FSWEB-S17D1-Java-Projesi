package com.workintech.rest.controller;

import com.workintech.rest.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {
    @Value("${instructor.animal}")
    private String animal;
    @Value("${instructor.name}")
    private String name;

    private Map<Integer , Animal> animalMap;

    public AnimalController() {
        animalMap = new HashMap<>();
    }

    @GetMapping("/sayHi")
    public String sayHi(){
        return animal + " name is = " + name + " , welcome ";
    }

    @GetMapping("/")
   public List<Animal> get(){
        return animalMap.values().stream().toList();
   }

    @GetMapping("/{id}")
   public Animal get(@PathVariable int id){
//
        return animalMap.get(id);

   }


   @PostMapping("/")
   public Animal save(@RequestBody Animal animal){

        animalMap.put(animal.getId(), animal);
        return animalMap.get(animal.getId());
   }

    @PutMapping("/{id}")
   public Animal update(@PathVariable int id, @RequestBody Animal animal){

        animalMap.put(id, animal);
        return animalMap.get(id);

   }


    @DeleteMapping("/{id}")
   public Animal delete(@PathVariable int id){

        return animalMap.remove(id);

   }
}
