package com.FCI.SWE.Links;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.widget.Toast;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.SocialNetwork.GetGroupMsgsActivity;
import com.FCI.SWE.SocialNetwork.HomeActivity;
import com.FCI.SWE.SocialNetwork.SendSingleMsgActivity;

public class ReadSingleMsg implements ControllerOptions {

	@Override
	public String[] connect(String... params) {
		String all[] = new String[2];
		all[0] = "http://fci-codezilla256.appspot.com/rest/ReadSingleMessage";
		all[1] = "Esource=" + params[0] + "&Edestination=" + params[1];

		return all;
	}

	@Override
	public void connReturn(String result) throws JSONException {

		
		JSONObject object = new JSONObject(result);
	
		/*
		if ((!object.has("status") || object.getString("status").equals(
				"failed"))) {
			Toast.makeText(Application.getAppContext(), "FAILED",
					Toast.LENGTH_LONG).show();
			return;
		}
*/
		String message = "";
		String Edest="";
		message = object.get("messages").toString();
		Edest=object.get("Edestination").toString() ;
	
		
		
		
	Intent frReqIntent = new Intent(Application.getAppContext(),
		SendSingleMsgActivity.class);
		frReqIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

		frReqIntent.putExtra("message", message);
		frReqIntent.putExtra("Edestination", Edest);
		Application.getAppContext().startActivity(frReqIntent);

	}


}
