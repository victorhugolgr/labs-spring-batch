package br.com.victorhugolgr.arquivodelimitadojob.writer;

import br.com.victorhugolgr.arquivodelimitadojob.dominio.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraArquivoDelimitadoWriterConfig {
	@Bean
	public ItemWriter<Cliente> leituraArquivoDelimitadoWriter() {
		return items -> items.forEach(System.out::println);
	}
}
