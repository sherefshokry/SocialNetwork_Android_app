package com.FCI.SWE.Services;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import com.FCI.SWE.ServicesModels.FriendEntity;
import com.FCI.SWE.ServicesModels.UserEntity;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class FriendsServices {

	@GET
	@Path("/AddFriend/{Esource}/{Edestination}")
	public String AddFriend(@PathParam("Esource") String Esource,
			@PathParam("Edestination") String Edestination) {

		JSONObject object = new JSONObject();
		FriendEntity user = new FriendEntity(Esource, Edestination);
		Boolean state = user.AddFriendService(Esource,Edestination);
		if (state == false) {
			object.put("Status", "Failed");
		} else {
			object.put("Status", "Ok");
		}
		return object.toString();
	}	
	
	@GET
	@Path("/FriendRequest/{Esource}/{Edestination}")
	public String FriendRequest(@PathParam("Esource") String Esource,
			@PathParam("Edestination") String Edestination) {
//		public String FriendRequest(String Esource, String Edestination) {
		FriendEntity user = new FriendEntity (Esource, Edestination);
		user.SaveFriendRequest();
		JSONObject object = new JSONObject();
		object.put("Status", "OK");
		return object.toString();
	}
	
}