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

	@RequestMapping(path = "searchFilmById.do", method = RequestMethod.GET)
	public ModelAndView getFilmById(@RequestParam(name = "filmId")String filmId) {
		ModelAndView mv = new ModelAndView();
<<<<<<< HEAD
		Film film = filmDAO.getFilmById(filmId);
		//System.out.println(film);
=======
		db = new DatabaseAccessorObject();
		//Film film = filmDAO.getFilmById(filmId);
		Film film = db.getFilmById(filmId);
		System.out.println(film);
>>>>>>> 87386f0b94a2c39c202a13db7c72659bcbdf5a8f
		mv.addObject("film", film);
		mv.setViewName("/WEB-INF/views/showfilm.jsp");
		return mv;
	}

	@RequestMapping(path = "addFilm.do", method = RequestMethod.POST)
	public ModelAndView addFilm(Film film, RedirectAttributes redir) {
		filmDAO.addFilm(film);
		ModelAndView mv = new ModelAndView();
		redir.addFlashAttribute("film", film);
		mv.setViewName("/WEB-INF/views/showuserfilm.jsp");
		return mv;
	}

	@RequestMapping(path = "searchFilmByKeyword.do", method = RequestMethod.GET)
	public ModelAndView getFilmBySearchKeyword(@RequestParam(name = "keyword") String keyword) {
		ModelAndView mv = new ModelAndView();
		List<Film> films = filmDAO.getFilmBySearchKeyword(keyword);
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
	
	//TODO add request mapping
	//@RequestMapping
	public ModelAndView getActorsByFilmId(String filmId) {
		ModelAndView mv = new ModelAndView();
		List<Actor> actor = filmDAO.getActorsByFilmId(filmId);
		mv.addObject("film", actor);
		mv.setViewName("/WEB-INF/views/showfilm.jsp");
		return mv;
	}
	
	//TODO add request mapping, fix method to properly delete film
	//@RequestMapping
	public ModelAndView deleteFilm(Film film) {
		filmDAO.deleteFilm(film);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/views/showfilm.jsp");
		return mv;
	}
	
	//TODO add request mapping
	//@RequestMapping
	public ModelAndView updateFilm(Film film) {
		filmDAO.addFilm(film);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/views/showfilm.jsp");
		return mv;
	}
	

	
}
