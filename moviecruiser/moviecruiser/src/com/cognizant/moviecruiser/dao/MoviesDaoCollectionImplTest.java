package com.cognizant.moviecruiser.dao;

import java.util.List;
import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoCollectionImplTest {

	public static void testGetMoviesListAdmin() {
		System.out.println("Movies List for Admin");
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		List<Movies> moviesList = moviesDao.getMoviesListAdmin();
		for (Movies movies : moviesList) {
			System.out.println(movies);
		}
	}

	public static void testGetMoviesListCustomer() {
		System.out.println("Movies list for customer");
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		List<Movies> moviesList = moviesDao.getMoviesListCustomer();
		for (Movies movies : moviesList) {
			System.out.println(movies);
		}
	}

	public static void testModifyMovies() {
		Movies item = new Movies(5L, "Ayan", 2234567L, true, new DateUtil().convertToDate("06/11/2022"), "Thriller",
				true);
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		moviesDao.modifyMovies(item);
		System.out.println("*** Modified Movie List***");
		testGetMoviesListAdmin();
		Movies Modified_item = moviesDao.getMovies(item.getId());
		System.out.println("Modified movie details\n" + Modified_item);
	}

	public static void main(String[] args) {
		testGetMoviesListAdmin();
		testGetMoviesListCustomer();
		testModifyMovies();
	}

}
