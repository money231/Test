package com.example.mobile03_31;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.*;


public class MainActivity extends Activity{
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button sendBtn=(Button)findViewById(R.id.send);
				
		Button callBtn=(Button)findViewById(R.id.call);
		
		Button messageBtn=(Button)findViewById(R.id.message);
		
		sendBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText sendText=(EditText)findViewById(R.id.text);
				String message=sendText.getText().toString();
				
				Intent intent=new Intent(MainActivity.this, secondActivity.class);
				
				intent.putExtra("a_message",message);
				
				startActivity(intent);
				
				finish();
			}
		});
		
		callBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText sendCall=(EditText)findViewById(R.id.text);
				String callNumber=sendCall.getText().toString();
				
				callNumber="tel:"+callNumber;
				
				Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse(callNumber));
				
				startActivity(intent);
				
			}
		});
		
		messageBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText sendCall=(EditText)findViewById(R.id.text);
				String callNumber=sendCall.getText().toString();
				
				callNumber="smsto:"+callNumber;
				
				EditText sendSms=(EditText)findViewById(R.id.text2);
				String sendMessage=sendSms.getText().toString();
				
				Intent intent=new Intent(Intent.ACTION_SENDTO,Uri.parse(callNumber));
				
				intent.putExtra("send_sms", sendMessage);
				startActivity(intent);
			}
		});
		
		
	}

	
}
