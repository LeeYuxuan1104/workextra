package com.view.device;

import com.app.zhugeyang.R;
import com.model.view.MenuAdapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class VDeviceSafeActivity extends Activity implements OnClickListener{
	private Context  context;
	private TextView back,home,title;
	private ListView listView;
	private String[] names=new String[]{"储罐等压力容器管理","压力表安全阀","浓度报警","消防、静电、防雷池","安全操作图示","应急备案流程记录"};
	private MenuAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_device_safe);
		initView();
		initEvent();
	}
	private void initView(){
		back =(TextView) findViewById(R.id.back);
		home =(TextView) findViewById(R.id.home);
		title=(TextView) findViewById(R.id.title);
		listView=(ListView) findViewById(R.id.list);
	}
	private void initEvent(){
		context=VDeviceSafeActivity.this;
		title.setText("安全管理");
		back.setText("< 返回");
		home.setText("主页");
		back.setOnClickListener(this);
		home.setOnClickListener(this);
		adapter=new MenuAdapter(context, names);
		listView.setAdapter(adapter);
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
