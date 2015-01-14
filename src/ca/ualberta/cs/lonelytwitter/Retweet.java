package ca.ualberta.cs.lonelytwitter;

public class Retweet extends Tweet {
	public Retweet(User user, String message){
		message.prepend("RT: ");
		super(user, message);
	}
	
	public Retweet(User user){
		
	}
}
