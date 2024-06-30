package com.github.victoraaquino.SpringBatchTest.LoadProcedure;

import com.github.victoraaquino.SpringBatchTest.Model.Car;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;

import java.util.List;

@Configuration
public class LoadProcedureStepConfiguration {

    @Autowired
    private ListCarReader listCarReader;

    @Autowired
    private ListCarWriter listCarWriter;

    @Autowired
    private ListCarProcessor listCarProcessor;

    @Bean
    public Step loadProcedureStep(JobRepository jobRepository, JpaTransactionManager transactionManager){
        return new StepBuilder("loadProcedureStep", jobRepository)
                .<List<Car>,List<Car>>chunk(1, transactionManager)
                .reader(listCarReader)
                .processor(listCarProcessor)
                .writer(listCarWriter)
                .allowStartIfComplete(true)
                .build();
    }

}
