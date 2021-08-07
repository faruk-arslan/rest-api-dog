package com.fa.dogapi.web;

import com.fa.dogapi.entity.Dog;
import com.fa.dogapi.service.DogServiceImpl;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ApiResponses(value = {
        @ApiResponse(code=400, message = "This is a bad request, please follow the API documentation for the proper request format."),
        @ApiResponse(code=401, message = "Due to security constraints, your access request cannot be authorized. "),
        @ApiResponse(code=404, message = "Not found custom error. "),
        @ApiResponse(code=500, message = "The server is down. Please make sure that the Location microservice is running.")
})
public class DogController {

    private DogServiceImpl dogService;

    @Autowired
    public void setDogService(DogServiceImpl dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs(){
        List<Dog> dogs= (List<Dog>) dogService.retrieveAllDogs();
        return new ResponseEntity<List<Dog>>(dogs, HttpStatus.OK);
    }

    @GetMapping("/dogs/breeds")
    public ResponseEntity<List<String>> getBreeds(){
        List<String> breeds= dogService.retrieveBreeds();
        return new ResponseEntity<List<String>>(breeds, HttpStatus.OK);
    }

    @GetMapping("/dogs/names")
    public ResponseEntity<List<String>> getNames(){
        List<String> names= dogService.retrieveNames();
        return new ResponseEntity<List<String>>(names, HttpStatus.OK);
    }

    @GetMapping("/dogs/{id}/breed")
    public ResponseEntity<String> getBreedById(@PathVariable long id){
        String breed= dogService.retrieveBreedById(id);
        return new ResponseEntity<String>(breed, HttpStatus.OK);
    }
}
