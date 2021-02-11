package com.pictet.training_springcloud.consumer.service;

import com.pictet.training_springcloud.petstore.model.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PetStoreServiceIT {

    @Autowired
    private PetStoreService petStoreService;

    @Test
    public void getPetById() {
        Pet pet = petStoreService.getPetById(1);

        assertThat(pet.getId()).isEqualTo(1);
        assertThat(pet.getName()).isEqualTo("Rantanplan");
    }

    @Test
    public void addPet() {
        assertThat(petStoreService.getPetById(2)).isNull();

        Pet pet = new Pet().id(2).name("Woulfie");
        petStoreService.addPet(pet);

        assertThat(petStoreService.getPetById(2)).isNotNull();
    }

    @Test
    public void deletePetById() {
        assertThat(petStoreService.getPetById(1)).isNull();

        petStoreService.deletePetById(1);
    }
}