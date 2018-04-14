package com.skilldistillery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.film.dao.FilmDAO;
import com.skilldistillery.film.database.DatabaseAccessor;
import com.skilldistillery.film.database.DatabaseAccessorObject;
import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	private FilmDAO filmDAO;
	private DatabaseAccessor db;

	public void setFilmDAO(FilmDAO filmDAO) {
		this.filmDAO = filmDAO;
	}

	/*
	 * Working leave alone
	 */
	@RequestMapping(path = "searchFilmById.do", method = RequestMethod.GET)
	public ModelAndView getFilmById(@RequestParam(name = "filmId") String filmId) {
		ModelAndView mv = new ModelAndView();
		db = new DatabaseAccessorObject();
		Film film = db.getFilmById(filmId);
		mv.addObject("film", film);
		mv.setViewName("/WEB-INF/views/showfilm.jsp");
		return mv;
	}

	// TODO get working
	@RequestMapping(path = "addFilm.do", method = RequestMethod.POST)
	public ModelAndView addFilm(Film film) {
		ModelAndView mv = new ModelAndView();
		db = new DatabaseAccessorObject();
		db.addFilm(film);
		mv.addObject("film", film);
		mv.setViewName("/WEB-INF/views/showfilm.jsp");
		return mv;
	}

	/*
	 * Working leave alone
	 */
	@RequestMapping(path = "searchFilmByKeyword.do", method = RequestMethod.GET)
	public ModelAndView getFilmBySearchKeyword(@RequestParam(name = "keyword") String keyword) {
		ModelAndView mv = new ModelAndView();
		db = new DatabaseAccessorObject();
		List<Film> films = db.getFilmBySearchKeyword(keyword);
		mv.addObject("films", films);
		mv.setViewName("/WEB-INF/views/showfilm.jsp");
		return mv;
	}

	// TODO If we want to show just an actor by the actors ID
	// @RequestMapping()
	// public ModelAndView getActorsById(int id) {
	// ModelAndView mv = new ModelAndView();
	// Actor actor = filmDAO.getActorById(id);
	// mv.addObject("actor", actor);
	// mv.setViewName("showactor");
	// return mv;
	// }

	// TODO add request mapping
	// @RequestMapping
	public ModelAndView getActorsByFilmId(String filmId) {
		ModelAndView mv = new ModelAndView();
		List<Actor> actor = filmDAO.getActorsByFilmId(filmId);
		mv.addObject("film", actor);
		mv.setViewName("/WEB-INF/views/showfilm.jsp");
		return mv;
	}

	@RequestMapping(path = "delete.do", method = RequestMethod.POST)
	public ModelAndView deleteFilm(@RequestParam(name = "filmID")Film film) {
		filmDAO.deleteFilm(film);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/views/showfilm.jsp");
		return mv;
	}

	// TODO add request mapping
	// @RequestMapping
	public ModelAndView updateFilm(Film film) {
		filmDAO.addFilm(film);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/views/showfilm.jsp");
		return mv;
	}

}
