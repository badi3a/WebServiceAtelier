package rest.ressources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloRessource {

	public HelloRessource() {
		// TODO Auto-generated constructor stub
	}
	// REST ws (REST Api) Hello
	//uri: api/hello
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response sayHello() {
		return Response
				.status(200)
				.entity("hello")
				.build();
	}
	//uri: api/hello/ahmed/benFoulen
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{fName}/{lName}")
	public Response sayHelloTo(@PathParam(value="fName")String firstName,
			@PathParam(value="lName")String lastName) {
		return Response
				.status(200)
				.entity("hello "+firstName+" "+lastName)
				.build();
	}
	//uri: api/hello/class?id=erpBI
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/class")
	public Response sayHelloToClass(@QueryParam(value="id")String
			className)
	{
		return Response
				.status(200)
				.entity("hello "+className)
				.build();
	}
}
