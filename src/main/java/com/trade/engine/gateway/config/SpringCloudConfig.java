package com.trade.engine.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
    	// kong based, rate limitting, weighted routing
        //Stronger authentication Oauths high sensitive data

        return builder.routes()
                .route(r -> r.path("/trade/**")
                        .uri("http://localhost:8081/")
                        .id("trade"))

                .route(r -> r.path("/validate/**")
                        .uri("http://localhost:8082/")
                        .id("tradeValidation"))
                .route(r -> r.path("/")
                        .uri("http://localhost:8081/")
                        .id("home"))

                .route(r -> r.path("/rules/**")
                        .uri("http://localhost:8091/")
                        .id("tradeRules"))
                .build();



    }

}