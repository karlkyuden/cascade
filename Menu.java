package com.example.cascade;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Menu extends Activity {
  
	Button b1;
	TextView tv1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		
		setupUI();
	}

	public void setupUI() {
		b1 = (Button)findViewById(R.id.button1);
		tv1 = (TextView)findViewById(R.id.textView1);
		
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent newGame = new Intent("com.example.cascade.STARTINGPOINT");
				startActivity(newGame);
			}
		});
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		finish();
	}
}
