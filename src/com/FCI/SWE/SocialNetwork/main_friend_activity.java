package com.FCI.SWE.SocialNetwork;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;
import com.FCI.SWE.Links.RecFriendReqs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class main_friend_activity extends Activity{

	Button FriendRequestActivity;
	Button addFriend;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
	

			super.onCreate(savedInstanceState);
			setContentView(R.layout.main_friend);

			//Bundle extras = getIntent().getExtras();
			FriendRequestActivity = (Button) findViewById(R.id.sendRequestButton);
			FriendRequestActivity.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {

					Intent FriendReqIntent = new Intent(getApplicationContext(),
							SendRequestActivity.class);
					startActivity(FriendReqIntent);
				}
			});

			addFriend = (Button) findViewById(R.id.addFriendButton);

			addFriend.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {

					UserController controller = Application.getUserController();
					RecFriendReqs frReqs = new RecFriendReqs();
					controller.execute(frReqs, controller.getCurrentActiveUser()
							.getEmail());
				}
			});
			
		}
}
