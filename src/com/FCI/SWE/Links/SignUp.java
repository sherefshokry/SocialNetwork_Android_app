package com.FCI.SWE.Links;

import org.json.JSONException;
import org.json.JSONObject;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.SocialNetwork.HomeActivity;

import android.content.Intent;
import android.widget.Toast;


public class SignUp implements ControllerOptions {

	@Override
	public String[] connect(String ... params) {
		String all[] = new String[2];
		all[0] = "http://fci-codezilla256.appspot.com/rest/RegistrationService";
		all[1] = "uname=" + params[0] + "&email=" + params[1]
				+ "&password=" + params[2];

		return all;
	}

	@Override
	public void connReturn(String result) throws JSONException {

		JSONObject object = new JSONObject(result);

		if ((!object.has("Status") || object.getString("Status")
						.equals("Failed"))) {
			Toast.makeText(Application.getAppContext(),
					"Invalid  Registeration", Toast.LENGTH_LONG).show();
			return;
		}
		
		Intent homeIntent = new Intent(Application.getAppContext(),
				HomeActivity.class);
		homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		homeIntent.putExtra("status", "Registered successfully");
		Application.getAppContext().startActivity(homeIntent);
	}

}
