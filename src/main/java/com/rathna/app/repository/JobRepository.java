package com.rathna.app.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.rathna.app.entity.JobInfo;

public interface JobRepository extends ReactiveCrudRepository<JobInfo, Integer> {

}
