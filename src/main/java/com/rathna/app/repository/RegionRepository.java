package com.rathna.app.repository;



import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.rathna.app.entity.Region;

public interface RegionRepository extends ReactiveCrudRepository<Region, Integer> {

}
