import java.io.IOException;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.jersey.api.core.ClasspathResourceConfig;
import com.sun.jersey.api.core.DefaultResourceConfig;
import com.sun.net.httpserver.HttpServer;

public class StartRestServer {
//	public static Statement stmt = null;
//
//	public static ResultSet res = null;

//	public static java.sql.Connection conn = null;
	

	public static void main(String[] args) throws Exception {
		new StartRestServer();
	}

	@SuppressWarnings("unchecked")
	public StartRestServer() throws IllegalArgumentException, IOException {
		
		DefaultResourceConfig rc = new ClasspathResourceConfig();
		rc.getContainerResponseFilters().add(new CORSFilter());

		HttpServer server = HttpServerFactory.create("http://localhost:8080/", rc);
		server.start();
	}
}
