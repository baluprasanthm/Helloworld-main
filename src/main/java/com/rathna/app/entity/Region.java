package com.rathna.app.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "regions")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Region {
  @Id
  @Column("region_id")
  private Integer regionId;
  @Column("region_name")
  private String regionName;

}
