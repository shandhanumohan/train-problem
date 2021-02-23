package com.edstem.code.pairing.trainproblem.controller;

import com.edstem.code.pairing.trainproblem.entity.TrainEntity;
import com.edstem.code.pairing.trainproblem.model.TrainModel;
import com.edstem.code.pairing.trainproblem.service.TrainService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @PostMapping("/load")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void loadData(@RequestParam("file") MultipartFile file) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        List<TrainModel> trainModelList = mapper.readValue(file.getInputStream(), new TypeReference<List<TrainModel>>(){});
        trainService.loadData(trainModelList);

    }

    @GetMapping("/trains")
    @ResponseStatus(HttpStatus.OK)
    public List<TrainEntity> getTrainInfo() {
        return trainService.getTrainInfo();
    }

    @GetMapping("/train/{id}")

    public ResponseEntity getTrain(@PathVariable("id") long id) {
        Optional<TrainEntity> trainEntity = trainService.getTrain(id);
        if (trainEntity.isEmpty()) {
            return new ResponseEntity("Train not found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<TrainEntity>(trainEntity.get(), HttpStatus.OK);
        }
    }
}
