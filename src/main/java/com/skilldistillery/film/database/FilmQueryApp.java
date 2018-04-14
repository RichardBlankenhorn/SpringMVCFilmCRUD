package com.skilldistillery.film.database;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;
import com.skilldistillery.film.entities.Language;
import com.skilldistillery.film.database.DatabaseAccessor;
import com.skilldistillery.film.database.DatabaseAccessorObject;

public class FilmQueryApp {

	//DatabaseAccessor db = new DatabaseAccessorObject();

//	public static void main(String[] args) {
//		FilmQueryApp fap = new FilmQueryApp();
//		fap.run();
//	}

	public void run() {
		DatabaseAccessor db = new DatabaseAccessorObject();
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Please enter a film title: ");
		String title = kb.nextLine();
		System.out.println("Please enter a description: ");
		String desc = kb.nextLine();
		System.out.println("Please enter");
		
//		System.out.println("Please select from the following menu");
//		System.out.println("1. Select Film by Film ID\n2. Select Film by Search Keyword\n3. Add a New Film\n4. Exit Application");
//		String input = kb.nextLine();
//		
//		String id = "";
//		if (input.trim().equals("1")) {
//			System.out.print("Please select a Film by the film ID: ");
//			if (kb.hasNextInt()) {
//				id = kb.nextLine();
//				Film f = db.getFilmById(id);
//				System.out.println("Film Title: "+ f.getTitle() + " | " + "Film Rating: " + f.getRating());
//			}
//			// Return message if film ID invalid. Ask user to select again
//			else {
//				System.out.println("Invalid ID. It must be an integer.");
//				run();
//			}
//		}
//		else if (input.trim().equals("2")) {
//			System.out.print("Please enter a search keyword: ");
//			String text = kb.nextLine();
//			
//			// Verify if result was returned
//			List<Film> films = db.getFilmBySearchKeyword(text);
//			if (films.size() == 0) {
//				System.out.print("There were no films that matched the keyword " + text);
//				// Print results
//			} else {
//				System.out.println("\nBelow is the information for the selected films");
//				for (Film f : films) {
//					Language l = db.getLanguageById(Integer.toString(f.getId()));
//					List<Actor> actors = db.getActorsByFilmId(Integer.toString(f.getId()));
//					System.out.println("Film Title: " + f.getTitle() + " | Year: " + f.getYear() + " | Rating: "
//							+ f.getRating() + " | Description: " + f.getDescription() + " | Language: "
//							+ l.getId());
//					System.out.println("The actors in this film are " + actors.toString() + "\n");
//				}
//			}
//			//makeSelection();
//			//return;
//		}
//		
//		kb.close();
		
	}

	// Prompt user to make a selection from the given menu
//	private void makeSelection() {
//		Scanner input = new Scanner(System.in);
//		String selection = userMenu(input);
//		if (selection.trim().equals("3")) {
//			System.out.println("Goodbye");
//			return;
//		} else if (selection.trim().equals("1") || selection.trim().equals("2") || selection.trim().equals("4")) {
//			implementSelection(input, selection);
//			return;
//		} else {
//			System.out.println("The number provided was not valid. Please select a valid option");
//			makeSelection();
//		}
//		input.close();
//	}
//
//	private void implementSelection(Scanner input, String selection) {
//
//		DatabaseAccessorObject dbAccess = new DatabaseAccessorObject();
//		String id = "";
//
//		if (selection.equals("1")) {
//			// Select a Film by the film ID
//			System.out.print("Please select a Film by the film ID: ");
//			if (input.hasNextInt()) {
//				id = input.nextLine();
//			}
//			// Return message if film ID invalid. Ask user to select again
//			else {
//				System.out.println("Invalid ID. It must be an integer.");
//				input = new Scanner(System.in);
//				implementSelection(input, selection);
//				return;
//			}
//
//			// Verify if result was returned
//			Film film = dbAccess.getFilmById(id);
//			Language l = dbAccess.getLanguageById(id);
//			List<Actor> actors = dbAccess.getActorsByFilmId(id);
//			if (film == null) {
//				System.out.println("The film ID provided did not return a match");
//				implementSelection(input, selection);
//			}
//			// Print film results
//			else {
//				System.out.println("\nBelow is the information for the selected Film(s)");
//				System.out.println("Film Title: " + film.getTitle() + " | Year: " + film.getYear()
//						+ " | Rating: " + film.getRating() + " | Description: " + film.getDescription()
//						+ " | Language: " + l.getId());
//				System.out.println("The actors in this film are " + actors.toString());
//				System.out.print("Would you like to delete this film? (Yes or No): ");
//				String answer = input.nextLine();
//				if (answer.toUpperCase().equals("YES")) {
//					dbAccess.deleteFilm(film);
//					System.out.println("The film with title " + film.getTitle() + " has been deleted\n");
//					makeSelection();
//					return;
//				} else if (answer.toUpperCase().equals("NO")) {
//					System.out.println();
//					makeSelection();
//					return;
//				}
//			}
//
//		} else if (selection.equals("2")) {
//			System.out.print("Please enter a search keyword: ");
//			String text = input.nextLine();
//
//			// Verify if result was returned
//			List<Film> films = dbAccess.getFilmBySearchKeyword(text);
//			if (films.size() == 0) {
//				System.out.print("There were no films that matched the keyword " + text);
//				// Print results
//			} else {
//				System.out.println("\nBelow is the information for the selected films");
//				for (Film f : films) {
//					Language l = dbAccess.getLanguageById(Integer.toString(f.getId()));
//					List<Actor> actors = dbAccess.getActorsByFilmId(Integer.toString(f.getId()));
//					System.out.println("Film Title: " + f.getTitle() + " | Year: " + f.getYear() + " | Rating: "
//							+ f.getRating() + " | Description: " + f.getDescription() + " | Language: "
//							+ l.getId());
//					System.out.println("The actors in this film are " + actors.toString() + "\n");
//				}
//			}
//			makeSelection();
//			return;
//		} else if (selection.equals("4")) {
//			System.out.print("Please enter a film title: ");
//			String title = input.nextLine();
//			System.out.print("Please enter a description: ");
//			String desc = input.nextLine();
//			System.out.print("Please enter the release year: ");
//			String year = input.nextLine();
//			System.out.println("Please enter the rating");
//			System.out.print("Choices are (G, PG, PG13, R, NC17): ");
//			String rating = input.nextLine();
//			System.out.println("Please enter the special features. ");
//			System.out.print("Choices are (Trailers, Commentaries, Deleted Scenes, Behind the Scenes): ");
//			String specFeat = input.nextLine();
//			System.out.print("Please enter a language ID: ");
//			int lang_id = input.nextInt();
//			System.out.print("Please enter a rental duration: ");
//			int dur = input.nextInt();
//			System.out.print("Please enter the rental rate: ");
//			double rate = input.nextDouble();
//			System.out.print("Please enter the length: ");
//			int len = input.nextInt();
//			System.out.print("Please enter the replacement cost: ");
//			double repCost = input.nextDouble();
//
//			Film newFilm = new Film(0, title, desc, year, lang_id, dur, rate, len, repCost, rating, specFeat);
//
//			Film updateFilm = dbAccess.addFilm(newFilm);
//			System.out.println("The new film ID is " + updateFilm.getId() + "/n");
//			makeSelection();
//			return;
//		}
//
//	}
//
//	// Present a user menu to the user and allow user to make a selection
//	public String userMenu(Scanner input) {
//		System.out.println("Please select from the following options:\n1. Look up a film by its ID\n2. "
//				+ "Look up a film by a search keyword\n3. Exit the application\n4. Add New Film");
//		String selection;
//		if (input.hasNext()) {
//			selection = input.nextLine();
//		} else {
//			selection = "";
//		}
//		return selection;
//	}

}
