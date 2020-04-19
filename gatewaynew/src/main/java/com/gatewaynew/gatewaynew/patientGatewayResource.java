package com.gatewaynew.gatewaynew;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

import DataTypeObjects.appointmentDTO;
import DataTypeObjects.paymentDTO;
import DataTypeObjects.reportDTO;

@Path("patientGateway")
public class patientGatewayResource {
	
	@GET
	@Path("getDocsNames/{hid}")
	@Produces(MediaType.APPLICATION_JSON)
	public final Response getDoc(@PathParam("hid") String hid) {
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/Patient/webapi/Patient").path("getDoctorsHospital").path(hid);
		 
		System.out.println("callling");
		
		try {
			Response response = webTarget.request().get();
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GET
	@Path("getHosNames/{did}")
	@Produces(MediaType.APPLICATION_JSON)
	public final Response getHos(@PathParam("did") String did) {
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/Patient/webapi/Patient").path("getHospitalDoctor").path(did);
		 
		System.out.println("callling");
		
		try {
			Response response = webTarget.request().get();
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@POST
	@Path("createPayment")
	@Produces(MediaType.APPLICATION_JSON)
	public final Response addPay(paymentDTO dto) {
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/Patient/webapi/Patient/createPayment");

		System.out.println("callling");
		
		try {
			Response response = webTarget.request().post(Entity.json(dto));
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GET
	@Path("viewPayment/{aid}")
	@Produces(MediaType.APPLICATION_JSON)
	public final Response viewPayment(@PathParam("aid") String aid) {
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/Patient/webapi/Patient").path("viewPayment").path(aid);
		 
		System.out.println("callling");
		
		try {
			Response response = webTarget.request().get();
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@POST
	@Path("makeAppointment")
	@Produces(MediaType.APPLICATION_JSON)
	public final Response addAppointment(appointmentDTO dto) {
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/Patient/webapi/Patient/makeAppointment");

		System.out.println("callling");
		
		try {
			Response response = webTarget.request().post(Entity.json(dto));
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	

	
	@GET
	@Path("getPatientApp/{pid}")
	@Produces(MediaType.APPLICATION_JSON)
	public final Response getPatientAppointment(@PathParam("pid") String pid) {
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/Patient/webapi/Patient").path("getPatientApp").path(pid);
		 
		System.out.println("callling");
		
		try {
			Response response = webTarget.request().get();
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GET
	@Path("getReport/{sid}")
	@Produces(MediaType.APPLICATION_JSON)
	public final Response getReport(@PathParam("sid") String sid) {
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/Patient/webapi/Report/report").path(sid);
		 
		System.out.println("callling");
		
		try {
			Response response = webTarget.request().get();
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@DELETE
	@Path("deletePatientApp/{aid}")
	@Produces(MediaType.APPLICATION_JSON)
	public final Response deletePatientAPP(@PathParam("aid") String aid) {
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/Patient/webapi/Patient/deletePatientApp").path(aid);
		 
		System.out.println("callling");
		
		try {
			Invocation.Builder invocationBuilder =  webTarget.request();
			Response response = invocationBuilder.delete();
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@POST
	@Path("createReport")
	@Produces(MediaType.APPLICATION_JSON)
	public final Response createRepo(reportDTO dto) {
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/Patient/webapi/Report/report");

		System.out.println("callling");
		
		try {
			Response response = webTarget.request().post(Entity.json(dto));
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GET
	@Path("getSession/{did}/{did1}")
	@Produces(MediaType.APPLICATION_JSON)
	public final Response getPatientAppointment(@PathParam("did") String did,@PathParam("did1") String did1) {
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/Patient/webapi/Patient").path("getSession").path(did).path(did1);
		 
		System.out.println("callling");
		
		try {
			Response response = webTarget.request().get();
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}

}
