package ca.ualberta.cs.lonelytwitter;

public class Author extends User {

	public Author() {
		super();
		name = "anonymous_author";
	}

	public Author(String string){
		super(string);
	}

	@Override
	public void setName(String x) {
		name = x;		
	}
	

}