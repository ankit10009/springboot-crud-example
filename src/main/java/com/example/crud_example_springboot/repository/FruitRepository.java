package com.example.crud_example_springboot.repository;

import com.example.crud_example_springboot.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository extends JpaRepository<Fruit,Integer> {
}
