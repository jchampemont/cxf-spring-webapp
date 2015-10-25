package com.binarygenetics.samples.cxfspringwebapp.jaxrs;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.springframework.stereotype.Component;

import com.binarygenetics.samples.cxfspringwebapp.api.SampleException;

/**
 * JAX-RS exception mapper for sample exceptions
 */
@Component
public class SampleExceptionMapper implements ExceptionMapper<SampleException> {

	@Override
	public Response toResponse(SampleException e) {
		return Response
			.status(Response.Status.SERVICE_UNAVAILABLE)
			.type("application/json")
			.entity(new SampleError(e.getMessage()))
			.build()
		;
	}

	/**
	 * Sample error
	 */
	private static class SampleError {
		@SuppressWarnings("unused")
		private final String message;

		/**
		 * Class constructor
		 * @param message Message
		 */
		public SampleError(String message) {
			this.message = message;
		}

	}

}
