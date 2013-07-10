package com.example.cascade;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.ToggleButton;

public class StartingPoint extends Activity {

  @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.starting_point);

		// To link the path and button xml to the Java code
		final ToggleButton redButton = (ToggleButton) findViewById(R.id.red);
		final ToggleButton greenButton = (ToggleButton) findViewById(R.id.green);
		final ToggleButton blueButton = (ToggleButton) findViewById(R.id.blue);
		final TextView counter = (TextView) findViewById(R.id.countdown);
		ToggleButton leftButton = (ToggleButton) findViewById(R.id.leftButton);
		ToggleButton centerButton = (ToggleButton) findViewById(R.id.centerButton);
		ToggleButton rightButton = (ToggleButton) findViewById(R.id.rightButton);

		// Randomizes the winning set at the bottom
		Randomizer winningSet = new Randomizer();
		winningSet.random(leftButton, centerButton, rightButton);

		// Controls the count down timer from 30 seconds and displays
		// in 1 second intervals
		new CountDownTimer(10000, 1) {
			@Override
			public void onTick(long millisUntilFinished) {
				counter.setText("Time left " + millisUntilFinished / 1000);

				// each millisecond it ticks the circle drops by 1/speedFactor
				// of the height of the path
				moveButtons(redButton);
				moveButtons(greenButton);
				moveButtons(blueButton);

				Swap swap = new Swap();

				swap.swapButton(greenButton, redButton);
				swap.swapButton(blueButton, redButton);
				swap.swapButton(redButton, greenButton);
				swap.swapButton(blueButton, greenButton);
				swap.swapButton(redButton, blueButton);
				swap.swapButton(greenButton, blueButton);

			}

			@Override
			public void onFinish() {
				counter.setText("done!");
			}
		}.start();
	}

	// method that moves the circle down the path
	public void moveButtons(ToggleButton color) {
		final TextView path = (TextView) findViewById(R.id.colorPath);
		int speedFactor = 250;
		int heightPercent = path.getHeight() / speedFactor;

		if (color.getY() < path.getBottom()) {
			color.setY(color.getY() + heightPercent);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.starting_point, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.new_game:
			Intent intent = getIntent();
			overridePendingTransition(0, 0);
			intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
			finish();

			overridePendingTransition(0, 0);
			startActivity(intent);
			break;
		case R.id.exit:
			finish();
			System.exit(0);
		}
		return false;
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		finish();
	}

}
