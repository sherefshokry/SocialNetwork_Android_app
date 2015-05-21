package com.FCI.SWE.Links;

	import org.json.JSONException;
	import org.json.JSONArray;
	import org.json.JSONException;
	import org.json.JSONObject;

	import com.FCI.SWE.Controllers.Application;
	import com.FCI.SWE.SocialNetwork.GetGroupMsgsActivity;

	import android.content.Intent;
	import android.widget.Toast;
	public class notifyMessage  implements ControllerOptions {

		@Override
		public String[] connect(String... params) {
			String all[] = new String[2];
			all[0] = "http://fci-codezilla256.appspot.com/rest/ReadGroupMessage";
			all[1] = "Edest=" + params[0];

			return all;
		}

		@Override
		public void connReturn(String result) throws JSONException {
/*
			JSONObject object = new JSONObject(result);

			if ((!object.has("status") || object.getString("status").equals(
					"failed"))) {
				Toast.makeText(Application.getAppContext(), "FAILED",
						Toast.LENGTH_LONG).show();
				return;
			}

			String message = "";
			message = object.get("message").toString();

			Intent frReqIntent = new Intent(Application.getAppContext(),
					GetGroupMsgsActivity.class);
			frReqIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

			frReqIntent.putExtra("message", message);

			Application.getAppContext().startActivity(frReqIntent);
*/
		}

	}
