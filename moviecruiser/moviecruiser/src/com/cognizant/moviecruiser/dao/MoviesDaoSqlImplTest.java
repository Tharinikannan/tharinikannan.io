package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoSqlImplTest {
	public static void testgetMoviesListAdmin() {
		new MoviesDaoSqlImpl().getMoviesListAdmin();
		List<Movies> moviesList = new MoviesDaoSqlImpl().getMoviesListAdmin();
		System.out.format("%-10s%-20s%-15s%-15s%-15s%-15s%-15s\n", "Id", "Title", "Gross", "Active", "DateOfLaunch",
				"Teaser", "Genre");
		String active;
		String teaser;
		for (Movies movies : moviesList) {

			if (movies.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (movies.getTeaser() == true) {
				teaser = "Yes";
			} else {
				teaser = "No";
			}

			System.out.format("%-10s%-20s%-15s%-15s%-15s%-15s%-15s\n", movies.getId(), movies.getTitle(),
					movies.getGross(), active, movies.getDateOfLaunch(), teaser, movies.getGenre());
		}
	}

	public static void testgetMoviesListCustomer() {
		List<Movies> moviesList = new MoviesDaoSqlImpl().getMoviesListCustomer();
		System.out.format("%-10s%-20s%-15s%-15s%-15s%-15s%-15s\n", "Id", "Title", "Gross", "Active", "DateOfLaunch",
				"Teaser", "Genre");
		String active;
		String teaser;
		for (Movies movies : moviesList) {

			if (movies.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (movies.getTeaser() == true) {
				teaser = "Yes";
			} else {
				teaser = "No";
			}

			System.out.format("%-10s%-20s%-15s%-15s%-15s%-15s%-15s\n", movies.getId(), movies.getTitle(),
					movies.getGross(), active, movies.getDateOfLaunch(), teaser, movies.getGenre());
		}
	}

	public static void testgetmodifyMovies() {
		Movies movies = new Movies(3L, "Harry", 1287654687L, true, new DateUtil().convertToDate("23/03/2022"),
				"Science Fiction", true);
		new MoviesDaoSqlImpl().modifyMovies(movies);
		List<Movies> moviesList = new MoviesDaoSqlImpl().getMoviesListAdmin();
		System.out.println("AFTER MODIFICATION");
		System.out.format("%-10s%-20s%-15s%-15s%-15s%-15s%-15s\n", "Id", "Title", "Gross", "Active", "DateOfLaunch",
				"Teaser", "Genre");
		String active;
		String teaser;
		for (Movies movies1 : moviesList) {

			if (movies1.getActive() == true) {

				active = "Yes";
			} else {
				active = "No";
			}
			if (movies1.getTeaser() == true) {
				teaser = "Yes";
			} else {
				teaser = "No";
			}

			System.out.format("%-10s%-20s%-15s%-15s%-15s%-15s%-15s\n", movies1.getId(), movies1.getTitle(),
					movies1.getGross(), active, movies1.getDateOfLaunch(), teaser, movies1.getGenre());
		}
	}

	public static void testgetMovies() {
		long moviesId = 2;
		Movies movies = new MoviesDaoSqlImpl().getMovies(moviesId);
		String active;
		String teaser;
		System.out.format("%-10s%-20s%-15s%-15s%-15s%-15s%-15s\n", "Id", "Title", "Gross", "Active", "DateOfLaunch",
				"Teaser", "Genre");
		if (movies.getActive() == true) {

			active = "Yes";
		} else {
			active = "No";
		}
		if (movies.getTeaser() == true) {
			teaser = "Yes";
		} else {
			teaser = "No";
		}

		System.out.format("%-10s%-20s%-15s%-15s%-15s%-15s%-15s\n", movies.getId(), movies.getTitle(), movies.getGross(),
				active, movies.getDateOfLaunch(), teaser, movies.getGenre());
	}

	public static void main(String[] args) {
		testgetMoviesListAdmin();
		testgetmodifyMovies();
		testgetMoviesListCustomer();
		testgetMovies();
	}

}
