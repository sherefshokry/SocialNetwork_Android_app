	package com.FCI.SWE.SocialNetwork;

	import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

	import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

	import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;
import com.FCI.SWE.Links.AcceptFriend;
import com.FCI.SWE.Links.ReadSingleMsg;

	public class GetSingleMsgsActivity  extends Activity {

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_groupmsgslist);

			Bundle extras = getIntent().getExtras();

			// String status = extras.getString("status");

			String emails = extras.getString("Emails");
		
			final String[] Emails = emails.split("#");

			ArrayAdapter<String> data;

			final List<String> userNames = new ArrayList<String>(Arrays.asList(Emails));

			data = new ArrayAdapter<String>(this, R.layout.listitem,
					R.id.viewNames, userNames);

			final ListView list = (ListView) findViewById(R.id.listView1);

			list.setAdapter(data);

			list.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> data, View view,
						final int position, long id) {

				
				UserController controller = Application.getUserController();
					ReadSingleMsg accFr = new ReadSingleMsg();
					controller.execute(accFr ,controller.getCurrentActiveUser().getEmail() ,userNames.get(position));
					
				/*	Intent intent_rss = new Intent(GetSingleMsgsActivity.this,HomeActivity.class);
					//intent_rss.putExtra("message", message);
					startActivity(intent_rss);
*/
				}
			});

				
		}
		
	}


