import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;


public class CORSFilter implements ContainerResponseFilter {
	 @Override
	    public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {
	        response.getHttpHeaders().add("Access-Control-Allow-Origin", "*");
	        return response;
	    }       
}
