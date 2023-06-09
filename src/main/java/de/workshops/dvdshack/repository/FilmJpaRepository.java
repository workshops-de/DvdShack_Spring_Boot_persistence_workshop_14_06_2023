package de.workshops.dvdshack.repository;

import org.springframework.data.repository.CrudRepository;

import java.time.Year;
import java.util.List;

public interface FilmJpaRepository extends CrudRepository<Film, Integer> {
    int countFilmsByReleaseYear(Year releaseYear);

    List<Film> findAllFilmsByRating(Rating rating);

    List<Film> findAllFilmsByActorsIs(Actor actor);

    List<Film> findAllFilmsByLengthGreaterThanEqual(int minutes);

    // Does not work, for this kind of query you need to use @Query or a native query
    //    List<Film> findAllFilmsMatchingExactlyBySpecialFeatures(List<String> specialFeatures);

    List<Film> findByTitleAndReleaseYearOrLength(String title, Year releaseYear, int length);
}
