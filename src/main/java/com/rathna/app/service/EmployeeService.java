package com.rathna.app.service;

import java.time.Duration;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rathna.app.entity.Country;
import com.rathna.app.entity.Department;
import com.rathna.app.entity.Dependent;
import com.rathna.app.entity.Employee;
import com.rathna.app.entity.JobInfo;
import com.rathna.app.entity.Location;
import com.rathna.app.entity.Region;
import com.rathna.app.repository.CountryRepository;
import com.rathna.app.repository.DepartmentRepository;
import com.rathna.app.repository.DependentRepository;
import com.rathna.app.repository.EmployeeRepository;
import com.rathna.app.repository.JobRepository;
import com.rathna.app.repository.LocationRepository;
import com.rathna.app.repository.RegionRepository;
import com.rathna.app.web.EmployeeController.EmployeeInput;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;
  @Autowired
  private DependentRepository dependentRepository;
  @Autowired
  private JobRepository jobRepository;
  @Autowired
  private DepartmentRepository departmentRepository;
  @Autowired
  private LocationRepository locationRepository;
  @Autowired
  private CountryRepository countryRepository;
  @Autowired
  private RegionRepository regionRepository;


  // public Mono<EmployeeDetails> getEmployeeDetailsById(Integer empId) {
  //
  // EmployeeDetails employeeDetails = EmployeeDetails.builder().build();
  // Mono<Employee> employee = getEmployeeById(empId);
  //
  // employee.
  //
  // if (!employee.isEmpty()) {
  // employeeDetails.setEmployee(employee.get());
  // employeeDetails.setDependents(getDependentsByEmployeeId(empId));
  // employeeDetails.setJob(getJobDetailsById(employee.get().getJobId()));
  // employeeDetails.setDepartment(getDepartmentDetailsById(employee.get().getDepartmentId()));
  // if (employeeDetails.getDepartment() != null
  // && employeeDetails.getDepartment().getLocationId() != null) {
  // employeeDetails
  // .setLocation(getLocationById(employeeDetails.getDepartment().getLocationId()));
  // employeeDetails.setCountry(getCountryById(employeeDetails.getLocation().getCountryId()));
  // employeeDetails.setRegion(getRegionById(employeeDetails.getCountry().getRegionId()));
  //
  // }
  // }
  //
  // return employeeDetails;
  //
  // }

  public Mono<Employee> getEmployeeById(Integer empId) {
    Mono<Employee> employee = employeeRepository.findById(empId);
    return employee;
  }

  public Mono<Region> getRegionById(Integer regionId) {
    return regionRepository.findById(regionId);
  }

  public Mono<Country> getCountryById(String countryId) {
    return countryRepository.findById(countryId);
  }

  public Mono<Location> getLocationById(Integer locationId) {
    return locationRepository.findById(locationId);
  }

  public Mono<Department> getDepartmentDetailsById(Integer departmentId) {
    return departmentRepository.findById(departmentId);
  }

  public Mono<JobInfo> getJobDetailsById(Integer jobId) {

    return jobRepository.findById(jobId);

  }

  public List<Dependent> getDependentsByEmployeeId(Integer empId) {

    List<Dependent> dependents = dependentRepository.findByEmployeeId(empId);

    return dependents;

  }

  public Flux<Employee> allEmployees() {
    return employeeRepository.findAll().delayElements(Duration.ofSeconds(1L)).log();

  }

  public Mono<Employee> createUpdateEmployee(EmployeeInput input) {

    Employee employee = Employee.builder().employeeId(input.employeeId())
        .firstName(input.firstName()).lastName(input.lastName()).email(input.email())
        .hireDate(input.hireDate()).jobId(input.jobId()).salary(input.salary())
        .managerId(input.managerId()).departmentId(input.departmentId()).build();
    return employeeRepository.save(employee);
  }



}
