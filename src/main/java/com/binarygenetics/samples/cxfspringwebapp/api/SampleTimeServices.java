package com.binarygenetics.samples.cxfspringwebapp.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Sample time services
 */
@Path("/sample/time")
public interface SampleTimeServices {

	@GET
	@Produces("application/json")
	SampleTime getTime() throws SampleException;

	@GET
	@Path("/error")
	@Produces("application/json")
	SampleTime getError() throws SampleException;

}
