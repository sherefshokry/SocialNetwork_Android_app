package com.FCI.SWE.Links;

import org.json.JSONException;
import org.json.JSONObject;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;

import android.widget.Toast;

// addFriend
public class AcceptFriend implements ControllerOptions
{
	@Override
	public String[] connect(String... params) {
		String all[] = new String[2];
		all[0] = "http://fci-codezilla256.appspot.com/rest/AddFriend";
		all[1] =  "Esource=" + params[0] + "&Edestination=" + params[1];

		return all;
	}

	@Override
	public void connReturn(String result) throws JSONException {
		
		JSONObject object = new JSONObject(result);

		if ((!object.has("Status") || object.getString("Status")
						.equals("Failed"))) {
			Toast.makeText(Application.getAppContext(),
					"Error Occured", Toast.LENGTH_LONG).show();
			return;
		}
		
		RecFriendReqs newReqs = new RecFriendReqs();
		UserController controller = Application.getUserController();
		String email = controller.getCurrentActiveUser().getEmail();

		// Get Received Friend Requests
		controller.execute(newReqs, email);	
	}
	
}
