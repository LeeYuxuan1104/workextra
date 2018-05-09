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

public class VDeviceSpendActivity extends Activity implements OnClickListener{
	private Context  context;
	private TextView back,home,title;
	private ListView listView;
	private String[] names=new String[]{"潜液泵","柱塞泵","储罐真空度","保冷","加气、加油计量","日常消耗部件的更换提醒","销售配件商城"};
	private MenuAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_device_spend);
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
		context=VDeviceSpendActivity.this;
		title.setText("消耗、更新");
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
