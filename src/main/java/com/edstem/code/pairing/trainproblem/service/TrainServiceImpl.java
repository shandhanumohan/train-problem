package com.edstem.code.pairing.trainproblem.service;

import com.edstem.code.pairing.trainproblem.entity.TrainEntity;
import com.edstem.code.pairing.trainproblem.model.TrainModel;
import com.edstem.code.pairing.trainproblem.repo.TrainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainRepo trainRepo;

    @Override
    public void loadData(final List<TrainModel> modelList) {
        List<TrainEntity> trainEntities = modelList.stream()
                .map(s -> this.assembleTrainEntity(s))
                .collect(Collectors.toList());
        trainRepo.saveAll(trainEntities);
    }

    @Override
    public List<TrainEntity> getTrainInfo() {
        return trainRepo.findAll();
    }

    @Override
    public Optional<TrainEntity> getTrain(long id) {
        return trainRepo.findById(id);
    }

    private TrainEntity assembleTrainEntity(TrainModel model) {
        TrainEntity entity = new TrainEntity();
        entity.setId(model.getId());
        entity.setDescription(model.getDescription());
        entity.setDistanceBetweenStop(model.getDistanceBetweenStop());
        entity.setAmenities(model.getAmenities());
        entity.setGradeCrossing(model.isGradeCrossing());
        entity.setMaxSpeed(model.getMaxSpeed());
        entity.setName(model.getName());
        entity.setSharingTracks(model.isSharingTrack());
        return entity;
    }
}
