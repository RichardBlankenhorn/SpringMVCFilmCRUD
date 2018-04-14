package com.skilldistillery.film.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;
import com.skilldistillery.film.entities.Language;

//import org.springframework.stereotype.Component;

public class DatabaseAccessorObject implements DatabaseAccessor {

	private static final String URL2 = "jdbc:mysql://localhost:3306/sdvid";
	private static final String user = "student";
	private static final String pass = "student";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			System.err.println("Unable to load DB Driver. Exiting.");
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public Film getFilmById(String filmId) {
		Film film = null;
		try {
			String sql = "SELECT * FROM film WHERE id = ?";
			Connection conn = DriverManager.getConnection(URL2, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			int fID = Integer.parseInt(filmId.trim());
			stmt.setInt(1, fID);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				film = new Film(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getDouble(7), rs.getInt(8), rs.getDouble(9), rs.getString(10),
						rs.getString(11));
			}
			// Testing get actors by film id
			ArrayList<Actor> a = getActorsByFilmId(filmId);
			film.setActors(a);
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return film;
	}

	@Override
	public Actor getActorById(String actorId) {
		Actor actor = null;
		try {
			String sql = "SELECT * FROM actor WHERE id = ?";
			Connection conn = DriverManager.getConnection(URL2, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			int aID = Integer.parseInt(actorId);
			stmt.setInt(1, aID);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				actor = new Actor(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Film> getFilmBySearchKeyword(String keyword) {

		List<Film> films = null;
		String newKW;
		try {
			String sql = "SELECT * FROM film WHERE title LIKE ?";
			Connection conn = DriverManager.getConnection(URL2, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			newKW = "%" + keyword + "%";
			stmt.setString(1, newKW);
			ResultSet rs = stmt.executeQuery();

			films = new ArrayList<>();
			while (rs.next()) {
				Film film = new Film(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getDouble(7), rs.getInt(8), rs.getDouble(9), rs.getString(10),
						rs.getString(11));
				films.add(film);
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return films;
	}

	@Override
	public ArrayList<Actor> getActorsByFilmId(String filmId) {
		ArrayList<Actor> actorsByFilmId = null;

		try {
			String sql = "SELECT a.id, a.first_name, a.last_name FROM actor a JOIN film_actor fa "
					+ "ON a.id = fa.actor_id JOIN film f ON fa.film_id = f.id WHERE f.id = ?";
			Connection conn = DriverManager.getConnection(URL2, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			int fID = Integer.parseInt(filmId);
			stmt.setInt(1, fID);
			ResultSet rs = stmt.executeQuery();

			actorsByFilmId = new ArrayList<>();
			while (rs.next()) {
				Actor actor = new Actor(rs.getInt(1), rs.getString(2), rs.getString(3));
				actorsByFilmId.add(actor);
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actorsByFilmId;
	}

	@Override
	public Film addFilm(Film film) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL2, user, pass);
			conn.setAutoCommit(false);
			String sql = "INSERT INTO film (title, description, release_year, language_id, rental_duration, "
					+ "rental_rate, length, replacement_cost, rating, special_features) VALUES(?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setString(3, film.getYear());
			stmt.setInt(4, film.getLanguageID());
			stmt.setInt(5, film.getRentalDuration());
			stmt.setDouble(6, film.getRentalRate());
			stmt.setInt(7, film.getFilmLength());
			stmt.setDouble(8, film.getReplacementCost());
			stmt.setString(9, film.getRating());
			stmt.setString(10, film.getSpecialFeatures());

			int updateCount = stmt.executeUpdate();

			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					int newFilmId = keys.getInt(1);
					film.setId(newFilmId);
				}
				conn.commit();
			} else {
				film = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					System.err.println("Trying to RollBack");
				}
			}
			throw new RuntimeException("Error inserting film " + film);
		}
		return film;
	}

	@Override
	public Film deleteFilm(Film film) {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(URL2, user, pass);
			conn.setAutoCommit(false);

			String sql = "DELETE FROM film WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, film.getId());
			int updateCount = stmt.executeUpdate();

			if (updateCount == 1) {
				conn.commit();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					System.err.println("Trying to RollBack");
				}
			}
			throw new RuntimeException("Error deleting film " + film);
		}
		return film;
	}

	@Override
	public Language getLanguageById(String filmId) {
		Language l = null;
		try {
			String sql = "SELECT l.id, l.name FROM film f JOIN language l ON f.language_id = l.id WHERE f.id = ?";
			Connection conn = DriverManager.getConnection(URL2, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			int fID = Integer.parseInt(filmId);
			stmt.setInt(1, fID);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				l = new Language(rs.getInt(1), rs.getString(2));
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return l;
	}

}
