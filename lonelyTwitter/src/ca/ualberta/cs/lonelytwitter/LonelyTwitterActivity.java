package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class LonelyTwitterActivity extends Activity {

<<<<<<< HEAD:lonelyTwitter/src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
	private static final String FILENAME = "file.json";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<NormalTweetModel> tweets;
	private ArrayAdapter<NormalTweetModel> adapter;
=======
	private static final String FILENAME = "file.sav"; // Allcap final attributes for convention
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<String> tweets;
	private ArrayAdapter<String> adapter;
>>>>>>> ae3a2cdd2eb7ee97e2e49d40ff061ecaf22cf0e4:src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
<<<<<<< HEAD:lonelyTwitter/src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
				NormalTweetModel tweet = new NormalTweetModel(text);
				saveInFile(tweet);
				tweets.add(tweet);
				bodyText.setText(null);
				adapter.notifyDataSetChanged();
=======
				tweets.add(text);
				adapter.notifyDataSetChanged();
				saveInFile(text, new Date(System.currentTimeMillis()));
>>>>>>> ae3a2cdd2eb7ee97e2e49d40ff061ecaf22cf0e4:src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		/*
		User u = new Author("joe"); // it's acceptable to have User on the left side and Author on the right side.
		try {
			u.setName("joe2");
		} catch (IOException e){
			// some code that tells the user to use a shorter name
			e.printStackTrace();
		}
		
		ArrayList<User> x = new ArrayList<User>();
		*/
		
		super.onStart();
		tweets = loadFromFile();
<<<<<<< HEAD:lonelyTwitter/src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
		adapter = new ArrayAdapter<NormalTweetModel>(this,
=======
		adapter = new ArrayAdapter<String>(this,
>>>>>>> ae3a2cdd2eb7ee97e2e49d40ff061ecaf22cf0e4:src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

<<<<<<< HEAD:lonelyTwitter/src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
	public ArrayAdapter<NormalTweetModel> getAdapter(){
		return adapter;
	}
	
	public void setAdapter(ArrayAdapter<NormalTweetModel> adapter){
		this.adapter = adapter;
	}

	private ArrayList<NormalTweetModel> loadFromFile() {
		ArrayList<NormalTweetModel> tweets = new ArrayList<NormalTweetModel>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			String line = in.readLine();
			while (line != null) {
				tweets.add(NormalTweetModel.fromJSON(line));
				line = in.readLine();
			}

=======
	private ArrayList<String> loadFromFile() {
		Gson gson = new Gson();
		ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			InputStreamReader isr = new InputStreamReader(fis);
			// https://sites.google.com/site/gson/gson-user-guide 2015-01-21
			Type dataType = new TypeToken<ArrayList<String>>() {}.getType();
			tweets = gson.fromJson(isr, dataType);
			fis.close();
			
>>>>>>> ae3a2cdd2eb7ee97e2e49d40ff061ecaf22cf0e4:src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
<<<<<<< HEAD:lonelyTwitter/src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
		return tweets;
	}
	
	private void saveInFile(NormalTweetModel tweet) {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_APPEND);
			fos.write((tweet.toJSON() + "\n").getBytes());
=======
		if (tweets == null){
			tweets = new ArrayList<String>();
		}
		return tweets;
	}
	
	private void saveInFile(String text, Date date) {
		Gson gson = new Gson();
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					0);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			gson.toJson(tweets, osw);
			osw.flush();
>>>>>>> ae3a2cdd2eb7ee97e2e49d40ff061ecaf22cf0e4:src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
			fos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}