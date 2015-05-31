package com.decote.skabiat.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.decote.skabiat.model.Bar;
import com.decote.skabiat.services.BarFinderService;

/**
 * bar resource (exposed at "bar" path)
 */
@Path("api/bar")
public class BarResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path ("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Bar getIt(@PathParam ("id") String id) {
    	Bar wantedBar = BarFinderService.getInstance().getBar(id);
        return wantedBar;
    }
    
    @PUT
    @Path ("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveBar(Bar bar){
    	BarFinderService.getInstance().addBar(bar);
    	return Response.status(200).build();
    			
    }
}
