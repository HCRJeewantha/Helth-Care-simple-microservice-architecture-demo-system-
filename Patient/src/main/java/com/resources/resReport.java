package com.resources;

import java.util.*;
import javax.ws.rs.*;
import com.controller.*;
import com.java.*;
import javax.ws.rs.core.*;

@Path("/Report")
public class resReport {
	
	cntReport app = new cntReport();
	
	@POST
	@Path("/report")
	@Consumes(MediaType.APPLICATION_JSON)
	public Report createReport(Report r1)
	{
		System.out.println(r1);
		app.create(r1);
		
		return r1;
	}	
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/report/{sessionID}")
	public List<Report> getListReport(@PathParam("sessionID") int sessionID)
	{
		
		return app.getListReport(sessionID);
	}
	
	
	
	
	@PUT
	@Path("/report")
	@Consumes(MediaType.APPLICATION_JSON)
	public Report updateReport(Report r1)
	{
		System.out.println(r1);
		if(app.getReport(r1.getRID()).getRID()==0) {
			app.create(r1);
			
		}
		else
		{
			app.update(r1);
			
		}
		
		return r1;
	}
	
	
	@DELETE
	@Path("report/{rid}")
	public Report deleteReport(@PathParam("rid") int rid)
	{
		Report r = app.getReport(rid);
		
		if(r.getRID()!=0)
			app.delete(rid);
		return null;
	}


}
