package com.FCI.SWE.Links;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.SocialNetwork.FriendRequestsActivity;
import com.FCI.SWE.SocialNetwork.GetSingleMsgsActivity;
import com.FCI.SWE.SocialNetwork.HomeActivity;

public class GetMySingleMsgs implements ControllerOptions
{	
	@Override
	public String[] connect(String... params) {
		String all[] = new String[2];
		all[0] = "http://fci-codezilla256.appspot.com/rest/GetMySingleMsgs";
		all[1] = "Esource=" + params[0];

		return all;
	}

	@Override
	public void connReturn(String result) throws JSONException {
		
		JSONArray object = new JSONArray(result);
 String emails = "";
for(int i=1;i<object.length();i++)
{
  emails+=((String) object.get(i))+"#";
}

Intent frReqIntent = new Intent(
				Application.getAppContext(),
				GetSingleMsgsActivity.class);
		frReqIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

frReqIntent.putExtra("Emails",emails);

		Application.getAppContext().startActivity(frReqIntent);

    }
}
