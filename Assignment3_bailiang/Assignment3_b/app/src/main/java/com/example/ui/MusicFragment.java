package com.example.ui;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;


public class MusicFragment extends Fragment{

	private RadioButton music_1; 
	private RadioButton music_2;
	
	private Button play;
	
	@Override 
	public void onCreate(Bundle savedInstanceState) 
	{ 
	// TODO Auto-generated method stub 
	super.onCreate(savedInstanceState); 
	System.out.println("ExampleFragment--onCreate"); 
	} 
	
	@Override 
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedInstanceState){
		System.out.println("ExampleFragment--onCreateView"); 
		
		View view = inflater.inflate(R.layout.fragment_music, container, false);
		
		getReferences(view);
		
		play.setOnClickListener(new OnClickListener() {
			MediaPlayer mp = new MediaPlayer();
			@Override
			public void onClick(View v) {
				if(mp.isPlaying()) {
					mp.stop();
					play.setText("Play");
				}
				else {
					if(music_1.isChecked()) {
						mp = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.music1);
						mp.start();
						music_1.setChecked(false);
						play.setText("Stop");
					}
					if(music_2.isChecked()) {
						mp = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.music2);
						mp.start();
						music_1.setChecked(false);
						play.setText("Stop");
					}
				}

			}
		});
		
		return view;
	}
	
	public void getReferences(View view){
		
		music_1 = (RadioButton) view.findViewById(R.id.radioButton1);
		music_2 = (RadioButton) view.findViewById(R.id.radioButton2);
		play = (Button) view.findViewById(R.id.musicplaybutton);
		
	}
	
	@Override 
	public void onPause() { 
	// TODO Auto-generated method stub 
	super.onPause(); 
	System.out.println("ExampleFragment--onPause"); 
	} 
	
	@Override 
	public void onResume() { 
	// TODO Auto-generated method stub 
	super.onResume(); 
	System.out.println("ExampleFragment--onResume"); 
	} 
	
	@Override 
	public void onStop() { 
	// TODO Auto-generated method stub 
	super.onStop(); 
	System.out.println("ExampleFragment--onStop"); 
	} 
}

