package com.pictet.training_springcloud.consumer.service;

import com.pictet.training_springcloud.petstore.model.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
// ids = group:artifact:version:classifier:stub (https://ant.apache.org/ivy/history/master/settings/version-matchers.html)
@AutoConfigureStubRunner(ids = "com.pictet.training_springcloud:contract:+:stubs:8701", stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class PetStoreServiceTest {

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
        Pet pet = new Pet().id(2).name("Woulfie");
        petStoreService.addPet(pet);
    }

    @Test
    public void deletePetById() {
        petStoreService.deletePetById(1);
    }
}