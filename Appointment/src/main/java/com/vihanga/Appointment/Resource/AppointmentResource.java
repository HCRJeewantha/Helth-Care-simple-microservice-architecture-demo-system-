package com.vihanga.Appointment.Resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.vihanga.Appointment.Model.Appointment;
import com.vihanga.Appointment.Service.AppointmentService;



@Path("/appointment")
public class AppointmentResource {
	
	AppointmentService app = new AppointmentService();
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Appointment> getAppointments()
	{
		System.out.println("Display Appolintment List Successfully");
		return app.getAppointments();
	}
	
	
	
	@GET
	@Path("/{aid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Appointment getAppointment(@PathParam("aid") int aid)
	{
		System.out.println("Display Selected Appointment Successfully");
		return app.getAppointment(aid);
	
	}
	
	@GET
	@Path("patient/{patientid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Appointment getPatientID(@PathParam("patientid") int patientid)
	{
		System.out.println("Display Patient Appoinment Successfully");
		return app.getPatientID(patientid);
	
	}
	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Appointment createAppointment(Appointment a1)
	{
		System.out.println("Insert Your Appointment Successfully");
		app.createAppointment(a1);
		
		return a1;
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Appointment updateAppointment(Appointment a1)
	{
		
		if(app.getAppointment(a1.getAID()).getAID()==0) {
			System.out.println("Insert Your Appointment Successfully");
			app.createAppointment(a1);
			
		}
		else
		{
			System.out.println("Update Your Appointment Successfully");
			app.updateAppointment(a1);
			
		}
		
		return a1;
	}
	
	
	@DELETE
	@Path("/{aid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Appointment deleteAppointment(@PathParam("aid") int aid)
	{
		Appointment a = app.getAppointment(aid);
		
		if(a.getAID()!=0)
			System.out.println("Delete Your Appointment Successfully");
			app.deleteAppointment(aid);
		return null;
	}
	
}
