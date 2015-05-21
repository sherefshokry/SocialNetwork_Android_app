package com.FCI.SWE.Links;

import org.json.JSONException;
import org.json.JSONObject;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.SocialNetwork.GetSingleMsgsActivity;
import com.FCI.SWE.SocialNetwork.SendSingleMsgActivity;

import android.content.Intent;
import android.widget.Toast;

public class SendSingleMsg implements ControllerOptions {

	@Override
	public String[] connect(String... params) {
		String all[] = new String[2];
		all[0] = "http://fci-codezilla256.appspot.com/rest/SendSingleMessage";
		all[1] = "Esource=" + params[0] + "&Edestination=" + params[1]
				+ "&Message=" + params[2];

		return all;
	}

	@Override
	public void connReturn(String result) throws JSONException {

		JSONObject object = new JSONObject(result);
/*
		if ((!object.has("status") || object.getString("status").equals(
				"Failed"))) {
			Toast.makeText(Application.getAppContext(), "Error Occured",
					Toast.LENGTH_LONG).show();
			return;
		}
*/
		String status = "";
		status = (String) object.get("status");
String Edest=object.get("Edestination").toString();
String msg=object.get("message").toString();
		Intent frReqIntent = new Intent(Application.getAppContext(),
				SendSingleMsgActivity.class);
		frReqIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

		frReqIntent.putExtra("Edestination", Edest);
		frReqIntent.putExtra("message", msg);
		Application.getAppContext().startActivity(frReqIntent);

	}
}
