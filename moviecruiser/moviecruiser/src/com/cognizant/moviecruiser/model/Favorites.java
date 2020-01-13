package com.cognizant.moviecruiser.model;

import java.util.List;

public class Favorites {

	private List<Movies> MoviesList;
	private int total;

	public Favorites() {
		super();
	}

	public Favorites(List<Movies> moviesList, int total) {
		super();
		MoviesList = moviesList;
		this.total = total;
	}

	public List<Movies> getMoviesList() {
		return MoviesList;
	}

	public void setMoviesList(List<Movies> moviesList) {
		MoviesList = moviesList;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MoviesList == null) ? 0 : MoviesList.hashCode());
		result = prime * result + total;
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
		Favorites other = (Favorites) obj;
		if (MoviesList == null) {
			if (other.MoviesList != null)
				return false;
		} else if (!MoviesList.equals(other.MoviesList))
			return false;
		if (total != other.total)
			return false;
		return true;
	}

}
