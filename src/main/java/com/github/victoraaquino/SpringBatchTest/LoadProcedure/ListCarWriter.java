package com.github.victoraaquino.SpringBatchTest.LoadProcedure;

import com.github.victoraaquino.SpringBatchTest.Model.Car;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListCarWriter implements ItemWriter<List<Car>> {

    @Override
    public void write(Chunk<? extends List<Car>> chunk) throws Exception {
        for (List<Car> cars : chunk.getItems()) {
            for(Car car : cars) {
                System.out.println("Carro: " + car.getModel());
            }
        }
    }


}
