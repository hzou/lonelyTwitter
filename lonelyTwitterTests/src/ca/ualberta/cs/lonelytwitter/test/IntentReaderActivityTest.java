package ca.ualberta.cs.lonelytwitter.test;

//import android.annotation.SuppressLint;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.lonelytwitter.R;
import android.test.ViewAsserts;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;

//@SuppressLint("NewApi") 
public class IntentReaderActivityTest extends
        ActivityInstrumentationTestCase2<IntentReaderActivity> {

    public IntentReaderActivityTest() {
        super(IntentReaderActivity.class);
    }

//TODO: Add your code here:
    protected void setUp() throws Exception {
        super.setUp();
    }
       
    public void testSendText(){
    	String text = "Hello universe.";
    	int code = IntentReaderActivity.NORMAL;
    	IntentReaderActivity activity = startwithText(text,code);
    	assertEquals("Is text correct?", text,activity.getText());	    	
    }
    
    public void testDoubleText(){
    	String text = "Hello";
    	IntentReaderActivity activity = startwithText(text,IntentReaderActivity.DOUBLE);
    	assertEquals("Doubled?", text+text, activity.getText());
    }
    
    public void testReverseText(){
    	String text = "Hello";
    	IntentReaderActivity activity = startwithText(text,IntentReaderActivity.REVERSE);
    	assertEquals("Reversed text?", "olleH", activity.getText());
    }
    
    public void testDisplayText(){
    	String text = "Hello world";
    	IntentReaderActivity activity = startwithText(text, IntentReaderActivity.NORMAL);
    	assertEquals("correct text?", text, activity.getText());
    	
    	TextView tv = (TextView) activity.findViewById(R.id.intentText);
    	assertEquals("displaying correct text?", text, tv.getText().toString());
    }
    
    public void testDefaultDisplayText(){
    	String defaultText = IntentReaderActivity.DEFAULT_TEXT;
    	IntentReaderActivity activity = startwithText(null, IntentReaderActivity.NORMAL);
    	assertEquals("activity.getText() gets null", null, activity.getText());
    	TextView tv = (TextView) activity.findViewById(R.id.intentText);
    	assertEquals("textview's getText is the default text", defaultText, tv.getText());
    }
    
    public void testDisplayTextVisibleOnScreen(){
    	IntentReaderActivity activity = startwithText("hi", IntentReaderActivity.NORMAL);
    	TextView tv = (TextView) activity.findViewById(R.id.intentText);
    	ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(), tv);
    }
    
    private IntentReaderActivity startwithText(String text, int code){
    	Intent intent = new Intent();
    	intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
    	intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, code);
    	setActivityIntent(intent);
    	return (IntentReaderActivity) getActivity();
    }
}
