package com.skilldistillery.film.dao;

import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {
	public Film getFilmById(String filmId); // added to controller
	public void addFilm(Film film); // added to controller
	public Film deleteFilm(Film film); // added to controller
	public Film updateFilm(Film film); // added to controller
	public List<Film> getFilmBySearchKeyword(String keyword); // added to controller
	public List<Actor> getActorsByFilmId(String filmId); // added to controller
	public Actor getActorById(int actorID); //added to controller
}
