package com.FCI.SWE.observerDP;

import java.util.ArrayList;

//import com.FCI.SWE.Controllers.GroupObserver;


public class GroupChat {

	private ArrayList <String> users;
	private GroupObserver observer;

	public ArrayList<String> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<String> users) {
		this.users = users;
		notifyAllUsers();
	}

	public GroupObserver getObserver() {
		return observer;
	}

	public void setObserver(GroupObserver observer) {
		this.observer = observer;
	}

	public void notifyAllUsers() {
		for (String userName : users)
			observer.update(userName);

	}

}
