package com.example.jsonparse;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.content.Intent;
import android.widget.Button;

public class MainActivity1 extends Activity {


	Button Viewb;   //button is used to redirect another activity
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity1);

		Viewb=(Button)findViewById(R.id.button1);
		Viewb.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
		
				 Intent intent = new Intent(MainActivity1.this, JsonData.class);
                 startActivity(intent);
			}
		
		});}


@Override
public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.main_activity1, menu);
	return true;
}}