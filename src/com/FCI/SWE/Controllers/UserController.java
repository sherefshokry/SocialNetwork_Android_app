package com.FCI.SWE.Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.FCI.SWE.Links.ControllerOptions;
import com.FCI.SWE.Models.UserEntity;
import com.FCI.SWE.SocialNetwork.FriendRequestsActivity;
import com.FCI.SWE.SocialNetwork.HomeActivity;

public class UserController {

	private static UserEntity currentActiveUser;
	private static UserController userController;
	private static ControllerOptions option;

	public static UserController getInstance() {
		if (userController == null)
			userController = new UserController();
		return userController;
	}
	
	private UserController() {

	}

	public static UserEntity getCurrentActiveUser() {
		return currentActiveUser;
	}
	public static void setCurrentActiveUser(UserEntity currentActiveUser) {
		UserController.currentActiveUser = currentActiveUser;
	}

	public static ControllerOptions getOption() {
		return option;
	}
	public static void setOption(ControllerOptions option) {
		UserController.option = option;
	}

	
	public void execute(ControllerOptions op, String ... params) {
		option = op;
		String[] URL = option.connect(params);
		new Connection().execute(URL);
	}


	static private class Connection extends AsyncTask<String, String, String> {

		@Override
		protected String doInBackground(String... params) {
			URL url;

			String urlParameters = params[1];
			
			HttpURLConnection connection;
			try {
				url = new URL(params[0]);

				connection = (HttpURLConnection) url.openConnection();
				connection.setDoOutput(true);
				connection.setDoInput(true);
				connection.setInstanceFollowRedirects(false);
				connection.setRequestMethod("POST");
				connection.setConnectTimeout(60000); // 60 Seconds
				connection.setReadTimeout(60000); // 60 Seconds

				connection.setRequestProperty("Content-Type",
						"application/x-www-form-urlencoded;charset=UTF-8");
				OutputStreamWriter writer = new OutputStreamWriter(
						connection.getOutputStream());
				writer.write(urlParameters);
				writer.flush();

				String line, retJson = "";
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(connection.getInputStream()));

				while ((line = reader.readLine()) != null) {
					retJson += line;
				}

				return retJson;

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;

		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub

			super.onPostExecute(result);

			try {
				Toast.makeText(Application.getAppContext(),
						 result, Toast.LENGTH_LONG).show();
				
				UserController.option.connReturn(result);

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}


	public void signOut() {
		currentActiveUser = null;		
	}

}
