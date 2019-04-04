package com.slyak;

import com.slyak.spring.jpa.GenericJpaRepositoryFactoryBean;
import com.slyak.spring.jpa.GenericJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.concurrent.Executors;

@SpringBootApplication
@EnableJpaRepositories(
        basePackages = "com.slyak",
        repositoryBaseClass = GenericJpaRepositoryImpl.class,
        repositoryFactoryBeanClass = GenericJpaRepositoryFactoryBean.class
)
@EnableTransactionManagement // Spring Boot的事务管理
@EnableAsync //可以异步执行，开启@Async
@Configuration
public class SmartoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartoApplication.class, args);
    }


    @Bean
    public AsyncTaskExecutor taskExecutor() {
        return new ConcurrentTaskExecutor(Executors.newCachedThreadPool());
    }
}