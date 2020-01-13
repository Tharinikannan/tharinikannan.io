package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoSqlImplTest {
	public static void testFavoritesDaoSqlImpl() {
		new FavoritesDaoSqlImpl().addFavoriteMovies(1, 3);
	}

	public static void testgetAllFavoritesMovies() throws FavoritesEmptyException {
		long userId = 1L;

		Favorites favorites = new FavoritesDaoSqlImpl().getAllFavoriteMovies(userId);
		List<Movies> MoviesList = favorites.getMoviesList();
		System.out.format("%-20s%-20s%-20s%-15s\n", "Id", "Title", "Teaser", "Gross");

		for (Movies movies : MoviesList) {

			System.out.format("%-20s%-20s%-20s%-15s\n", movies.getId(), movies.getTitle(), movies.getGross(),
					movies.getGenre());

		}
		System.out.format("%-10s\n", "Total" + favorites.getTotal());
	}

	public static void testremoveFavorites() throws FavoritesEmptyException {
		new FavoritesDaoSqlImpl().removeFavoriteMovies(1, 3);

	}

	public static void main(String[] args) throws FavoritesEmptyException {
		testFavoritesDaoSqlImpl();
		testgetAllFavoritesMovies();
		testremoveFavorites();
	}

}
