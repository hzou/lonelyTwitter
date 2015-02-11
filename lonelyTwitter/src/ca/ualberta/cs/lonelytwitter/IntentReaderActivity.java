package ca.ualberta.cs.lonelytwitter;

import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class IntentReaderActivity extends Activity {

	public static final String TEXT_KEY = "TEXT";
	public static final String TRANSFORM_KEY = "TRANSFORM";

	public static final int NORMAL = 1;
	public static final int REVERSE = 2;
	public static final int DOUBLE = 3;
	
	public static final String DEFAULT_TEXT = "Default Text";
	
	private String text;
	private int mode;
	
	public String getText() {
		
		return text;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent_reader);
		Intent intent = getIntent();
		mode = intent.getIntExtra(TRANSFORM_KEY, NORMAL);
		text = transformText(intent.getStringExtra(TEXT_KEY));
		TextView tv = (TextView) findViewById(R.id.intentText);
		tv.setText(text);
		if (text == null){
			tv.setText(DEFAULT_TEXT);
		}
		//TODO: Add your code here:
	}

	public String transformText(String str) {
		switch (mode) {
			case REVERSE:
				char[] str2 =  str.toCharArray();
				for (int i = 0; i < str2.length / 2; i++) {
					char tmp = str2[i];
					str2[i] = str2[str2.length - i -1];
					str2[str2.length - i - 1] = tmp;
				}//for.
				return new String(str2);
			case DOUBLE:
				return str + str;
			default: 
				return str;
		}
	}
}
