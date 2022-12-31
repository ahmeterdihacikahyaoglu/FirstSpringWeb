package com.garanti.FirstSpringWeb.config;

import com.garanti.FirstSpringWeb.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanFactory {
    /*public BeanFactory()
    {
        System.err.println("----> Bean factory new yapılıyor");
    }*/

    @Bean(name = "person1")
    public Person getPerson() {
        return new Person(12, "şerafettin");
    }
}