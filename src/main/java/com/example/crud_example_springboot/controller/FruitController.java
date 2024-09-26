package com.example.crud_example_springboot.controller;

import com.example.crud_example_springboot.entity.Fruit;
import com.example.crud_example_springboot.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("fruits")
public class FruitController {

    @Autowired
    private FruitService fruitService;

    @GetMapping("/")
    public List<Fruit> getAllFruits() {
        return fruitService.getAllFruits();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fruit> getSingle(@PathVariable Integer id) {
        Fruit fruit = fruitService.getFruitById(id);
        if (fruit == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
        return ResponseEntity.ok(fruit);
    }

    @PostMapping("/")
    public ResponseEntity<Fruit> create(@RequestBody Fruit fruit) {
        if (fruit.getId() != null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body(null);
        }
        Fruit createdFruit = fruitService.save(fruit);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdFruit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fruit> update(@PathVariable Integer id, @RequestBody Fruit fruit) {
        if (fruit.getName() == null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body(null);
        }
        Fruit updatedFruit = fruitService.update(id, fruit);
        if (updatedFruit == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
        return ResponseEntity.ok(updatedFruit);
    }

    // DELETE: Delete a fruit by its id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        boolean deleted = fruitService.delete(id);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .build();
        }
        return ResponseEntity.noContent()
                .build();
    }


}
