package com.skilldistillery.film.database;

import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface DatabaseAccessor {
	public Film getFilmById(String filmId);

	public Actor getActorById(String actorId);

	//public Language getLanguageById(String filmId);

	public List<Film> getFilmBySearchKeyword(String keyword);

	public List<Actor> getActorsByFilmId(String filmId);
	
	public Film addFilm(Film film);
	
	public Film deleteFilm(Film film);

}
