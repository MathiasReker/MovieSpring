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

  public String getMovies(int amount) {
    return MOVIE_REPOSITORY.getFirstMovies(amount).toString();
  }

  public String getRandomMovies(int amount) {
    return MOVIE_REPOSITORY.getRandomMovies(amount).toString();
  }

  public String getTopMovies(int amount) {
    return MOVIE_REPOSITORY.getTopMovies(amount).toString();
  }

  public int getAwardsCount() {
    return MOVIE_REPOSITORY.getWonAward();
  }

  public String getListComedy() {
    return MOVIE_REPOSITORY.getListComedy().toString();
  }
}
