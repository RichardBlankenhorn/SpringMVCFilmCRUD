package com.skilldistillery.controllers;

import java.util.List;

import javax.xml.ws.RequestWrapper;

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
	// private FilmDAO filmDAO;
	private DatabaseAccessor db;

	public void setFilmDAO(DatabaseAccessor filmDAO) {
		this.db = filmDAO;
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
		List<Actor> actor = db.getActorsByFilmId(filmId);
		mv.addObject("film", actor);
		mv.setViewName("/WEB-INF/views/showfilm.jsp");
		return mv;
	}

	/*
	 * Working leave alone
	 */

	@RequestMapping(path = "delete.do", method = RequestMethod.POST)
	public ModelAndView deleteFilm(@RequestParam(name = "filmID") String filmID) {
		ModelAndView mv = new ModelAndView();
		db = new DatabaseAccessorObject();
		
		Film film = db.getFilmById(filmID);
		mv.addObject("delFilm", film);
		System.out.println(film);
		db.deleteFilm(film);
		
		//mv.setViewName("/WEB-INF/views/showfilm.jsp");
		mv.setViewName("/WEB-INF/views/deletedFilmMessage.jsp");
		return mv;
	}

	// TODO add request mapping
	@RequestMapping(path = "updateFilm.do", method = RequestMethod.POST)
	public ModelAndView updateFilm(Film film) {
		ModelAndView mv = new ModelAndView();
		db = new DatabaseAccessorObject();
	
		Film newFilm = db.updateFilm(film);
		mv.addObject("upFilm",newFilm);
		mv.setViewName("/WEB-INF/views/updatedFilm.jsp");
		return mv;
	}
	
	@RequestMapping(path = "update.do", method = RequestMethod.GET)
	public ModelAndView changeFilm(String filmID) {
		ModelAndView mv = new ModelAndView();
		
		Film f = db.getFilmById(filmID);
		mv.addObject("origFilm",f);
		
//		Film newFilm = db.updateFilm(f);
//		mv.addObject("upFilm",newFilm);
		
		mv.setViewName("/WEB-INF/views/changeFilm.jsp");
		return mv;
	}

}
