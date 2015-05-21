package com.FCI.SWE.Links;

import org.json.JSONException;
import org.json.JSONObject;

import com.FCI.SWE.Controllers.Application;

import android.widget.Toast;

// sendRequest
public class SendFriendReq implements ControllerOptions
{
	@Override
	public String[] connect(String... params) {
		String all[] = new String[2];
		all[0] = "http://fci-codezilla256.appspot.com/rest/FriendRequest";
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
	}
}