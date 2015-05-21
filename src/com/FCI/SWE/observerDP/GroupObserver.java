package com.FCI.SWE.observerDP;

public abstract class GroupObserver 
{
	protected GroupChat GC;

	public abstract void update(String Username);
	
	public abstract void attachObserver(GroupChat groupChat);
	
}