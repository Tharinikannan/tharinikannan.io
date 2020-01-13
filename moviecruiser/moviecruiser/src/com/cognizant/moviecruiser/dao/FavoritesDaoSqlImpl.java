package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoSqlImpl implements FavoritesDao {

	public static final String ADD_MOVIES_TO_FAVORITES = "insert into favorite(fv_us_id,fv_mo_id) values (?,?)";

	public void addFavoriteMovies(long userId, long moviesId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(ADD_MOVIES_TO_FAVORITES);
			statement.setLong(1, userId);
			statement.setLong(2, moviesId);
			int noOfRows = statement.executeUpdate();
			System.out.println("Number Of Rows Affected" + noOfRows);
		} catch (SQLException e) {
			System.out.println("Items Not Added into Favorites");
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

			}
		}
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
		}

	}

	public static final String GET_MOVIES_FROM_FAVORITES = "select mo_id,mo_title,mo_gross,mo_genre from favorite inner join movie_list on mo_id =fv_mo_id inner join user on us_id =favorite.fv_us_id where us_id=?";
	public static final String GET_TOTAL = "select us_id, count(movie_list.mo_id) as mo_total from favorite inner join movie_list on movie_list.mo_id=favorite.fv_mo_id inner join user on user.us_id = favorite.fv_us_id where user.us_id=?";

	public Favorites getAllFavoriteMovies(long userId) throws FavoritesEmptyException {
		ArrayList<Movies> moviesList = new ArrayList<Movies>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ResultSet resultSettotal = null;
		Movies movies = null;
		Favorites favorites = new Favorites();
		try {
			statement = connection.prepareStatement(GET_MOVIES_FROM_FAVORITES);
			statement.setLong(1, userId);
			resultSet = statement.executeQuery();
			System.out.println("Number Of Rows Affected" + resultSet);
			while (resultSet.next()) {
				movies = new Movies();
				movies.setId(resultSet.getLong("mo_id"));
				movies.setTitle(resultSet.getString("mo_title"));
				movies.setGross(resultSet.getLong("mo_gross"));
				movies.setGenre(resultSet.getString("mo_genre"));
				moviesList.add(movies);
			}
			if (moviesList.size() == 0) {
				throw new FavoritesEmptyException();
			}
			System.out.println("Successfully");
			favorites.setMoviesList(moviesList);
			preparedStatement = connection.prepareStatement(GET_TOTAL);
			preparedStatement.setLong(1, userId);
			resultSettotal = preparedStatement.executeQuery();
			System.out.println("Number Of Rows Affected" + resultSettotal);
			while (resultSettotal.next()) {
				favorites.setTotal(resultSettotal.getInt("mo_total"));
			}

		} catch (SQLException e) {
			System.out.println("Data Not Displayed");
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (resultSettotal != null)
					resultSettotal.close();
				if (statement != null)
					statement.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

			}
		}
		return favorites;
	}

	public static final String REMOVE_FAVORITES = "delete from favorite where fv_us_id=? and fv_mo_id=? limit 1";

	public void removeFavoriteMovies(long userId, long moviesId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(REMOVE_FAVORITES);
			statement.setLong(1, userId);
			statement.setLong(2, moviesId);
			int noOfRows = statement.executeUpdate();
			System.out.println("Number Of Rows Affected" + noOfRows);
		} catch (SQLException e) {
			System.out.println("Movies Not Removed from Favorites");
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				System.out.println("Connection not closed");
			}
		}
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Connection not closed");
		}
	}

}
