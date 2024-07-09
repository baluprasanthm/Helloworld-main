package com.rathna.app.entity;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "departments")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Department {

  @org.springframework.data.annotation.Id
  @Column("department_id")
  private Integer departmentId;
  @Column("department_name")
  private String departmentName;
  @Column("locationId")
  private Integer locationId;

}
