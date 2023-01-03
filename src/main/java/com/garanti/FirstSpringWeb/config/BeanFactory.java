package com.garanti.FirstSpringWeb.config;

import com.garanti.FirstSpringWeb.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class BeanFactory {
    @Bean(value = "myds")
    public DataSource getdDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource(Constants.URL, Constants.USER, Constants.PASSWORD);
        ds.setDriverClassName("oracle.jdbc.OracleDriver");
        return ds;
    }

    @Bean
    @DependsOn(value = "myds") // olmasa da çalışıyor ama görmek istiyorum
    public JdbcTemplate getJdbcTemplate(@Autowired @Qualifier(value = "myds") DataSource ds) {
        return new JdbcTemplate(ds);
    }

    @Bean
    @DependsOn(value = "myds")
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(@Autowired @Qualifier(value = "myds") DataSource ds) {
        return new NamedParameterJdbcTemplate(ds);
    }

    /*public BeanFactory()
    {
        System.err.println("----> Bean factory new yapılıyor");
    }*/

    /*@Bean(name = "person1")
    public Person getPerson()
    {
        return new Person(12, "şerafettin");
    }

    @Bean(name = "person2")
    public Person getPerson2()
    {
        return new Person(12, "hüsamettin");
    }*/
}