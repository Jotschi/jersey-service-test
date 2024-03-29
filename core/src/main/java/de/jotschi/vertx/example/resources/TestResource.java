package de.jotschi.vertx.example.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
public class TestResource {

	@GET
	@Path("id")
	public String getId() {
		return getClass().getCanonicalName();
	}
}
