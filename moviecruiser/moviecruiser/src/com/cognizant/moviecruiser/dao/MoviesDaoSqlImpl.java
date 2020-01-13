package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.Movies;

public class MoviesDaoSqlImpl implements MoviesDao {
	public static final String GET_ALL_MOVIES_ADMIN = "select * from movie_list";
	public static final String MODIFY_MOVIES = "update movie_list set mo_title =?,mo_gross =?,mo_active =?,mo_date_of_launch=?,mo_genre=?,mo_has_teaser =? where mo_id=?";

	public static final String GET_ALL_MOVIES_CUSTOMER = "select*from movie_list\r\n"
			+ "where mo_date_of_launch>=curdate() AND mo_active = 'Yes'\r\n";

	public List<Movies> getMoviesListAdmin() {
		ArrayList<Movies> moviesList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(GET_ALL_MOVIES_ADMIN);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Movies movies = new Movies();
				movies.setId(resultSet.getLong("mo_id"));
				movies.setTitle(resultSet.getString("mo_title"));
				movies.setGross(resultSet.getLong("mo_gross"));
				movies.setActive(resultSet.getString("mo_active").equals("Yes"));
				movies.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movies.setGenre(resultSet.getString("mo_genre"));
				movies.setTeaser(resultSet.getString("mo_has_teaser").equals("Yes"));
				moviesList.add(movies);
			}
		} catch (SQLException e) {
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
		return moviesList;

	}

	public ArrayList<Movies> getMoviesListCustomer() {
		ArrayList<Movies> moviesList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(GET_ALL_MOVIES_CUSTOMER);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Movies movies = new Movies();
				movies.setId(resultSet.getLong("mo_id"));
				movies.setTitle(resultSet.getString("mo_title"));
				movies.setGross(resultSet.getLong("mo_gross"));
				movies.setActive(resultSet.getString("mo_active").equals("Yes"));
				movies.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movies.setGenre(resultSet.getString("mo_genre"));
				movies.setTeaser(resultSet.getString("mo_has_teaser").equals("Yes"));
				moviesList.add(movies);
			}
		} catch (SQLException e) {
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

				System.out.println("Connection not closed");

			}
		}
		return moviesList;
	}

	public void modifyMovies(Movies movies) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(MODIFY_MOVIES);
			statement.setString(1, movies.getTitle());
			statement.setDate(4, new java.sql.Date(movies.getDateOfLaunch().getTime()));
			statement.setString(5, movies.getGenre());
			statement.setString(6, movies.getTeaser() ? "Yes" : "No");
			statement.setString(3, movies.getActive() ? "Yes" : "No");
			statement.setLong(2, movies.getGross());
			statement.setLong(7, movies.getId());
			int noOfRows = statement.executeUpdate();
			if (noOfRows > 0) {
				return;
			}
		} catch (SQLException e) {
			System.out.println("Update not Done");
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("Connection not closed");
			}
		}
		return;

	}

	public static final String GET_MOVIES = "select * from movie_list where mo_id = ?";

	@Override
	public Movies getMovies(Long moviesId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Movies movies = null;
		try {
			preparedStatement = connection.prepareStatement(GET_MOVIES);
			preparedStatement.setLong(1, moviesId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				movies = new Movies();
				movies.setId(resultSet.getLong("mo_id"));
				movies.setTitle(resultSet.getString("mo_title"));
				movies.setGross(resultSet.getLong("mo_gross"));
				movies.setActive(resultSet.getString("mo_active").equals("Yes"));
				movies.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movies.setGenre(resultSet.getString("mo_genre"));
				movies.setTeaser(resultSet.getString("mo_has_teaser").equals("Yes"));
			}

		} catch (SQLException e) {
			System.out.println("Id not Found");
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

		return movies;
	}

}
