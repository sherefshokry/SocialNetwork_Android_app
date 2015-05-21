package com.FCI.SWE.observerDP;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;
import com.FCI.SWE.Links.CreateGroupChat;
import com.FCI.SWE.Links.notifyMessage;

public class MessageObserver extends GroupObserver {

	private GroupChat groupChat;
	private UserController userController;
	
	@Override
	public void attachObserver(GroupChat groupChat) {

		this.groupChat = groupChat;
		this.groupChat.setObserver( this );

	}

	@Override
	public void update(String Username) {
		
		UserController controller = Application.getUserController();
	    notifyMessage grChat = new  notifyMessage();
		controller.execute(grChat, Username);
	
	}

}
