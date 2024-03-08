package com.riko.movie.service;

import com.riko.movie.model.Movie;
import com.riko.movie.model.dto.MovieMinDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();

    Movie createMovie(MovieMinDTO movieMinDTO);

    Movie getMovieById(Long id);

    List<Movie> searchMovieByLanguageGenre(String keyword, Long genreId, Long languageId);
}
