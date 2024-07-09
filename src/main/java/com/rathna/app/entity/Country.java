package com.rathna.app.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "countries")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Country {
  @Id
  @Column("country_id")
  private String countryId;
  @Column("country_name")
  private String countryName;
  @Column("region_id")
  private Integer regionId;

}
