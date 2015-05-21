package com.FCI.SWE.Links;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.SocialNetwork.sendGroupMsgActivity;
import com.FCI.SWE.observerDP.GroupChat;

public class SendGroupMsg implements ControllerOptions {

	@Override
	public String[] connect(String... params) {
		String all[] = new String[2];
		all[0] = "http://fci-codezilla256.appspot.com/rest/SendGroupMessage";
		all[1] = "Esource=" + params[0] + "&ID=" + params[1] + "&Message="
				+ params[2];

		return all;
	}

	@Override
	public void connReturn(String result) throws JSONException {

		JSONArray object = new JSONArray(result);
		
		String msg = object.get(0).toString();
		String id = object.get(1).toString();
		ArrayList<String> emails = new ArrayList<String>();

		for (int i = 2; i < object.length(); i++)
			emails.add(object.get(i).toString());

		
		GroupChat gc=new GroupChat();
		gc.setUsers(emails);
		

		Intent frReqIntent = new Intent(Application.getAppContext(),
				sendGroupMsgActivity.class);
		frReqIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

		frReqIntent.putExtra("message", msg);
		frReqIntent.putExtra("id", id);
		Application.getAppContext().startActivity(frReqIntent);

		
		
		
		
	}
	

}
