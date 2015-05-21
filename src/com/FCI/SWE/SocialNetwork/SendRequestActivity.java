package com.FCI.SWE.SocialNetwork;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;
import com.FCI.SWE.Links.SendFriendReq;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SendRequestActivity extends Activity implements OnClickListener {

	
	EditText destEmail;
	Button sendRequest;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sendrequest);
		
		destEmail = (EditText) findViewById(R.id.destEmail);
		sendRequest = (Button) findViewById(R.id.sendRequestButton);
		sendRequest.setOnClickListener(this);

	}
	
	@Override
	public void onClick(View v) {

		UserController controller = Application.getUserController();
		SendFriendReq sendReq = new SendFriendReq();
		controller.execute(sendReq,controller.getCurrentActiveUser().getEmail() , destEmail.getText().toString());
		
	}

}