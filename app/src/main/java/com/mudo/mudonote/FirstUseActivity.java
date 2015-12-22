package com.mudo.mudonote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FirstUseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first_use);
	}
	
	
	public void skipto(View v){
		Intent intent = new Intent(this,HomeActivity.class);
		startActivity(intent);
	}
	
}
