package com.FCI.SWE.SocialNetwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;
import com.FCI.SWE.Links.AcceptFriend;

import android.R.array;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class FriendRequestsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_friendrequest);

		Bundle extras = getIntent().getExtras();

		// String status = extras.getString("status");

		String unames = extras.getString("unames");
		String emails = extras.getString("emails");

		final String[] names = unames.split("#");
		String[] mails = emails.split("#");

		ArrayAdapter<String> data;

		List<String> userNames = new ArrayList<String>(Arrays.asList(mails));

		data = new ArrayAdapter<String>(this, R.layout.listitem,
				R.id.viewNames, userNames);

		final ListView list = (ListView) findViewById(R.id.listView1);

		list.setAdapter(data);

		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> data, View view,
					final int position, long id) {

				/*
				 * String temp = (String) list.getItemAtPosition(position);
				 * //disp.setText(temp);
				 * Toast.makeText(Application.getAppContext
				 * (),temp,Toast.LENGTH_SHORT).show();
				 */
				UserController controller = Application.getUserController();
				AcceptFriend accFr = new AcceptFriend();
				controller.execute(accFr, names[position]);

				/*
				 * Button button = (Button) findViewById(R.id.button1);
				 * button.setOnClickListener(new View.OnClickListener() { public
				 * void onClick(View v) {
				 * //Toast.makeText(Application.getAppContext
				 * (),position,Toast.LENGTH_SHORT).show();
				 * 
				 * 
				 * 
				 * 
				 * 
				 * //String temp = (String) list.getItemAtPosition(position);
				 * //disp.setText(temp);
				 * Toast.makeText(Application.getAppContext
				 * (),"ffffff",Toast.LENGTH_SHORT).show(); } });
				 */

			}
		});

	}

}
