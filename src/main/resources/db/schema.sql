DROP TABLE IF EXISTS train;
CREATE TABLE train (
 id int PRIMARY KEY,
 name varchar(50),
 description text,
 distance_between_stop varchar(150),
 max_speed varchar(50),
 sharing_tracks boolean,
 grade_crossing boolean,
 train_frequency varchar(50),
 amenities text
);