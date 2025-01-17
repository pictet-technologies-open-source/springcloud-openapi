package com.pictet.training_springcloud.producer.controller;

import com.pictet.training_springcloud.producer.model.Pet;
import com.pictet.training_springcloud.producer.exception.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
@RequestMapping("/api/pet")
public class PetStoreController {

    private Map<Integer, Pet> petStore = new ConcurrentHashMap<>();
    {
        petStore.put(1, new Pet(1, "Rantanplan"));
    }

    @GetMapping(produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    public Collection<Pet> getAllPets() {
        return petStore.values();
    }

    @GetMapping(value = "/{id}", produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    public Pet getPetById(
            @Parameter(description="Id of the pet to be obtained. Cannot be empty", required=true)
            @PathVariable int id) {
        if (!this.petStore.containsKey(id)) {
            throw new ResourceNotFoundException();
        }
        return this.petStore.get(id);
    }

    @DeleteMapping(value = "/{id}", produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    public void deletePetById(
            @Parameter(description = "Id of the pet to be deleted. Cannot be empty", required = true)
            @PathVariable int id) {
        this.petStore.remove(id);
    }

    @PostMapping
    public Pet addPet(@RequestBody Pet pet) {
        if (pet.getId() == null) {
            pet.setId(0);
        }
        return this.petStore.put(pet.getId(), pet);
    }
}
