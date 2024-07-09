package com.rathna.app.repository;

import java.util.List;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.rathna.app.entity.Employee;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Integer> {


  public List<Employee> findByDepartmentId(Integer departmentId);

  public List<Employee> findByDepartmentIdIn(List<Integer> departmentId);
}
