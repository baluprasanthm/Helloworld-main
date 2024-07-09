package com.rathna.app.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.rathna.app.entity.Country;

public interface CountryRepository extends ReactiveCrudRepository<Country, String> {

}
