package com.vihanga.Hospital.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.vihanga.Hospital.controller.cntHospital;
import com.vihanga.Hospital.model.Hospital;


@Path("/hospitals")
public class resHospital {
	
cntHospital db = new cntHospital();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Hospital> getHospitals()
	{
		System.out.println("getHospital called...");
		return db.getHospitals();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Hospital getHospital(@PathParam("id") int id) {
		
		return db.getHospital(id);
	}
	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Hospital createHospital(Hospital h1) {
		
		System.out.println(h1);
		db.create(h1);
		return h1;
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Hospital updateHospital(Hospital h1) {
		
		System.out.println(h1);
		if(db.getHospital(h1.getHID()).getHID()==0) {
			db.create(h1);
		}
		else {
		db.update(h1);
		}
		return h1;
	}
	
	
	@DELETE
	@Path("/{id}")
	public Hospital deleteHospital(@PathParam("id") int id) {
		
		Hospital h = db.getHospital(id);
		if(h.getHID()!=0)
		db.delete(id);
		
		return null;
	}

}
