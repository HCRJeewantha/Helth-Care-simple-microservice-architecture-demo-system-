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

import com.vihanga.Hospital.controller.cntSession;
import com.vihanga.Hospital.model.Session;


@Path("/sessions")
public class resSession {
	
cntSession db = new cntSession();
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Session> getSessions(){
		
		return db.getSessions();
	}
	
	@GET
	@Path("/{did}/{did1}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Session> getSpecificSessions(@PathParam("did") int did,@PathParam("did1") int did1){
		
		return db.getSpecificSessions(did,did1);
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Session getDocSession(@PathParam("id") int id) {
		
		return db.getSession(id);
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Session createSession(Session s1) {
		
		System.out.println(s1);
		db.create(s1);
		return s1;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Session updateSession(Session s1) {
		
		System.out.println(s1);
		if(db.getSession(s1.getSID()).getSID()==0) {
			db.create(s1);
		}
		else {
		db.update(s1);
		}
		return s1;
	}
	
	@DELETE
	@Path("/{id}")
	public Session deleteSession(@PathParam("id") int id) {
		
		Session h = db.getSession(id);
		if(h.getSID()!=0)
		db.delete(id);
		
		return null;
	}

}
