import java.sql.ResultSet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

@Path("")
public class MessageResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public String test() throws Exception {
		return "works!";
	}

	// Returns all Movies
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("movies")
	public String movies(@PathParam("movies") int id_movies) throws Exception {
		ResultSet res = DatabaseHandler.getInstance().getConnection()
				.createStatement()
				.executeQuery("SELECT idMovie, Title, Description FROM movie");
		StringBuffer b = new StringBuffer();

		b.append("[");
		while (res.next()) {
			b.append("{ ");
			b.append("\"idMovie\"");
			b.append(" : ");
			b.append(res.getString("idMovie").toString());
			b.append(" , ");
			b.append("\"Title\"");
			b.append(" : \"");
			b.append(res.getString("Title").toString());
			b.append("\" , ");
			b.append("\"Description\"");
			b.append(" : \"");
			b.append(res.getString("Description").toString());
			b.append("\" }");
			if (!res.isLast()) {
				b.append(",");
			}
			b.append("\n");
		}
		b.append("]");

		return b.toString().trim();
	}

	// Returns the chosen Movie, chosen by it's id
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("movie/{movie}")
	public String movie(@PathParam("movie") int movie) throws Exception {
		ResultSet res = DatabaseHandler
				.getInstance()
				.getConnection()
				.createStatement()
				.executeQuery(
						"SELECT Title, Description FROM movie WHERE idMovie = '"
								+ movie + "'");
		StringBuffer b = new StringBuffer();

		while (res.next()) {
			b.append("{ ");
			b.append("Title");
			b.append(" : ");
			b.append(res.getString("Title").toString());
			b.append(" , ");
			b.append("Desciption");
			b.append(" : ");
			b.append(res.getString("Description").toString());

			b.append(" }");
			b.append("\n");
		}

		return b.toString().trim();

	}

	// Returns all user
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("user")
	public String users(@PathParam("user") String user) throws Exception {
		ResultSet res = DatabaseHandler.getInstance().getConnection()
				.createStatement()
				.executeQuery("SELECT idUser, Name FROM user");
		StringBuffer b = new StringBuffer();

		while (res.next()) {
			b.append("{ ");
			b.append("idUser");
			b.append(" : ");
			b.append(res.getString("idUser").toString());
			b.append(" }");
			b.append("\n");
		}

		return b.toString().trim();
	}

	// Returns one chosen user, chosen by his id
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("user/{user}")
	public String user(@PathParam("user") int user) throws Exception {
		ResultSet res = DatabaseHandler
				.getInstance()
				.getConnection()
				.createStatement()
				.executeQuery(
						"SELECT idUser, Name FROM user WHERE idUser = '" + user
								+ "'");
		StringBuffer b = new StringBuffer();

		while (res.next()) {
			b.append("{ ");
			b.append("Name");
			b.append(" : ");
			b.append(res.getString("Name").toString());
			b.append(" }");
			b.append("\n");
		}

		return b.toString().trim();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("participated_screening/{participated_screening}")
	public String user_history(
			@PathParam("participated_screening") int user_idUser)
			throws Exception {
		ResultSet res = DatabaseHandler
				.getInstance()
				.getConnection()
				.createStatement()
				.executeQuery(
						"SELECT idParticipated_screening , screening_screentime, user_idUser FROM participated_screening where user_idUser = ' "
								+ user_idUser + "'");
		StringBuffer b = new StringBuffer();

		while (res.next()) {
			b.append("{ ");
			b.append("Screentime");
			b.append(" : ");
			b.append(res.getString("screening_screentime").toString());
			b.append(" , ");
			b.append("User");
			b.append(" : ");
			b.append(res.getString("user_idUser").toString());
			b.append(" }");
			b.append("\n");
		}

		return b.toString().trim();

	}

	// Returns one tweet, by the idUser
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("tweet/{tweet}")
	public String tweet(@PathParam("tweet") int user_id) throws Exception {
		ResultSet res = DatabaseHandler
				.getInstance()
				.getConnection()
				.createStatement()
				.executeQuery(
						"SELECT Text, Geo , Name, tweettime FROM tweet JOIN user ON idUser = user_idUser WHERE idUser =  '"
								+ user_id + "' ORDER BY tweettime ASC");
		StringBuffer b = new StringBuffer();

		while (res.next()) {
			b.append("{ ");
			b.append("Text");
			b.append(" : ");
			b.append(res.getString("Text").toString());
			b.append(" , ");
			b.append("Geo.Lat");
			b.append(" : ");
			b.append(res.getString("Geo.Lat").toString());
			b.append(" , ");
			b.append("Geo.Long");
			b.append(" : ");
			b.append(res.getString("Geo.Long").toString());
			b.append(" , ");
			b.append("Name");
			b.append(" : ");
			b.append(res.getString("Name").toString());
			b.append(" , ");
			b.append("Time");
			b.append(" : ");
			b.append(res.getString("tweettime").toString());
			b.append(" }");
			b.append("\n");

		}

		return b.toString().trim();

	}

	// Returns one screening, by the idMovie
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("screening/{screening}")
	public String screening(@PathParam("screening") int id_movie)
			throws Exception {

		ResultSet res = DatabaseHandler
				.getInstance()
				.getConnection()
				.createStatement()
				.executeQuery(
						"SELECT screentime, venue_Name, movie_Title FROM screening WHERE movie_idMovie = '"
								+ id_movie + "'");
		StringBuffer b = new StringBuffer();

		while (res.next()) {
			b.append("{ ");
			b.append("screentime");
			b.append(" : ");
			b.append(res.getString("screentime").toString());
			b.append(" , ");
			b.append("venue_Name");
			b.append(" : ");
			b.append(res.getString("venue_Name").toString());
			b.append(" , ");
			b.append("movie_Title");
			b.append(" : ");
			b.append(res.getString("movie_Title").toString());
			b.append(" }");
			b.append("\n");
		}

		return b.toString().trim();
	}

	// Returns all venues
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("venue")
	public String venue(@PathParam("venue") String venue) throws Exception {
		ResultSet res = DatabaseHandler.getInstance().getConnection()
				.createStatement().executeQuery("SELECT Geo_Lat, Geo_Long, Name FROM venue ");
		StringBuffer b = new StringBuffer();
		b.append("[");
		while (res.next()) {
			b.append("{ ");
			b.append("\"Name\"");
			b.append(" : \"");
			b.append(res.getString("Name").toString());
			b.append("\" , ");
			b.append("\"Geo_Lat\"");
			b.append(" : ");
			b.append(res.getString("Geo_Lat").toString());
			b.append(" , ");
			b.append("\"Geo_Long\"");
			b.append(" : ");
			b.append(res.getString("Geo_Long").toString());
			b.append(" }");
			if (!res.isLast()) {
				b.append(",");
			}
			b.append("\n");
		}
		b.append("]");
		return b.toString().trim();

	}

	// Return user history
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("history/{history}")
	public String history(@PathParam("history") int user_id) throws Exception {
		ResultSet res = DatabaseHandler
				.getInstance()
				.getConnection()
				.createStatement()
				.executeQuery(
				
						"SELECT u.Name, r.Star, r.Text, s.movie_Title as Title, s.screentime,s.venue_Name "
								+ "FROM user as u JOIN participated_screening as p ON u.idUser = p.user_idUser JOIN rating as r ON r.pscr = p.idParticipated_screening JOIN screening as s ON s.idScreening = p.idScreening "
								+ "WHERE u.idUser = " + user_id);
		StringBuffer b = new StringBuffer();
		b.append("[");
		while (res.next()) {
			b.append("{ ");
			b.append("\"Venue\"");
			b.append(" :\"");
			b.append(res.getString("venue_Name").toString());
			b.append("\" , ");
			b.append("\"Title\"");
			b.append(" : \"");
			b.append(res.getString("Title").toString());
			b.append("\" , ");
			b.append("\"Text\"");
			b.append(" : \"");
			b.append(res.getString("Text").toString());
			b.append("\" , ");
			b.append("\"Name\"");
			b.append(" : \"");
			b.append(res.getString("Name").toString());
			b.append("\" , ");
			b.append("\"Screentime\"");
			b.append(" : \"");
			b.append(res.getString("screentime").toString());
			b.append("\" , ");
			b.append("\"Star\"");
			b.append(" : ");
			b.append(res.getString("Star").toString());
			b.append("}");
			if (!res.isLast()) {
				b.append(",");
			}
			//b.append("\n");
		}
		b.append("]");
		return b.toString().trim();

	}

	@XmlRootElement
	class ServerInfo {
		public String server;
	}

	// Diese Eintraege werden zum
	// Verbindungsaufbau benoetigt.

}
