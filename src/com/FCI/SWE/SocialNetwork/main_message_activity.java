package com.FCI.SWE.SocialNetwork;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;
import com.FCI.SWE.Links.CreateGroupChat;
import com.FCI.SWE.Links.GetMyGroupMsgs;
import com.FCI.SWE.Links.GetMySingleMsgs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class main_message_activity extends Activity {

		Button createChatGp;
		Button GetGroupMsgsList;
		Button GetSingleMsgsList;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
	

			super.onCreate(savedInstanceState);
			setContentView(R.layout.main_message);

	//		Bundle extras = getIntent().getExtras();
			

			createChatGp = (Button) findViewById(R.id.createChatGpButton);

			createChatGp.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {

					UserController controller = Application.getUserController();
					CreateGroupChat grChat = new CreateGroupChat();
					controller.execute(grChat, controller.getCurrentActiveUser().getEmail(),  "shokryy");
				}
			});
				
			GetGroupMsgsList= (Button) findViewById(R.id.Gmsg);
			GetGroupMsgsList.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				UserController controller = Application.getUserController();
				GetMyGroupMsgs grMsg= new 	GetMyGroupMsgs();
				controller.execute(grMsg, controller.getCurrentActiveUser().getEmail());
			}
		});
			GetSingleMsgsList =(Button) findViewById(R.id.Smsg);
			GetSingleMsgsList.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				UserController controller = Application.getUserController();
				GetMySingleMsgs sMsg= new 	GetMySingleMsgs();
				controller.execute(sMsg, controller.getCurrentActiveUser().getEmail());
			}
		});
	}
			
		}

