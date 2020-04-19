package com.gatewaynew.gatewaynew;

import javax.ws.rs.DELETE;
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
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import DataTypeObjects.doctorDTO;
import DataTypeObjects.paymentDTO;

@Path("doctorGateway")
public class doctorGatewayResource {

	@POST
	@Path("addDoctor")
	@Produces(MediaType.APPLICATION_JSON)
	public final Response postDoc(doctorDTO dto) {
		
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
	
	@GET
	@Path("viewPatientReports/{sessionID}")
	@Produces(MediaType.APPLICATION_JSON)
	public final Response viewPayment(@PathParam("sessionID") String sessionID) {
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/doctor/webapi/myresource").path("viewPatientReports").path(sessionID);
		 
		System.out.println("callling");
		
		try {
			Response response = webTarget.request().get();
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GET
	@Path("viewDoctorDetails/{DID}")
	@Produces(MediaType.APPLICATION_JSON)
	public final Response viewDoctror(@PathParam("DID") String DID) {
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/doctor/webapi/myresource").path("getDoctor").path(DID);
		 
		System.out.println("callling");
		
		try {
			Response response = webTarget.request().get();
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@PUT
	@Path("updateDoctor")
	@Produces(MediaType.APPLICATION_JSON)
	public final Response updateDoc(doctorDTO dto) {
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/doctor/webapi/myresource/doctor");

		System.out.println("callling");
		
		try {
			Response response = webTarget.request().post(Entity.json(dto));
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@DELETE
	@Path("deleteDoctor/{did}")
	@Produces(MediaType.APPLICATION_JSON)
	public final Response deletePatientAPP(@PathParam("did") String did) {
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/doctor/webapi/myresource/doctor").path(did);
		 
		System.out.println("callling");
		
		try {
			Invocation.Builder invocationBuilder =  webTarget.request();
			Response response = invocationBuilder.delete();
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	

	
}
