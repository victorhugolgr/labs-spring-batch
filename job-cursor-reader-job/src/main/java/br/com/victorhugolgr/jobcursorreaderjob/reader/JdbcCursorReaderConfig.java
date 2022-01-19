package br.com.victorhugolgr.jobcursorreaderjob.reader;

import br.com.victorhugolgr.jobcursorreaderjob.dominio.Cliente;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;

@Configuration
public class JdbcCursorReaderConfig {
    @Bean
    public JdbcCursorItemReader<Cliente> jdbcCursorReader(@Qualifier("appDataSource")DataSource dataSource) {
        return new JdbcCursorItemReaderBuilder()
                .name("jdbcCursorReader")
                .dataSource(dataSource)
                .sql("SELECT * FROM CLIENTE")
                .rowMapper(new BeanPropertyRowMapper<Cliente>(Cliente.class))
                .build();
    }
}
