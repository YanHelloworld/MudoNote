package com.mudo.mudonote;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class EditNoteActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editnote);
		
		initTitle();
	}
	
	public void initTitle(){
		
		Button iv_cancel = (Button) findViewById(R.id.iv_titlebar_cancel);
		Button iv_complete = (Button) findViewById(R.id.iv_titlebar_complete);
		iv_cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		iv_complete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(EditNoteActivity.this, "点击完成", Toast.LENGTH_LONG).show();
			}
		});
	}
}
