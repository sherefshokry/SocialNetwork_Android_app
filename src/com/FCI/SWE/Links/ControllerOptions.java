package com.FCI.SWE.Links;

import org.json.JSONException;

public interface ControllerOptions 
{
	public abstract String[] connect(String ... params);
	public abstract void connReturn(String result) throws JSONException;
}
