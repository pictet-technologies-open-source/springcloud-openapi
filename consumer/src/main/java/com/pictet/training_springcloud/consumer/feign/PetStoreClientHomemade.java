package com.pictet.training_springcloud.consumer.feign;

import com.pictet.training_springcloud.petstore.model.Pet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "petstorehomemade", url = "${petstore.url}", configuration = HomemadeConfiguration.class)
public interface PetStoreClientHomemade {

    @RequestMapping(method = RequestMethod.GET, value = "/api/pet")
    List<Pet> getAllPets();

    @RequestMapping(method = RequestMethod.GET, value = "/api/pet/{id}")
    Pet getPetById(@PathVariable("id") Integer id);
}
