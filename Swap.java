package com.example.cascade;

import android.widget.ToggleButton;

public class Swap{
  
	public void swapButton(final ToggleButton colorDestination,final ToggleButton origin1){
		
			if (origin1.isChecked() && colorDestination.isChecked()){
				float temp = colorDestination.getX();
				colorDestination.setX(origin1.getX());
				origin1.setX(temp);
				origin1.setChecked(false);
				colorDestination.setChecked(false);}		
	}
}	

