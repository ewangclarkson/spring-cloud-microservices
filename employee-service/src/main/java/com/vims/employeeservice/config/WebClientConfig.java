package com.vims.employeeservice.config;


import com.vims.employeeservice.client.DepartmentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {

    @Autowired
    LoadBalancedExchangeFilterFunction filterFunction;

    @Bean
    WebClient departmentWebClient() {
        return WebClient
                .builder()
                .baseUrl("http://department-service")
                .filter(filterFunction)
                .build();
    }

    @Bean
    DepartmentClient departmentClient() {
        HttpServiceProxyFactory serviceProxyFactory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(departmentWebClient()))
                .build();
        return serviceProxyFactory.createClient(DepartmentClient.class);
    }
}
