package com.paf.projects.Payment.Resources;

import java.util.*;
import javax.ws.rs.*;
import com.paf.projects.Payment.controller.*;
import com.paf.projects.Payment.model.Payment;

import javax.ws.rs.core.MediaType;

@Path("/payment")
public class resPayment {
	
	PaymentController app = new PaymentController();
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Payment> getPayments()
	{
		System.out.println("getPayment called...");
		return app.getPayment();
	}
	
	
	
	@GET
	@Path("/{payid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Payment getPayment(@PathParam("payid") int payid)
	{
		return app.getPayment(payid);
	
	}
	
	@GET
	@Path("appointment/{aid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Payment getPayment1(@PathParam("aid") int aid)
	{
		return app.getPaymentA(aid);
	
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Payment createPayment(Payment p1)
	{
		System.out.println(p1);
		app.create(p1);
		
		return p1;
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Payment updatePayment(Payment p1)
	{
		System.out.println(p1);
		if(app.getPayment(p1.getPayID()).getPayID()==0) {
			app.create(p1);
			
		}
		else
		{
			app.update(p1);
			
		}
		
		return p1;
	}
	
	
	@DELETE
	@Path("/{payid}")
	public Payment deletePayment(@PathParam("payid") int payid)
	{
		Payment p = app.getPayment(payid);
		
		if(p.getPayID()!=0)
			app.deletePayment(payid);
		return null;
	}
	
	@DELETE
	@Path("/{aid}")
	public Payment deletePayment1(@PathParam("aid") int aid)
	{
		Payment p = app.getPayment(aid);
		
		if(p.getPayID()!=0)
			app.deletePayment1(aid);
		return null;
	}
	
	
	


}

