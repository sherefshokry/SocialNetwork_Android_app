package com.FCI.SWE.Controllers;

import com.FCI.SWE.observerDP.GroupChat;
import com.FCI.SWE.observerDP.GroupObserver;

public class MessageObserver extends GroupObserver {

	 private GroupChat groupChat;
	 private UserController userController;

	 @Override
	public void update(String Username) {
		// TODO Auto-generated method stub
		 
		 
		 
		
	}

	@Override
	public void attachObserver(GroupChat groupChat) {
		
		this.groupChat = groupChat;
		groupChat.setObserver(this);
		
	}

}
