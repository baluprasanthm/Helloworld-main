package com.rathna.app.repository;

import java.util.List;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.rathna.app.entity.Dependent;

public interface DependentRepository extends ReactiveCrudRepository<Dependent, Integer> {

  public List<Dependent> findByEmployeeId(Integer emp_id);


}
