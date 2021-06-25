package rest.demo.module.application;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import rest.demo.module.ws.validation.AuthenticationChecker;

/**
 * @author lehel
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/greetings",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Greetings.Rest",
		"oauth2.scopechecker.type=none",
		"auth.verifier.guest.allowed=true",
		"liferay.access.control.disable=true"
	},
	service = Application.class
)
public class RestDemoModuleApplication extends Application {

	@Reference
	private AuthenticationChecker authenticationChecker;
	
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response working(@HeaderParam(HttpHeaders.AUTHORIZATION) String authString) {
		if (authenticationChecker.isAuthenticated(authString)) {
			return Response.status(Status.OK).entity("It works!").build();
		}
		return Response.status(Status.FORBIDDEN).entity("It doesn't work!").build();
	}

	@GET
	@Path("/morning")
	@Produces("text/plain")
	public Response hello(@HeaderParam(HttpHeaders.AUTHORIZATION) String authString) {
		
		if (authenticationChecker.isAuthenticated(authString)) {
			return Response.status(Status.OK).entity("Good morning!").build();
		}
		return Response.status(Status.FORBIDDEN).entity("It doesn't work!").build();
	}

	@GET
	@Path("/morning/{name}")
	@Produces("text/plain")
	public String morning(@HeaderParam(HttpHeaders.AUTHORIZATION) String authString,
		@PathParam("name") String name,
		@QueryParam("drink") String drink) {

		String greeting = "Good Morning " + name;

		if (drink != null) {
			greeting += ". Would you like some " + drink + "?";
		}

		return greeting;
	}

}