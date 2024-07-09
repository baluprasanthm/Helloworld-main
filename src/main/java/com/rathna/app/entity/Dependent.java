package com.rathna.app.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "dependents")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Dependent {

  @Id
  private Integer dependent_id;

  @Column("first_name")
  private String firstName;
  @Column("last_name")
  private String lastName;
  private String relationship;
  @Column("employee_id")
  private Integer employeeId;

}
