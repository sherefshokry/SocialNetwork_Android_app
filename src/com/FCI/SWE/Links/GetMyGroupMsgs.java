package com.FCI.SWE.Links;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.widget.Toast;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.SocialNetwork.FriendRequestsActivity;
import com.FCI.SWE.SocialNetwork.GetGroupMsgsActivity;

public class GetMyGroupMsgs implements ControllerOptions
{
	
	@Override
	public String[] connect(String... params) {
		String all[] = new String[2];
		all[0] = "http://fci-codezilla256.appspot.com/rest/GetMyGroupMsgs";
		all[1] = "Esource=" + params[0];

		return all;
	}


		
		@Override
		public void connReturn(String result) throws JSONException {
			
			JSONArray object = new JSONArray(result);
			Toast.makeText(Application.getAppContext(),
					result, Toast.LENGTH_LONG).show();
			
			String ID = "", gpName = "";
	for(int i=1;i<object.length();i++)
	{
		String Item[] = ((String) object.get(i)).split("#");

		ID +=Item[0]+"#";
		gpName += Item[1] + "#";
	}


	Intent frReqIntent = new Intent(
					Application.getAppContext(),
					GetGroupMsgsActivity.class);
			frReqIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

	frReqIntent.putExtra("IDs",ID);
	frReqIntent.putExtra("gpName", gpName);

			Application.getAppContext().startActivity(frReqIntent);

		
	}

}
