package com.example.crud_example_springboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "known_fruits1")
public class Fruit {

    @Id
    @SequenceGenerator(
            name = "fruitsSequence",
            sequenceName = "known_fruits_id_seq1",
            allocationSize = 1,
            initialValue = 6)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fruitsSequence")
    private Integer id;

    @Column(length = 40, unique = true)
    private String name;

    public Fruit(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Fruit() {
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
}
