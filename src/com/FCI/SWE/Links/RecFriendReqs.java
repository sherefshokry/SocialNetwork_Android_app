package com.FCI.SWE.Links;

import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.widget.Toast;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.SocialNetwork.FriendRequestsActivity;


// searchFriends
public class RecFriendReqs implements ControllerOptions
{
	@Override
	public String[] connect(String ... params) {
		String all[] = new String[2];
		all[0] = "http://fci-codezilla256.appspot.com/rest/SearchFriendRequest";
		all[1] = "Esource=" + params[0];

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

		Iterator<String> iter = object.keys();
		String unames = "", emails = "";
		while (iter.hasNext()) {
			String key = iter.next();
			try {
				unames += key + "#";
				emails += object.get(key) + "#";
			} catch (JSONException e) {
				// Something went wrong!
			}
		}

		Intent frReqIntent = new Intent(
				Application.getAppContext(),
				FriendRequestsActivity.class);
		frReqIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

		frReqIntent.putExtra("unames", unames);
		frReqIntent.putExtra("emails", emails);

		Application.getAppContext().startActivity(frReqIntent);
	}

}
