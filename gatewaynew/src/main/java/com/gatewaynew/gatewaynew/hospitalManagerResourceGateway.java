package com.gatewaynew.gatewaynew;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import DataTypeObjects.doctorDTO;
import DataTypeObjects.hospitalDTO;
import DataTypeObjects.reportDTO;

@Path("hospitalManagerGateway")
public class hospitalManagerResourceGateway {

	@GET
	@Path("getHospital/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public final Response getReport(@PathParam("id") String id) {
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/Hospital/webapi/hospitals").path(id);
		 
		System.out.println("callling");
		
		try {
			Response response = webTarget.request().get();
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@POST
	@Path("createHospital")
	@Produces(MediaType.APPLICATION_JSON)
	public final Response createHos(hospitalDTO dto) {
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/Hospital/webapi/hospitals");

		System.out.println("callling");
		
		try {
			Response response = webTarget.request().post(Entity.json(dto));
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@PUT
	@Path("updateHospital")
	@Produces(MediaType.APPLICATION_JSON)
	public final Response updateHos(hospitalDTO dto) {
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/Hospital/webapi/hospitals");

		System.out.println("callling");
		
		try {
			Response response = webTarget.request().post(Entity.json(dto));
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
}
