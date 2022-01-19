package br.com.victorhugolgr.arquivomultiplosformatosjob.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ArquivoMultiplosFormatosReaderConfig {

	@StepScope
	@Bean
	public FlatFileItemReader arquivoMultiplosFormatosItemReader(@Value("#{jobParameters['arquivoClientes']}")Resource arquivoclientes, LineMapper lineMapper) {

		return new FlatFileItemReaderBuilder()
				.name("arquivoMultiplosFormatosItemReader")
				.resource(arquivoclientes)
				.lineMapper(lineMapper)
				.build();
	}

}
