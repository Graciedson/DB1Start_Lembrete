package br.com.db1.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("lembrete")
public class LembreteRest {


	@GET
	@Path("Ol�")
	public Response helloWorld(){
		System.out.println("Novo acesso");
		
		return Response.status(200).entity("Ol� Mundo").build();
		
		
		
	}
}