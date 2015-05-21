package com.FCI.SWE.SocialNetwork;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;
import com.FCI.SWE.Links.CreateGroupChat;
import com.FCI.SWE.Links.GetMyGroupMsgs;
import com.FCI.SWE.Links.GetMySingleMsgs;
import com.FCI.SWE.Links.RecFriendReqs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends Activity {

	Button  friendNotification;
	Button  messageNotification;
	Button  notifications;
	Button signOut;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		Bundle extras = getIntent().getExtras();

	
		// String status = extras.getString("status");
		String name = "";

		if (extras.containsKey("name")) {
			name = extras.getString("name");
			// Toast.makeText(this, "Welcome "+ name,
			// Toast.LENGTH_SHORT).show();
		}

		Toast.makeText(this, "Welcome " + name, Toast.LENGTH_SHORT).show();
	
		

		messageNotification = (Button) findViewById(R.id.messagenotification);

		messageNotification.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {


				Intent Main = new Intent(getApplicationContext(),
						main_message_activity.class);
				startActivity(Main);

			}
		});
		

		friendNotification = (Button) findViewById(R.id.friendnotification);

		friendNotification.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

		
				Intent Main = new Intent(getApplicationContext(),
						main_friend_activity.class);
				startActivity(Main);

			}
		});
		
		

		notifications = (Button) findViewById(R.id.notifications);

		notifications.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {


				Intent Main = new Intent(getApplicationContext(),
						MainActivity.class);
				startActivity(Main);

			}
		});
		
			
		

		signOut = (Button) findViewById(R.id.signOutActivity);

		signOut.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				UserController controller = Application.getUserController();
				controller.signOut();

				Intent Main = new Intent(getApplicationContext(),
						MainActivity.class);
				startActivity(Main);

			}
		});

	}
}