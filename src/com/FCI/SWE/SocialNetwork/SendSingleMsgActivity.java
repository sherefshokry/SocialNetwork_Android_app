package com.FCI.SWE.SocialNetwork;


import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;
import com.FCI.SWE.Links.CreateGroupChat;
import com.FCI.SWE.Links.SendSingleMsg;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


	public class SendSingleMsgActivity extends Activity {

		TextView vText;
     	EditText eText;
		Button sendMsg;
	
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_message);

			Bundle extras = getIntent().getExtras();
			String message = extras.getString("message");
			final String Edest= extras.getString("Edestination");
			vText=(TextView) findViewById(R.id.chatView);
		//	String str =message.split("#");
			
				vText.setText(message.replaceAll("#", "\n" ));
			
				
   eText= (EditText)	findViewById(R.id.writeText);		
			
   sendMsg = (Button) findViewById(R.id.reply);
   
   sendMsg.setOnClickListener(new View.OnClickListener() {

	@Override
	public void onClick(View v) {
		final String msg=eText.getText().toString();

		Toast.makeText(Application.getAppContext(),
				msg, Toast.LENGTH_LONG).show();
		UserController controller = Application.getUserController();
		SendSingleMsg grChat = new SendSingleMsg();
		controller.execute(grChat, controller.getCurrentActiveUser().getEmail(),Edest , msg);
	}
});
	
		}	

}
