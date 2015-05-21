package com.FCI.SWE.observerDP;

import com.FCI.SWE.Controllers.UserController;

public class AddMemberObserver extends GroupObserver {

  private UserController userController;
private GroupChat groupChat;
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
