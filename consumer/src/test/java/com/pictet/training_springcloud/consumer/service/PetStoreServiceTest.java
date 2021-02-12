package com.pictet.training_springcloud.consumer.service;

import com.pictet.training_springcloud.petstore.model.Pet;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PetStoreServiceTest {

    @Autowired
    private PetStoreService petStoreService;

    @Test
    @Disabled
    public void getPetById() {
        Pet pet = petStoreService.getPetById(1);

        assertThat(pet.getId()).isEqualTo(1);
        assertThat(pet.getName()).isEqualTo("Rantanplan");
    }

    @Test
    @Disabled
    public void addPet() {
        Pet pet = new Pet().id(2).name("Woulfie");
        petStoreService.addPet(pet);
    }

    @Test
    @Disabled
    public void deletePetById() {
        petStoreService.deletePetById(1);
    }
}