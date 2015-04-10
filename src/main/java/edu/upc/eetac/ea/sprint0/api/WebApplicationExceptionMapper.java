package edu.upc.eetac.ea.sprint0.api;

import edu.upc.eetac.ea.sprint0.api.model.*;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class WebApplicationExceptionMapper implements
		ExceptionMapper<WebApplicationException> {
	@Override
	public Response toResponse(WebApplicationException exception) {
		Sprint0Error error = new Sprint0Error(exception.getResponse()
				.getStatus(), exception.getMessage());
		return Response.status(error.getStatus()).entity(error)
				.type(MediaType.SPRINT0_API_ERROR).build();
	}
}