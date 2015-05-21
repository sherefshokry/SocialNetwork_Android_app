package com.FCI.SWE.Links;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.widget.Toast;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.SocialNetwork.HomeActivity;

public class AddMemberInGroupChat implements ControllerOptions {
	@Override
	public String[] connect(String... params) {
		String all[] = new String[2];
		all[0] = "http://fci-codezilla256.appspot.com/rest/AddMemberInChatGroup";
		all[1] = "memEmail=" + params[0] + "&ChatID=" + params[1]
				+ "&groupName=" + params[2];

		return all;
	}

	@Override
	public void connReturn(String result) throws JSONException {
		JSONObject object = new JSONObject(result);

		if ((!object.has("status") || object.getString("status").equals(
				"failed"))) {
			Toast.makeText(Application.getAppContext(), "FAILED",
					Toast.LENGTH_LONG).show();
			return;
		}

		Intent homeIntent = new Intent(Application.getAppContext(),
				HomeActivity.class);

		homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

		Application.getAppContext().startActivity(homeIntent);

	}

}
