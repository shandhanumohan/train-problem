package com.edstem.code.pairing.trainproblem.service;

import com.edstem.code.pairing.trainproblem.entity.TrainEntity;
import com.edstem.code.pairing.trainproblem.model.TrainModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TrainService {
    void loadData(List<TrainModel> modelList);
    List<TrainEntity> getTrainInfo();
    Optional<TrainEntity> getTrain(long id);
}
