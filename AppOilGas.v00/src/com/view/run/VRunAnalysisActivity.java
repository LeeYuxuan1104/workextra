package com.view.run;

import com.app.zhugeyang.R;
import com.model.view.MenuAdapter;
import com.view.run.a.VRAFinanceActivity;
import com.view.run.a.VRAHabitActivity;
import com.view.run.a.VRAIncomeActivity;
import com.view.run.a.VRATonActivity;
import com.view.run.a.VRATrendActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class VRunAnalysisActivity extends Activity implements OnClickListener{
	private Context  context;
	private Intent	 intent;
	private TextView back,home,title;
	private ListView listView;
	private String[] names=new String[]{"销售收入","客户消费趋势变化分析","客户消费习惯","财务分析报表","亏吨分析"};
	private MenuAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_run_analysis);
		initView();
		initEvent();
	}
	private void initView(){
		context=VRunAnalysisActivity.this;
		back =(TextView) findViewById(R.id.back);
		home =(TextView) findViewById(R.id.home);
		title=(TextView) findViewById(R.id.title);
		listView=(ListView) findViewById(R.id.list);
	}
	private void initEvent(){
		title.setText("经营分析");
		back.setText("< 返回");
		home.setText("主页");
		back.setOnClickListener(this);
		home.setOnClickListener(this);
		adapter=new MenuAdapter(context, names);
		listView.setAdapter(adapter);
		//	事件监听;
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long id) {
				switch (position) {
				case 0:
					intent=new Intent(context, VRAIncomeActivity.class);
					break;
				case 1:
					intent=new Intent(context, VRATrendActivity.class);
					break;
				case 2:
					intent=new Intent(context, VRAHabitActivity.class);
					break;
				case 3:
					intent=new Intent(context, VRAFinanceActivity.class);
					break;
				case 4:
					intent=new Intent(context, VRATonActivity.class);
					break;
				default:
					break;
				}
				startActivity(intent);
			}
		});
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
