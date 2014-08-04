package com.example.listviewexpandable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Shosai extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shosai);
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();

		Intent inte = this.getIntent();
		TextView title = (TextView)findViewById(R.id.title_shosai);
		String sTitle = inte.getStringExtra("pTitle");
		title.setText(sTitle);

	}

}
