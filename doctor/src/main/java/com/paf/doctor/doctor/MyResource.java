package com.paf.doctor.doctor;

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
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.controller.cntDoctor;
import com.java.doctor;
import com.java.hospital;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	cntDoctor repo = new cntDoctor();

	@POST
	@Path("doctor")
	public doctor create(doctor d1)
	{
		System.out.println(d1);
		repo.create(d1);
		
		return d1;
	}
	
	@GET
	@Path("doctor/{hid}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<doctor> getAllDocInHospital(@PathParam("hid") int hid)
	{
		return repo.getAllDocInHospital(hid);
	
	}
	
	@GET
	@Path("hospital/{did}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<hospital> getAllHosInDoctor(@PathParam("did") int did)
	{
		return repo.getAllHosInDoctor(did);
	
	}
	
	@GET
	@Path("viewPatientReports/{sessionID}")
	@Produces(MediaType.APPLICATION_JSON)
	public final Response viewPayment(@PathParam("sessionID") String sessionID) {
		
		
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/Patient/webapi/Report").path("report").path(sessionID);
		 
		System.out.println("callling");
		
		try {
			Response response = webTarget.request().get();
			return response;
		} catch (ProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GET
	@Path("getDoctor/{DID}")
	@Produces(MediaType.APPLICATION_JSON)
	public doctor getDoctor(@PathParam("DID") int DID)
	{
		return repo.getDoctor(DID);
	
	}
	
	@PUT
	@Path("doctor")
	@Consumes(MediaType.APPLICATION_JSON)
	public doctor updateDoctor(doctor d1)
	{
		System.out.println(d1);
		if(repo.getDoctor(d1.getDID()).getDID()==0) {
			repo.create(d1);
			
		}
		else
		{
			repo.updateDoctor(d1);
			
		}
		
		return d1;
	}
	
	@DELETE
	@Path("doctor/{did}")
	public doctor deleteDoc(@PathParam("did") int did)
	{
		doctor p = repo.getDoctor(did);
		
		if(p.getDID()!=0)
			repo.deleteDoc(did);
		return null;
	}
	
}
