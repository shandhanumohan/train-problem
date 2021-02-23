package com.edstem.code.pairing.trainproblem.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainModel implements Serializable {
    public static final long serialVersionUID = 1904712352703659775L;

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("distance-between-stop")
    private String distanceBetweenStop;

    @JsonProperty("max-speed")
    private String maxSpeed;

    @JsonProperty("sharing-tracks")
    private boolean sharingTrack;

    @JsonProperty("grade-crossing")
    private boolean gradeCrossing;

    @JsonProperty("train-frequency")
    private String trainFrequency;

    @JsonProperty("amenities")
    private String amenities;

}
