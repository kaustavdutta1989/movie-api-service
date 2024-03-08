package com.riko.movie.service.implementation;

import com.riko.movie.model.Movie;
import com.riko.movie.model.dto.MovieMinDTO;
import com.riko.movie.repo.LanguageRepository;
import com.riko.movie.repo.MovieRepository;
import com.riko.movie.service.GenreService;
import com.riko.movie.service.LanguageService;
import com.riko.movie.service.MovieService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final EntityManager em;
    private final MovieRepository movieRepository;
    private final LanguageService languageService;
    private final GenreService genreService;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie createMovie(MovieMinDTO movieMinDTO) {
        return movieRepository.save(Movie.builder()
                .name(movieMinDTO.getName())
                .genre(genreService.getGenreById(movieMinDTO.getGenreId()))
                .language(languageService.getLanguageById(movieMinDTO.getLanguageId()))
                .build());
    }

    public Movie getMovieById(@PathVariable Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("movie not found with id: " + id));
    }

    public List<Movie> searchMovieByLanguageGenre(String keyword, Long genreId, Long languageId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
        List<Predicate> predicates = new ArrayList<>();
        Root<Movie> movie = cq.from(Movie.class);

        if (keyword != null && !keyword.isEmpty()) {
            Predicate namePredicate = cb.like(movie.get("name"), "%" + keyword + "%");
            predicates.add(namePredicate);
        }
        if (genreId != null) {
            Predicate genrePredicate = cb.equal(movie.get("genre").get("id"), genreId);
            predicates.add(genrePredicate);
        }
        if (languageId != null) {
            Predicate languagePredicate = cb.equal(movie.get("language").get("id"), languageId);
            predicates.add(languagePredicate);
        }

        cq.where(predicates.toArray(new Predicate[0]));
        List<Movie> movies = em.createQuery(cq).getResultList();
        return movies;
    }
}
