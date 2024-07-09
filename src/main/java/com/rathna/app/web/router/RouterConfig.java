package com.rathna.app.web.router;

import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.rathna.app.entity.Employee;
import com.rathna.app.handler.EmployeeHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Configuration
public class RouterConfig {


  @Autowired
  private EmployeeHandler employeeHandler;

  @Bean
  @RouterOperations({
      @RouterOperation(path = "/router/employees", produces = {MediaType.APPLICATION_JSON_VALUE},
          method = RequestMethod.GET, beanClass = EmployeeHandler.class,
          beanMethod = "getAllEmployee",
          operation = @Operation(operationId = "getAllEmployee",
              responses = {@ApiResponse(responseCode = "200", description = "successful operation",
                  content = @Content(schema = @Schema(implementation = Employee.class)))})),
      @RouterOperation(path = "/router/employees/{empId}",
          produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET,
          beanClass = EmployeeHandler.class, beanMethod = "getEmployeeById",
          operation = @Operation(operationId = "getEmployeeById", responses = {
              @ApiResponse(responseCode = "200", description = "successful operation",
                  content = @Content(schema = @Schema(implementation = Employee.class))),
              @ApiResponse(responseCode = "404", description = "customer not found with given id")},
              parameters = {@Parameter(in = ParameterIn.PATH, name = "input")}

          )

      )})
  public RouterFunction<ServerResponse> routerFunction() {
    return RouterFunctions.route().GET("/router/employees", employeeHandler::getAllEmployee)
        .GET("/router/employees/{empId}", employeeHandler::getEmployeeById).build();


  }

}
