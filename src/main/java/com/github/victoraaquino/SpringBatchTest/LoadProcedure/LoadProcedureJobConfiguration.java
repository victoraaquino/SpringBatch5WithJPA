package com.github.victoraaquino.SpringBatchTest.LoadProcedure;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadProcedureJobConfiguration {

    @Bean
    public Job loadProcedureJob(JobRepository jobRepository, Step loadProcedureStep, JobCompletionNotificationListener listener){
        return new JobBuilder("loadProcedureJob", jobRepository)
                .start(loadProcedureStep)
                .listener(listener)
                .build();
    }

}
