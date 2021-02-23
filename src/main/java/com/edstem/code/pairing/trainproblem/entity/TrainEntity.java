package com.edstem.code.pairing.trainproblem.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "train")
public class TrainEntity implements Serializable {
    public static final long serialVersionUID = 5841572513939829094L;

    @Id
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "distance_between_stop")
    private String distanceBetweenStop;

    @Column(name = "max_speed")
    private String maxSpeed;

    @Column(name = "sharing_tracks")
    private boolean sharingTracks;

    @Column(name = "grade_crossing")
    private boolean gradeCrossing;

    @Column(name = "train_frequency")
    private String trainFrequency;

    @Column(name = "amenities")
    private String amenities;


}
