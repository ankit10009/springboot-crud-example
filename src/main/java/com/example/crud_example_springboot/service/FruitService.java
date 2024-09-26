package com.example.crud_example_springboot.service;

import com.example.crud_example_springboot.entity.Fruit;
import com.example.crud_example_springboot.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitService {

    @Autowired
    private FruitRepository repo;

    public List<Fruit> getAllFruits() {
        return repo.findAll();
    }

    public Fruit getFruitById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Fruit save(Fruit fruit) {
        return repo.save(fruit);
    }


    public Fruit update(Integer id, Fruit fruit) {
        return repo.findById(id)
                .map(existingFruit -> {
                    existingFruit.setName(fruit.getName());
                    return repo.save(existingFruit);
                })
                .orElse(null);
    }


    public boolean delete(Integer id) {
        return repo.findById(id)
                .map(fruit -> {
                    repo.delete(fruit);
                    return true;
                })
                .orElse(false);
    }
}
