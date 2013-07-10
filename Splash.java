package com.example.cascade;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity{

  MediaPlayer openingSong;
	
	@Override
	protected void onCreate(Bundle SplashScreen) {
		super.onCreate(SplashScreen);	
		setContentView(R.layout.splash);
		
		Thread timer = new Thread(){
			
			public void run(){
				try{
					openingSong = MediaPlayer.create(Splash.this, R.raw.splash_music);
					openingSong.start();
					sleep(7000);

				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openMenu = new Intent("com.example.cascade.MENU");
					startActivity(openMenu);
				}
				
			}//end run()
		};//end Thread
		timer.start();
	}

	@Override
	protected void onPause() {
		super.onPause();
		openingSong.release();
		finish();
	}
	
}
