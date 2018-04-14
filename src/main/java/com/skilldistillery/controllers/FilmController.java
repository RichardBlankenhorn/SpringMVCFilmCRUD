package com.skilldistillery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.dao.FilmDAO;
import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	private FilmDAO filmDAO;

	public void setFilmDAO(FilmDAO filmDAO) {
		this.filmDAO = filmDAO;
	}

	@RequestMapping(path = "searchFilmById.do", params = "filmsById", method = RequestMethod.GET)
	public ModelAndView getFilmById(String id) {
		ModelAndView mv = new ModelAndView();
		Film film = filmDAO.getFilmById(id);
		mv.addObject("film", film);
		mv.setViewName("showfilm");
		return mv;
	}

	@RequestMapping(path = "addFilm.do", method = RequestMethod.POST)
	public ModelAndView addFilm(Film film) {
		filmDAO.addFilm(film);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("showfilm");
		return mv;
	}

	@RequestMapping(path = "searchFilmByKeyword.do", params = "filmsByKeyword", method = RequestMethod.GET)
	public ModelAndView getFilmBySearchKeyword(String keyword) {
		ModelAndView mv = new ModelAndView();
		List<Film> film = filmDAO.getFilmBySearchKeyword(keyword);
		mv.addObject("film", film);
		mv.setViewName("showfilm");
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
	
	//TODO add request mapping
	//@RequestMapping
	public ModelAndView getActorsByFilmId(String filmId) {
		ModelAndView mv = new ModelAndView();
		List<Actor> actor = filmDAO.getActorsByFilmId(filmId);
		mv.addObject("film", actor);
		mv.setViewName("showfilm");
		return mv;
	}

	
}
