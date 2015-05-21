package com.FCI.SWE.SocialNetwork;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;
import com.FCI.SWE.Links.SendGroupMsg;

public class sendGroupMsgActivity extends Activity{

		TextView vText;
     	EditText eText;
		Button sendMsg;
	
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_gr_message);

			Bundle extras = getIntent().getExtras();
			
			String message = extras.getString("message");
			final String id= extras.getString("id");
			
			
			vText=(TextView) findViewById(R.id.chatView);
		//	String str =message.split("#");
			
				vText.setText(message.replaceAll("#", "\n" ));
			
				
   eText= (EditText)	findViewById(R.id.writeText1);		
			
   sendMsg = (Button) findViewById(R.id.reply1);
   
   sendMsg.setOnClickListener(new View.OnClickListener() {

	@Override
	public void onClick(View v) {
		final String msg=eText.getText().toString();

		Toast.makeText(Application.getAppContext(),
				msg, Toast.LENGTH_LONG).show();
		UserController controller = Application.getUserController();
		SendGroupMsg grChat = new SendGroupMsg();
		controller.execute(grChat, controller.getCurrentActiveUser().getEmail(),id , msg);
	
	}
});
		}
}