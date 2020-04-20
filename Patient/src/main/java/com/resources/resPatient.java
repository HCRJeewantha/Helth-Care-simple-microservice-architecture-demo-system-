package com.resources;

import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

import com.controller.*;
import com.java.*;

import DataTypeObjects.appointmentDTO;
import DataTypeObjects.docHosDTO;
import DataTypeObjects.paymentDTO;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/Patient")
public class resPatient {
	
cntPatient app = new cntPatient();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("patient")
	public List<Patient> getPatients()
	{
		System.out.println("getPatient called...");
		return app.getPatients();
	}
	
	
	
	@GET
	@Path("patient/{patientID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Patient getPatient(@PathParam("patientID") int patientID)
	{
		return app.getPatient(patientID);
	
	}
	
	@POST
	@Path("/patient")
	@Consumes(MediaType.APPLICATION_JSON)
	public Patient createPatient(Patient p1)
	{
		System.out.println(p1);
		app.create(p1);
		
		return p1;
	}
	
	
	@PUT
	@Path("/patient")
	@Consumes(MediaType.APPLICATION_JSON)
	public Patient updatePatient(Patient p1)
	{
		System.out.println(p1);
		if(app.getPatient(p1.getPID()).getPID()==0) {
			app.create(p1);
			
		}
		else
		{
			app.update(p1);
			
		}
		
		return p1;
	}
	
	
	@DELETE
	@Path("patient/{uid}")
	public Patient deletePatient(@PathParam("uid") int uid)
	{
		Patient p = app.getPatient(uid);
		
		if(p.getPID()!=0)
			app.delete(uid);
		return null;
	}
	
	@GET
	@Path("getDoctorsHospital/{hid}")
	@Produces(MediaType.APPLICATION_JSON)
	public final Response getDoc(@PathParam("hid") String hid) {
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/doctor/webapi/myresource").path("doctor").path(hid);
		 
		System.out.println("callling");
		
		try {
			Response response = webTarget.request().get();
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GET
	@Path("getHospitalDoctor/{did}")
	@Produces(MediaType.APPLICATION_JSON)
	public final Response getHos(@PathParam("did") String did) {
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/doctor/webapi/myresource").path("hospital").path(did);
		 
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
		WebTarget webTarget = client.target("http://localhost:8080/Payment/webapi/payment");

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
		WebTarget webTarget = client.target("http://localhost:8080/Payment/webapi/payment").path("appointment").path(aid);
		 
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
		WebTarget webTarget = client.target("http://localhost:8080/Appointment/webapi/appointment");

		System.out.println("callling");
		
		try {
			Response response = webTarget.request().post(Entity.json(dto));
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GET
	@Path("getPatientApp/{aid}")
	@Produces(MediaType.APPLICATION_JSON)
	public final Response getPatientAppointment(@PathParam("aid") String aid) {
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/Appointment/webapi/appointment").path("patient").path(aid);
		 
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
		WebTarget webTarget = client.target("http://localhost:8080/Appointment/webapi/appointment").path(aid);
		 
		System.out.println("callling");
		
		try {
			Invocation.Builder invocationBuilder =  webTarget.request();
			Response response = invocationBuilder.delete();
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
		WebTarget webTarget = client.target("http://localhost:8080/Hospital/webapi").path("sessions").path(did).path(did1);
		 
		System.out.println("callling");
		
		try {
			Response response = webTarget.request().get();
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}

}
