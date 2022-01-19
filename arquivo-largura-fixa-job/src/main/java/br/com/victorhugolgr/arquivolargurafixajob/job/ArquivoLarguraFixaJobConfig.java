package br.com.victorhugolgr.arquivolargurafixajob.job;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
@RequiredArgsConstructor
public class ArquivoLarguraFixaJobConfig {
    private final JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job arquivoLarguraFixaJob(Step leituraArquivoLarguraFixaStep) {
        return jobBuilderFactory
                .get("arquivoLarguraFixaJob")
                .start(leituraArquivoLarguraFixaStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
