package com.spring.learning1.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
/*
@Configuration
public class MultipleDBConfig {

    @Bean(name = "mysqlDb")
    @ConfigurationProperties(prefix = "spring.ds_mysql")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mysqlJdbcTemplate")
    public JdbcTemplate mysqlTemplate(@Qualifier("mysqlDb") DataSource dsMySql) {
        return new JdbcTemplate(dsMySql);
    }

    @Bean(name = "postgresDb")
    @ConfigurationProperties(prefix = "spring.ds_post")
    public DataSource postgresDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "postgresJdbcTemplate")
    public JdbcTemplate postgresTemplate(@Qualifier("postgresDb") DataSource dsPostgres) {
        return new JdbcTemplate(dsPostgres);
    }
}
*/