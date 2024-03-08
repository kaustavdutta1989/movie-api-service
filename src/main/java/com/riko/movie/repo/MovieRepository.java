package com.riko.movie.repo;

import com.riko.movie.model.Genre;
import com.riko.movie.model.Language;
import com.riko.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByGenreAndLanguage(Genre genre, Language language);
}
