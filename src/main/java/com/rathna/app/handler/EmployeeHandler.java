package com.rathna.app.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.rathna.app.entity.Employee;
import com.rathna.app.service.EmployeeService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeHandler {


  @Autowired
  private EmployeeService employeeService;


  public Mono<ServerResponse> getAllEmployee(ServerRequest request) {
    Flux<Employee> employeeFlux = employeeService.allEmployees();
    return ServerResponse.ok().body(employeeFlux, Employee.class);
  }


  public Mono<ServerResponse> getEmployeeById(ServerRequest request) {
    Integer empId = Integer.valueOf(request.pathVariable("empId"));
    Mono<Employee> employeeMono = employeeService.getEmployeeById(empId);
    return ServerResponse.ok().body(employeeMono, Employee.class);

  }

}
