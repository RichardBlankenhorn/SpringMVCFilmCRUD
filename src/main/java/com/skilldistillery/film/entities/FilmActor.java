package com.skilldistillery.film.entities;

public class FilmActor {

	private int actorID;
	private int filmID;

	public int getActorID() {
		return actorID;
	}

	public void setActorID(int actorID) {
		this.actorID = actorID;
	}

	public int getFilmID() {
		return filmID;
	}

	public void setFilmID(int filmID) {
		this.filmID = filmID;
	}

	public FilmActor(int actorID, int filmID) {
		super();
		this.actorID = actorID;
		this.filmID = filmID;
	}

	@Override
	public String toString() {
		return "FilmActor [actorID=" + actorID + ", filmID=" + filmID + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + actorID;
		result = prime * result + filmID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FilmActor other = (FilmActor) obj;
		if (actorID != other.actorID)
			return false;
		if (filmID != other.filmID)
			return false;
		return true;
	}

}
