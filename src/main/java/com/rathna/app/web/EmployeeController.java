package com.rathna.app.web;


import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rathna.app.entity.Employee;
import com.rathna.app.service.EmployeeService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping // (produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<Employee> getAllEmployees() {
    return employeeService.allEmployees();
  }


  @GetMapping("/{empId}")
  public Mono<Employee> getEmployeeById(@PathVariable Integer empId) {
    return employeeService.getEmployeeById(empId);
  }

  public record EmployeeInput(Integer employeeId, String firstName, String lastName, String email,
      LocalDateTime hireDate, Integer jobId, Integer managerId, Integer departmentId,
      Float salary) {
  }


  @PostMapping
  public Mono<Employee> createEmployeeMono(@RequestBody EmployeeInput employeeInput) {
    return employeeService.createUpdateEmployee(employeeInput);
  }
}

