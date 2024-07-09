package com.rathna.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = " Hello Spring Webflux Reactive", version = "0.0"))
public class HelloSpringWebflux {

  public static void main(String[] args) {
    SpringApplication.run(HelloSpringWebflux.class, args);
  }

}
