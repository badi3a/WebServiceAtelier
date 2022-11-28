package ressources;

import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.MediaType;
import entities.Internship;
@Path("/internship")
public class InternshipApi {
	static List<Internship> list = new ArrayList<Internship>();
	
	public InternshipApi() {
		// TODO Auto-generated constructor stub
		this.list.add(new Internship("ref1", "backend developer", "Focus",6));
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getAllInternship() {
		return Response.status(200).entity(list).build();
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("add")
	public Response addInternship(Internship internship) {
		this.list.add(internship);
		return Response
				.status(201)
				.entity("Internship added successful")
				.build();
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("update")
	public Response updateInternship(Internship i) {
		int index = getIndexById(i.getId());

		if (index != -1) {
			list.set(index, i);
			return Response
			.status(200)
			.entity("update successful")
			.build();
		}else
		return Response
				.status(200)
				.entity("update unsuccessful")
				.build();
	}
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Path("delete/{id}")
	public Response deleteInternship(@PathParam(value="id")String id) {
		int index = getIndexById(id);
		if (index != -1) {
			this.list.remove(index);
			return Response
			.status(200)
			.entity("true")
			.build();
		} else
			return Response
					.status(200)
					.entity("false")
					.build();
	}

	public int getIndexById(String id) {
		for (Internship i : this.list) {
			if (i.getId().equals(id))
				return this.list.indexOf(i);
		}
		return -1;
	}



}
