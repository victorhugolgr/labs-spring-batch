package br.com.victorhugolgr.arquivomultiplosformatosjob.reader;

import br.com.victorhugolgr.arquivomultiplosformatosjob.dominio.Cliente;
import br.com.victorhugolgr.arquivomultiplosformatosjob.dominio.Transacao;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class ClienteTransacaoLineMapperConfig {

    @Bean
    public PatternMatchingCompositeLineMapper lineMapper() {
        PatternMatchingCompositeLineMapper lineMapper = new PatternMatchingCompositeLineMapper();
        lineMapper.setTokenizers(tokenizers());
        lineMapper.setFieldSetMappers(fieldSetMappers());
        return lineMapper;
    }

    private Map<String, FieldSetMapper> fieldSetMappers() {
        return Map.of("0*", fieldSetMapper(Cliente.class), "1*", fieldSetMapper(Transacao.class));
    }

    private FieldSetMapper fieldSetMapper(Class clazz) {
        BeanWrapperFieldSetMapper fieldSetMapper = new BeanWrapperFieldSetMapper();
        fieldSetMapper.setTargetType(clazz);
        return fieldSetMapper;
    }

    private Map<String, LineTokenizer> tokenizers() {
        return Map.of("0*", clienteLineTokenizer(), "1*", transacaoLineTokenizer());
    }

    private LineTokenizer transacaoLineTokenizer() {
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames("id", "descricao", "valor");
        lineTokenizer.setIncludedFields(1,2,3);
        return lineTokenizer;
    }

    private LineTokenizer clienteLineTokenizer() {
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames("nome", "sobrenome", "idade", "email");
        lineTokenizer.setIncludedFields(1,2,3,4);
        return lineTokenizer;
    }
}
