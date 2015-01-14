package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;

public interface UserLike {
	public void setName(String x) throws IOException; // no "abstract" keyword since it would be redundant.
	
}