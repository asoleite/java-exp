package pt.andre.jaxb_wsdl_client;

import pt.asoleite.movie_web_service.GetMovieRequest;
import pt.asoleite.movie_web_service.GetMovieResponse;
import pt.asoleite.movie_web_service.MoviePort;
import pt.asoleite.movie_web_service.MoviePortService;


public class App 
{
    public static void main( String[] args )
    {
    	
    		MoviePortService mps = new MoviePortService();
        MoviePort port = mps.getMoviePortSoap11(); 
        
        GetMovieRequest req = new GetMovieRequest();
        req.setName("Interstellar");
        
        GetMovieResponse res = port.getMovie(req);
        System.out.println(res.getMovie().getSynopsis());
        
    }
}
