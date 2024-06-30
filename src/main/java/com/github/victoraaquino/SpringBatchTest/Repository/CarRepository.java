package com.github.victoraaquino.SpringBatchTest.Repository;

import com.github.victoraaquino.SpringBatchTest.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {

    @Procedure(value = "FIND_CARS_BY_BRAND")
    List<Car> findCarsByBrand(String brand);

}
