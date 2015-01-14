package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;

public abstract class User implements UserLike { // abstract means there's no such thing as a plain User. Has to be Author or Reader.
	protected String name;
	/* access modifier can be public, private, protected, or blank (default)
	 * public -- anything from anywhere in the program can access it.
	 * private -- only things in this class can access it.
	 * protected -- it can be accessed from this class and subclasses.
	 * if you don't specify an access modifier, you get the default access modifier (any class in the same package
	 * and any subclass can access default access modifier attributes).
	 */

	public String getName() {
		return name;
	}

	
	public abstract void setName(String x) throws IOException;
		
	public User(String name) {
		super(); // Calling superclass's constructor.
		this.name = name;
	}

	/* Any method that has the same name as the class is a constructor, and constructors do not need a return type.
	 * Called when new object is created.
	 * Can be used for a number of purposes:
	 * - Object starts out with reasonable values for attributes
	 */
	
	// A different constructor - when no name is given, provide a default attribute.
	public User(){
		super();
		this.name = "anonymous";
	}
	
	
}
