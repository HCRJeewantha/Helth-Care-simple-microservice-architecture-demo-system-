package com.authnew.Authnew;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.StringTokenizer;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

@Provider
public class SecurityFilter implements ContainerRequestFilter {
	
	private static final String AUTHORIZATION_HEADER_KEY = "Authorization"; 
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic "; 
	private static final String SECURED_URL_PREFIX = "secured"; 
	
	Connection con = null;
	
	public SecurityFilter()
	{		 
		con = com.authnew.Authnew.dbconnector.connecter();
	} 

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		if (requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)) {
			List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
			System.out.println(authHeader);
			if (authHeader != null && authHeader.size() > 0) {
				
				String authToken = authHeader.get(0);
				authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
				String decodedString = Base64.decodeAsString(authToken);
				StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
				
				String username = tokenizer.nextToken();
				String password = tokenizer.nextToken();
				
				
			   	 try 
			   	   {
			   		 String sql = "select*from doctor where Email= '"+username+"' and password= '"+password+"'";	 
						  Statement st = con.createStatement();
						  ResultSet rs = st.executeQuery(sql);
						if(rs.next()) {
							 System.out.println("login success");
							 return;
						}else {
							Response unauthorizedStatus = Response
						            .status(Response.Status.UNAUTHORIZED)
						            .entity("User cannot access the resource.")
						            .build();

							requestContext.abortWith(unauthorizedStatus);
						}	
					 } 
			   	 catch (Exception e) 
			   	  {	
					   System.out.println(e);
			   	  }                                                                              
				
			}else {
				Response unauthorizedStatus = Response
			            .status(Response.Status.UNAUTHORIZED)
			            .entity("User cannot access the resource.")
			            .build();

				requestContext.abortWith(unauthorizedStatus);
			}
			

		}
		
	}

}
