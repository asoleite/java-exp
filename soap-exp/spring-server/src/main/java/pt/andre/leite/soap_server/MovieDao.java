package pt.andre.leite.soap_server;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import pt.asoleite.movie_web_service.Movie;

@Component
public class MovieDao {
	private static final Map<String, Movie> movies = new HashMap<String, Movie>();

	@PostConstruct
	public void initData() {
		Movie interstellar = new Movie();
		interstellar.setName("Interstellar");
		interstellar.setGenre("Adventure, Drama, Sci-Fi");
		interstellar.setSynopsis("A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.");
		interstellar.setYear("2014");
		
		movies.put(interstellar.getName().toLowerCase(), interstellar);
		
		Movie inception = new Movie();
		inception.setName("Inception");
		inception.setGenre("Action, Adventure, Sci-Fi");
		inception.setSynopsis("A thief, who steals corporate secrets through use of dream-sharing technology, is given the inverse task of planting an idea into the mind of a CEO.");
		inception.setYear("2010");
		
		movies.put(inception.getName().toLowerCase(), inception);
	}

	public Movie getByName(String name) {
		return movies.get(name.toLowerCase());
	}
}