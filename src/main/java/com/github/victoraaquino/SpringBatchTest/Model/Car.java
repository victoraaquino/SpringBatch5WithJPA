package com.github.victoraaquino.SpringBatchTest.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String model;

    @Column
    private String brand;
}
