package com.pictet.training_springcloud.producer.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

public class Pet {

    @Schema(description = "Unique identifier of the Pet.",
            example = "1", required = true)
    private Integer id;

    @Schema(description = "Name of the Pet.",
            example = "Rantanplan", required = true)
    private String name;

    public Pet() {
    }

    public Pet(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return id == pet.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
