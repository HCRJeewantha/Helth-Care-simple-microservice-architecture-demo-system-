package com.resources;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import com.controller.cntDoctor;
import com.java.doctor;


@Path("/createDoctor")
public class resDoctor {

	cntDoctor repo = new cntDoctor();

	@POST
	@Path("/doctor")
	@Consumes(MediaType.APPLICATION_JSON)
	public doctor create(doctor d1)
	{
		System.out.println(d1);
		repo.create(d1);
		
		return d1;
	}
	
}
