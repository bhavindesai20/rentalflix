package io.egen.rentalflix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.UUID;

/**
 * Service implementing IFlix interface You can use any Java collection type to
 * store movies
 */

public class MovieService implements IFlix {

	Map<String, Movie> movieInfo = new ConcurrentHashMap<>();

	@Override
	public List<Movie> findAll() {
		return new ArrayList<>(movieInfo.values());
	}

	@Override
	public List<Movie> findByName(String name) {
		ArrayList<Movie> movieListByTitle = new ArrayList<Movie>();
		Iterator<Movie> allMovies = this.findAll().iterator();
		while (allMovies.hasNext()) {
			Movie getMovie = allMovies.next();
			boolean valid = getMovie.getTitle().contains(name);
			if (valid == true) {
				movieListByTitle.add(getMovie);
			}
		}
		return movieListByTitle;
	}

	@Override
	public Movie create(Movie movie) {
		movie.setId(UUID.randomUUID().toString());
		movieInfo.put(movie.getId(), movie);
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		
		if (!isMoviePresent(movie.getId())) {
			throw new IllegalArgumentException("Movie with Id: "+movie.getId()+" is not available");
		}
		movieInfo.put(movie.getId(), movie);
		return movie;
	}

	@Override
	public Movie delete(String id){
		Movie m=movieInfo.get(id);
		if (!isMoviePresent(id)) {
			throw new IllegalArgumentException("Movie with Id: "+id+" is not available");
		}
		movieInfo.remove(id);
		return m;
	}

	@Override
	public synchronized  boolean rentMovie(String movieId, String user){
		
		if(movieInfo.get(movieId).isRented()){
			throw new IllegalArgumentException("Movie with Id: "+movieId+" is not available");
		}
		movieInfo.get(movieId).setRented(true);
		System.out.println(user+" rented movie: "+ movieInfo.get(movieId).getTitle());
		return true;
	}

	// supportive methods
	public boolean isMoviePresent(String key) {
		return movieInfo.containsKey(key);
	}
	
	public Movie getDummy()
	{
		Movie m = new Movie("Herry potter",1990,"English");
		m=this.create(m);
		return m;
	}
	

}
