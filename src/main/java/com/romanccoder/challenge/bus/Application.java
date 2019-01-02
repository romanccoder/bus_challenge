package com.romanccoder.challenge.bus;

import com.romanccoder.challenge.bus.loader.FileRouteDataLoader;
import com.romanccoder.challenge.bus.loader.RouteDataLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static final String PATH_PARAM = "route_data.path";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RouteDataLoader routeDataLoader(@Value("${" + PATH_PARAM + "}") String filePath) {
        return new FileRouteDataLoader(filePath);
    }

}
