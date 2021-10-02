package com.example.demo.service;

import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieService {

  private final MovieRepository MOVIE_REPOSITORY;

  @Autowired
  public MovieService(MovieRepository movieRepository) {
    MOVIE_REPOSITORY = movieRepository;
  }

  public String getFirstMovies(int amount) {
    return MOVIE_REPOSITORY.getFirstMovies(amount).toString();
  }

  public String getRandomMovies(int amount) {
    return MOVIE_REPOSITORY.getRandomMovies(amount).toString();
  }

  public String getTopMovies(int amount) {
    return MOVIE_REPOSITORY.getTopMovies(amount).toString();
  }

  public int getWonAwardMovies() {
    return MOVIE_REPOSITORY.getWonAwardMovies();
  }

  public String getComedyAwardsMovies() {
    return MOVIE_REPOSITORY.getComedyAwardsMovies().toString();
  }
}
