package com.example.demo.model;

public class Movie {
  private final int MOVIE_ID;
  private final String TITLE;
  private final int YEAR;
  private final int LENGTH;
  private final String SUBJECT;
  private final int POPULARITY;
  private final String AWARDS;

  public Movie(
      int id, String title, int year, int length, String subject, int popularity, String awards) {
    this.MOVIE_ID = id;
    this.TITLE = title;
    this.YEAR = year;
    this.LENGTH = length;
    this.SUBJECT = subject;
    this.POPULARITY = popularity;
    this.AWARDS = awards;
  }

  @Override
  public String toString() {
    return "movieId="
        + MOVIE_ID
        + ", title="
        + TITLE
        + ", year="
        + YEAR
        + ", length="
        + LENGTH
        + ", subject="
        + SUBJECT
        + ", popularity="
        + POPULARITY
        + ", awards="
        + AWARDS
        + "<br>";
  }
}
