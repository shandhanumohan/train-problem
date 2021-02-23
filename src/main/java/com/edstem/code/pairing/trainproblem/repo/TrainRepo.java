package com.edstem.code.pairing.trainproblem.repo;

import com.edstem.code.pairing.trainproblem.entity.TrainEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepo extends JpaRepository<TrainEntity, Long> {
}
