package com.srinivas.smartshop;


import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("items")
public class APIResource {

	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getIt() {
		JsonObject json = new JsonObject();
		json.addProperty("name", "srinivas");
		json.addProperty("company", "SAP");
		return (json.toString());
	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String putItemId(String id) {

		ArrayList<String> idList = PersistanceClass.getIdList();
		
		ArrayList<String> idListCopy =  new ArrayList<>();
		
		idListCopy.addAll(idList);
		
		for(String idString : idList){
			if(idString.equalsIgnoreCase(id)){
				idListCopy.remove(idList.indexOf(idString));
				PersistanceClass.setIdList(idListCopy);
				return "The item : "+id+" has been removed.";
			}
		}
		
		idList.add(id);
		
		return "Item added to basket: " + id;
	}

	@Path("/all")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllItems() {

		if (PersistanceClass.getIdList() != null) {

			JsonArray jArray = new JsonArray();
			for (String id : PersistanceClass.getIdList()) {
				JsonObject json = new JsonObject();
				json.addProperty("id", id);
				jArray.add(json);
			}
			return (jArray.toString());
		}

		else {
			return "no id is stored in the system";
		}
	}
}
