package com.skilldistillery.film.dao;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;
import com.skilldistillery.film.entities.FilmActor;

public class FilmDAOImpl implements FilmDAO {

	private List<Film> films;
	private List<Actor> actors;
	private List<FilmActor> filmActors;

	public FilmDAOImpl() {
		films = new ArrayList<>();
		films.add(new Film(1, "Pulp Fiction", "Thriller", 1994, 1, 5, 3.99, 190, 5.99, "R", "Trailers"));
		films.add(new Film(2, "The Three Amigos", "Comedy", 1988, 1, 5, 3.99, 190, 5.99, "PG", "Trailers"));
		films.add(new Film(3, "Forest Gump", "Drama", 1994, 1, 5, 3.99, 190, 5.99, "R", "Trailers"));
		films.add(new Film(4, "The Naked Gun", "Comedy", 1970, 1, 5, 3.99, 190, 5.99, "PG13", "Trailers"));
		films.add(new Film(5, "A Quiet Place", "Horror", 2018, 1, 5, 3.99, 190, 5.99, "R", "Trailers"));
		films.add(new Film(6, "Christmas Vacation", "Comedy", 1988, 1, 5, 3.99, 190, 5.99, "PG13", "Trailers"));
		films.add(new Film(7, "Alien", "Thriller", 1991, 1, 5, 3.99, 190, 5.99, "R", "Trailers"));
		films.add(new Film(8, "Argo", "Drama", 2013, 1, 5, 3.99, 190, 5.99, "R", "Trailers"));
		films.add(new Film(9, "Inglorious Basterds", "Drama", 2008, 1, 5, 3.99, 190, 5.99, "R", "Trailers"));
		films.add(new Film(10, "Meet The Parents", "Comedy", 2001, 1, 5, 3.99, 190, 5.99, "R", "Trailers"));

		actors = new ArrayList<>();
		actors.add(new Actor(1, "Sigourney", "Weaver"));
		actors.add(new Actor(2, "Chevy", "Chase"));
		actors.add(new Actor(3, "Ben", "Stiller"));
		actors.add(new Actor(4, "Brad", "Pitt"));
		actors.add(new Actor(5, "Tom", "Hanks"));
		actors.add(new Actor(6, "John", "Trivolta"));
		actors.add(new Actor(7, "Ben", "Affleck"));
		actors.add(new Actor(8, "Leslie", "Nielson"));
		actors.add(new Actor(9, "Emily", "Blunt"));
		actors.add(new Actor(10, "Steve", "Martin"));

		filmActors = new ArrayList<>();
		filmActors.add(new FilmActor(1, 7));
		filmActors.add(new FilmActor(2, 6));
		filmActors.add(new FilmActor(3, 10));
		filmActors.add(new FilmActor(4, 9));
		filmActors.add(new FilmActor(5, 3));
		filmActors.add(new FilmActor(6, 1));
		filmActors.add(new FilmActor(7, 8));
		filmActors.add(new FilmActor(8, 4));
		filmActors.add(new FilmActor(9, 5));
		filmActors.add(new FilmActor(10, 2));
	}

	@Override
	public Film getFilmById(String filmId) {
		Film film = null;
		for (Film f : films) {
			int fID = Integer.parseInt(filmId);
			if (f.getId() == fID) {
				film = f;
			}
		}
		return film;
	}

	@Override
	public void addFilm(Film film) {
		this.films.add(film);
	}

	@Override
	public Film deleteFilm(Film film) {
		if (films.contains(film)) {
			films.remove(film);
		}
		return null;
	}

	@Override
	public Film updateFilm(Film film) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Film> getFilmBySearchKeyword(String keyword) {
		List<Film> searchedFilms = new ArrayList<>();
		for (Film f : films) {
			if (f.getTitle().contains(keyword)) {
				searchedFilms.add(f);
			}
		}
		return searchedFilms;
	}

	@Override
	public Actor getActorById(int actorID) {
		for (Actor a : actors) {
			if (a.getId() == actorID) {
				return a;
			}
		}
		return null;

	}

	@Override
	public List<Actor> getActorsByFilmId(String filmId) {
		List<Actor> actors = new ArrayList<>();
		int actorID = 0;
		for (FilmActor fa : filmActors) {
			int fID = Integer.parseInt(filmId);
			if (fa.getFilmID() == fID) {
				actorID = fa.getActorID();
				actors.add(getActorById(actorID));
			}
		}
		return actors;
	}

}
