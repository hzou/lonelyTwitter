package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;

public class Reader extends User {
	private static Boolean enabled = false; // static for attributes means all Reader objects share this value.
	
	public void setName(String x) throws IOException{
		if (x.length()>8){
			throw new IOException("Name too long!");
		}
		this.name = x;
	}
	
	public Reader(String string) {
		super(string);
	}

	public Reader() {
		super();
		name = "anonymous_reader";
	}
	
}