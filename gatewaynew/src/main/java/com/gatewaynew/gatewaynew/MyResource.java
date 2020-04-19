package com.gatewaynew.gatewaynew;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import DataTypeObjects.DTO;



@Path("myresource")
public class MyResource {

	@POST
	@Path("add")
	@Produces(MediaType.APPLICATION_JSON)
	public final Response postDoc(DTO dto) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/doctor/webapi/myresource").path("doctor");

		System.out.println("callling");
		
		try {
			Response response = webTarget.request().post(Entity.json(dto));
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
}

