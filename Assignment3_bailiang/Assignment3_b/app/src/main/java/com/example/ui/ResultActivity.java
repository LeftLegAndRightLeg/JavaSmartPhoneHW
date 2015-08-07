package com.example.ui;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;  
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class ResultActivity extends ActionBarActivity implements OnClickListener{

	private ImageButton imageButton;
	private ImageButton maillistButton;
	private ImageButton musicButton;
	private ImageButton videoButton;
	
	private ImageFragment image;
	private MaillistFragment maillist;
	private MusicFragment music;
	private VideoFragment video;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		View v = findViewById(R.id.container);
		v.getBackground().setAlpha(100);
		
		imageButton = (ImageButton) findViewById(R.id.imageButton);
		maillistButton = (ImageButton) findViewById(R.id.maillistButton);
		musicButton = (ImageButton) findViewById(R.id.musicButton);
		videoButton = (ImageButton) findViewById(R.id.videoButton);
		
		imageButton.setOnClickListener(this);
		maillistButton.setOnClickListener(this);
		musicButton.setOnClickListener(this);
		videoButton.setOnClickListener(this);
		
		setDefaultFragment();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	
	}

	private void setDefaultFragment(){
		
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction tr = fm.beginTransaction();
		video = new VideoFragment();
		tr.replace(R.id.content, video);
		tr.commit();
		
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction tr = fm.beginTransaction();
		
		switch(v.getId()){
		
		case R.id.imageButton:
			if(image == null)
				image = new ImageFragment();
			tr.replace(R.id.content, image);
			break;
			
		case R.id.maillistButton:
			if(maillist == null)
				maillist = new MaillistFragment();
			tr.replace(R.id.content, maillist);
			break;
		
		case R.id.musicButton:
			if(music == null)
				music = new MusicFragment();
			tr.replace(R.id.content, music);
			break;
			
		case R.id.videoButton:
			if(video == null)
				video = new VideoFragment();
			tr.replace(R.id.content, video);
			break;
		}
		tr.commit();
	}
}
