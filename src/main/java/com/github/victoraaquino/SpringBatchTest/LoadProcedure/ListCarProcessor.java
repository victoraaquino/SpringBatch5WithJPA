package com.github.victoraaquino.SpringBatchTest.LoadProcedure;

import com.github.victoraaquino.SpringBatchTest.Model.Car;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListCarProcessor implements ItemProcessor<List<Car>,List<Car>> {
    @Override
    public List<Car> process(List<Car> item) throws Exception {
        return item;
    }
}
