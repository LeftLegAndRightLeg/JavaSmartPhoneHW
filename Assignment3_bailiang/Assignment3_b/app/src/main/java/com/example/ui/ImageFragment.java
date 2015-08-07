package com.example.ui;

import android.app.WallpaperManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;

public class ImageFragment extends Fragment{
	private RadioButton image_1; 
	private RadioButton image_2;
	
	private Button set;
	
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
		
		View view = inflater.inflate(R.layout.fragment_image, container, false);
		
		getReferences(view);
		
		set.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				WallpaperManager wm
		         = WallpaperManager.getInstance(getActivity().getApplicationContext());
				
					if(image_1.isChecked()) {
						
						try {
				             wm.setResource(+R.drawable.image1);
				             image_1.setChecked(false);
				            } catch (Exception e) {
				             // TODO Auto-generated catch block
				             e.printStackTrace();
				            }
					}
					if(image_2.isChecked()) {
						try {
				             wm.setResource(+R.drawable.image2);
				             image_2.setChecked(false);
				            } catch (Exception e) {
				             // TODO Auto-generated catch block
				             e.printStackTrace();
				            }
					}
			}
		});
		
		return view;
	}
	
	public void getReferences(View view){
		
		image_1 = (RadioButton) view.findViewById(R.id.imageradioButton1);
		image_2 = (RadioButton) view.findViewById(R.id.imageradioButton2);
		set = (Button) view.findViewById(R.id.imagesetbutton);
		
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
