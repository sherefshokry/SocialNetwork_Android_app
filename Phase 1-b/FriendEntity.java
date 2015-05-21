package com.FCI.SWE.ServicesModels;

import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Transaction;

public class FriendEntity {

	
	private String Esource;
	private String Edestination;
	private String flag;
	//private long id;

	/**
	 * Constructor accepts user data
	 * 
	 * @param name
	 *            user name
	 * @param email
	 *            user email
	 * @param password
	 *            user provided password
	 */
	public FriendEntity(String Esource, String Edestination) {
		this.Esource = Esource;
		this.Edestination = Edestination;
		//this.flag = flag;
	}
	
	/*
	private void setId(long id){
		this.id = id;
	}
	
	public long getId(){
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPass() {
		return password;
	}

	*/
	/**
	 * 
	 * This static method will form UserEntity class using user name and
	 * password This method will serach for user in datastore
	 * 
	 * @param name
	 *            user name
	 * @param pass
	 *            user password
	 * @return Constructed user entity
	 */

public static Boolean AddFriendService(String Esource, String Edestination) {
	DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();

		Query gaeQuery = new Query("Friends");
		PreparedQuery pq = datastore.prepare(gaeQuery);
	for (Entity entity : pq.asIterable()) 
	{
	if (entity.getProperty("Esource").toString().equals(Esource)
	&& entity.getProperty("Edestination").toString().equals(Edestination) &&  entity.getProperty("flag").equals("0") ) 
		{
			entity.setProperty("flag", "1");
			datastore.put(entity);
			return true;				
		}
	}
		return false;
	}

	/**
	 * This method will be used to save user object in datastore
	 * 
	 * @return boolean if user is saved correctly or not
	 */

	public Boolean SaveFriendRequest() {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Transaction txn = datastore.beginTransaction();
		Query gaeQuery = new Query("Friends");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());
		System.out.println("Size = " + list.size());		
		try {
			
		Entity friend = new Entity("Friends", list.size() + 2);

		friend .setProperty("Esource", this.Esource);
		friend .setProperty("Edestination", this.Edestination);
		friend .setProperty("flag", "0");
		datastore.put(friend );
		txn.commit();
		}finally{
			if (txn.isActive()) {
		        txn.rollback();
		    }
		}
		return true;
	}
}