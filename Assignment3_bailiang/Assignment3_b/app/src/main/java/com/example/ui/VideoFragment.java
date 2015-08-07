package com.example.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.VideoView;

public class VideoFragment extends Fragment {
	private RadioButton video_1; 
	private RadioButton video_2;
	private VideoView vv;
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
		
		View view = inflater.inflate(R.layout.fragment_video, container, false);
		
		getReferences(view);
		
		//getActivity().getWindow().setFormat(PixelFormat.TRANSLUCENT);
		
		play.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(vv.isPlaying()) {
					vv.stopPlayback();
					play.setText("Play");
				}
				else {
				if(video_1.isChecked()) {
					String path = "android.resource://" + getActivity().getPackageName() +
							"/" + R.raw.video1;
					vv.setVideoURI(Uri.parse(path));
					vv.start();
					video_1.setChecked(false);
					play.setText("Stop");
				}
				if(video_2.isChecked()) {
					String path = "android.resource://" + getActivity().getPackageName() +
							"/" + R.raw.video2;
					vv.setVideoURI(Uri.parse(path));
					vv.start();
					video_2.setChecked(false);
					play.setText("Stop");
				}
				}
			}
		});
		
		return view;
	}
	
	public void getReferences(View view){
		
		video_1 = (RadioButton) view.findViewById(R.id.videoradioButton1);
		video_2 = (RadioButton) view.findViewById(R.id.videoradioButton2);
		vv = (VideoView) view.findViewById(R.id.videoView);
		play = (Button) view.findViewById(R.id.videoplaybutton);
		
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
