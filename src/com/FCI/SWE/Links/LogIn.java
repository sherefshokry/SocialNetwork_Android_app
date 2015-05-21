package com.FCI.SWE.Links;

import org.json.JSONException;
import org.json.JSONObject;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;
import com.FCI.SWE.Models.UserEntity;
import com.FCI.SWE.SocialNetwork.HomeActivity;

import android.content.Intent;
import android.widget.Toast;

public class LogIn implements ControllerOptions {

	@Override
	public String[] connect(String... params) {
		String all[] = new String[2];
		all[0] = "http://fci-codezilla256.appspot.com/rest/LoginService";
		all[1] = "email=" + params[0] + "&password=" + params[1];

		return all;
	}

	@Override
	public void connReturn(String result) throws JSONException {

		JSONObject object = new JSONObject(result);

		if ((!object.has("Status") || object.getString("Status")
						.equals("Failed"))) {
			Toast.makeText(Application.getAppContext(),
					"Invalid  Log In", Toast.LENGTH_LONG).show();
			return;
		}

		UserController.setCurrentActiveUser( UserEntity.createLoginUser(result) );

		Intent homeIntent = new Intent(Application.getAppContext(),
				HomeActivity.class);

		homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		/* here you should initialize user entity */
		homeIntent.putExtra("status", object.getString("Status"));
		homeIntent.putExtra("name", object.getString("name"));

		Application.getAppContext().startActivity(homeIntent);
		
	}

}
