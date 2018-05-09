package com.view.run;

import com.app.zhugeyang.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class VRunClassActivity extends Activity implements OnClickListener{
	private TextView back,home,title;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_run_class);
		initView();
		initEvent();
	}
	private void initView(){
		back =(TextView) findViewById(R.id.back);
		home =(TextView) findViewById(R.id.home);
		title=(TextView) findViewById(R.id.title);
	}
	private void initEvent(){
		title.setText("交接班管理");
		back.setText("< 返回");
		home.setText("主页");
		back.setOnClickListener(this);
		home.setOnClickListener(this);
	}
	@Override
	public void onClick(View view) {
		int nVid=view.getId();
		switch (nVid) {
		case R.id.back:
			finish();
			break;
		case R.id.home:
			
			break;

		default:
			break;
		}
		
	}
}
