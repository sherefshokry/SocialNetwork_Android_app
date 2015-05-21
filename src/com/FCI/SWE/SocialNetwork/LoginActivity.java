package com.FCI.SWE.SocialNetwork;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;
import com.FCI.SWE.Links.LogIn;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity implements OnClickListener {

	EditText userNameEditText;
	EditText passwordEditText;
	Button loginButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		userNameEditText = (EditText) findViewById(R.id.usernameLogin);
		passwordEditText = (EditText) findViewById(R.id.password);
		loginButton = (Button) findViewById(R.id.loginButton);
		loginButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		UserController controller = Application.getUserController();
		LogIn logIn = new LogIn();
		controller.execute(logIn, userNameEditText.getText().toString(),
				passwordEditText.getText().toString());
		

	}

}
