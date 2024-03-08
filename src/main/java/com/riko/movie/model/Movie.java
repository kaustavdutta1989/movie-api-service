package com.riko.movie.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @JoinColumn(nullable = false, columnDefinition = "genre")
    @ManyToOne
    private Genre genre;

    @JoinColumn(nullable = false, columnDefinition = "language")
    @ManyToOne
    private Language language;
}
