package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

public abstract class Tweet {
    private String message;
    private Date timeStamp;
    private ArrayList<String> retweets;
    private ArrayList<String> favorites;
    private String user;
    
    public Tweet(User user){
    	this.message = "(blank tweet)";
    	this.user = user.getName();
    	this.timeStamp = new Date();
    }
    
    public Tweet(User user, String message){
    	this.message = message;
    	this.user = user.getName();
    	this.timeStamp = new Date();
    }
    
    
    public ArrayList<String> getRetweets(){
		return retweets;
    }
    
    public void setRetweets(ArrayList<String> retweets){
    	this.retweets = retweets;
    }
    
    public ArrayList<String> getFavorites(){
    	return favorites;
    }
    
    public void setFavorites(ArrayList<String> favorites){
    	this.favorites = favorites;
    }
    
    public void retweet(User user){
    	retweets.add(user.getName()); 
    }
    
    public void favorite(User user){
    	favorites.add(user.getName());
    }
}
