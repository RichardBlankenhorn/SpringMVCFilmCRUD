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

		db = new DatabaseAccessorObject();
		//Film film = filmDAO.getFilmById(filmId);
		Film film = db.getFilmById(filmId);
		mv.addObject("film", film);
		mv.setViewName("/WEB-INF/views/showfilm.jsp");
		return mv;
	}

	@RequestMapping(path = "addFilm.do", method = RequestMethod.POST)
	public ModelAndView addFilm(Film film, RedirectAttributes redir) {
<<<<<<< HEAD
		//filmDAO.addFilm(film);
		db.addFilm(film);
=======
//		filmDAO.addFilm(film);
>>>>>>> ac20d4097de5ad80c7042db70787ba6f114ee2f2
		ModelAndView mv = new ModelAndView();
		db = new DatabaseAccessorObject();
//		Film film = db.addFilm(film);
		redir.addFlashAttribute("film", film);
		mv.setViewName("/WEB-INF/views/showuserfilm.jsp");
		return mv;
	}

	@RequestMapping(path = "searchFilmByKeyword.do", method = RequestMethod.GET)
	public ModelAndView getFilmBySearchKeyword(@RequestParam(name = "keyword") String keyword) {
		ModelAndView mv = new ModelAndView();
<<<<<<< HEAD
		//List<Film> films = filmDAO.getFilmBySearchKeyword(keyword);
=======
		db = new DatabaseAccessorObject();
//		List<Film> films = filmDAO.getFilmBySearchKeyword(keyword);
>>>>>>> ac20d4097de5ad80c7042db70787ba6f114ee2f2
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
