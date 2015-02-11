package ca.ualberta.cs.lonelytwitter.test;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;

public class LonelyTwitterActivityUITest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	Instrumentation instrumentation;
	Activity activity;
	EditText textInput;
	
	public LonelyTwitterActivityUITest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		instrumentation = getInstrumentation();
		activity = getActivity();
		textInput = ((EditText) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.body));
	}
	
	public void testSetText(){
		String text = "neat!";
		instrumentation.runOnMainSync(new Runnable(){
			@Override
			public void run(){
				textInput.setText("neat!");
			}
		});
		instrumentation.waitForIdleSync();
		
		assertEquals("Does this work?", text, textInput.getText().toString());
	}
	
	 //makeTweet(text) fills in the input text field and clicks the 'save' button for the activity under test:
	private void makeTweet(String text) {
		assertNotNull(activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save));
		textInput.setText(text);
		((Button) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save)).performClick();
	}
	
//TODO: Add your code here:
    public void testAddTweet(){
    	String text = "Hello universe";
    	ArrayAdapter<NormalTweetModel> adapter = ((LonelyTwitterActivity) activity).getAdapter();
    	int before = adapter.getCount();
    	instrumentation.runOnMainSync(new Runnable(){
    		@Override
    		public void run(){
    			makeTweet("Hello universe");
    		}
    	});
    	instrumentation.waitForIdleSync();
    	int after = adapter.getCount();
    	// Assert that the ListVieAdapter adds a new tweet.
    	assertEquals("Adapter count increased by 1", before+1, after);
    	
    	// Assert that the new tweet added is a NormalTweet.
    	assertEquals("Class of the added tweet should be NormalTweetModel",
    			adapter.getItem(adapter.getCount()-1).getClass(), NormalTweetModel.class);
    	
    	// Assert that the text ("Hello universe") of the tweet is correct.
    	assertEquals("Text of that tweet should be correct", text, 
    			adapter.getItem(adapter.getCount()-1).getText().toString());
    	
    	// Assert that the EditText is cleared (empty string) after you submit at tweet.
    	assertEquals("The EditText is cleared", textInput.getText().toString(), "");
    }
}
