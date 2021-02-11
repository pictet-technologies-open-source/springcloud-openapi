package com.pictet.training_springcloud.consumer.service;

import com.pictet.training_springcloud.consumer.feign.PetStoreClient;
import com.pictet.training_springcloud.petstore.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetStoreService {

    @Autowired
    private PetStoreClient petStoreClient;

    public Pet getPetById(Integer id) {
        return petStoreClient.getPetById(id).getBody();
    }

    public Pet addPet(Pet pet) {
        return petStoreClient.addPet(pet).getBody();
    }

    public void deletePetById(Integer id) {
        petStoreClient.deletePetById(id);
    }
}
