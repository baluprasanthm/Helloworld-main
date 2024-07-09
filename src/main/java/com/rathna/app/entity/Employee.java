package com.rathna.app.entity;



import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "employees")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Employee {

  @Id
  @Column("employee_id")
  private Integer employeeId;
  @Column("first_name")
  private String firstName;
  @Column("last_name")
  private String lastName;
  private String email;
  @Column("hire_date")

  private LocalDateTime hireDate;
  @Column("job_id")
  private Integer jobId;
  private Float salary;
  @Column("manager_id")
  private Integer managerId;
  @Column("department_id")
  private Integer departmentId;

}

