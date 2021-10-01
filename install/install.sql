create schema IF NOT EXISTS imdb;
use imdb;
drop table IF EXISTS movies;

CREATE TABLE movies (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    year INT,
    length INT,
    subject VARCHAR(50),
    popularity INT,
    awards VARCHAR(3)
);

LOAD DATA LOCAL INFILE "imdb-data.csv"
INTO TABLE movies
    FIELDS TERMINATED BY ';' 
           OPTIONALLY ENCLOSED BY '"'
    LINES TERMINATED BY '\r\n'
    IGNORE 1 LINES
(year, length, title, subject, popularity, awards);