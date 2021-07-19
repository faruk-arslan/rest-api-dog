package com.fa.dogapi.service;

import com.fa.dogapi.entity.Dog;

import java.util.List;

public interface DogService {
    List<Dog> retrieveAllDogs();
    List<String> retrieveBreeds();
    String retrieveBreedById(Long id);
    List<String> retrieveNames();
}
