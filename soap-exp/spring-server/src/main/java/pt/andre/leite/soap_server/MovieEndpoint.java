package pt.andre.leite.soap_server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import pt.asoleite.movie_web_service.GetMovieRequest;
import pt.asoleite.movie_web_service.GetMovieResponse;

@Endpoint
public class MovieEndpoint {
	private static final String NAMESPACE_URI = "http://asoleite.pt/movie-web-service";

	private MovieDao dao;

	@Autowired
	public MovieEndpoint(MovieDao dao) {
		this.dao = dao;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMovieRequest")
	@ResponsePayload
	public GetMovieResponse getMovie(@RequestPayload GetMovieRequest gc) {
		GetMovieResponse response = new GetMovieResponse();
		response.setMovie(dao.getByName(gc.getName()));
		return response;
	}
	
}