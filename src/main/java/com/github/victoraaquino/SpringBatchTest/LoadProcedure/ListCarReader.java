package com.github.victoraaquino.SpringBatchTest.LoadProcedure;

import com.github.victoraaquino.SpringBatchTest.Model.Car;
import com.github.victoraaquino.SpringBatchTest.Repository.CarRepository;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListCarReader implements ItemReader<List<Car>> {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<Car> read() throws Exception {
        List<Car> cars = carRepository.findCarsByBrand("fiat");

        if (cars.isEmpty()) {
            return null;
        }

        return cars;
    }
}
