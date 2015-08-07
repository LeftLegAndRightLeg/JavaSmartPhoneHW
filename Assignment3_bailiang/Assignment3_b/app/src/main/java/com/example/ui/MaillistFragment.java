package com.example.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MaillistFragment extends Fragment{

	private EditText name; 
	private EditText email;
	
	private Button send;
	
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
		
		View view = inflater.inflate(R.layout.fragment_maillist, container, false);
		
		getReferences(view);
		
		send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				StringBuilder add = new StringBuilder();
				add.append("Add ");
				add.append("Name "+ name.getText().toString() + ", ");
				add.append("Email " + email.getText().toString() + " ");
				add.append("to mailing list.");
				
					if(name.getText().toString().length() != 0){
						
						Intent sendit = new Intent(Intent.ACTION_SEND);
						sendit.putExtra(Intent.EXTRA_EMAIL, new String[]{"bailiang.gong@sv.cmu.edu"});
						sendit.putExtra(Intent.EXTRA_TEXT, add.toString());
						sendit.putExtra(Intent.EXTRA_SUBJECT, "VocalArtist Cecilia Cheung");
						sendit.setType("message/rfc822");
						startActivity(Intent.createChooser(sendit, "Send Email"));
					}
				
			}
		});
		
		return view;
	}
	
	public void getReferences(View view){
		
		name = (EditText) view.findViewById(R.id.mlNameEditText);
		email = (EditText) view.findViewById(R.id.mlEmailEditText);
		
		send = (Button) view.findViewById(R.id.sendbutton);
		
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
