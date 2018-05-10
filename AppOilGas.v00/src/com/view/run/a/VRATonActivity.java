package com.view.run.a;

import java.util.ArrayList;
import java.util.List;

import com.app.zhugeyang.R;
import com.model.view.HomeArc;
import com.model.view.HomeColumnar;
import com.model.view.HomeDiagram;
import com.model.view.Score;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class VRATonActivity extends Activity implements OnClickListener{
//	private Context context;
	private TextView back,title;
	private LinearLayout arc;
    private RelativeLayout pillars,linear;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_run_a_ton);
		//	初始化控件;
		initView();
		//	初始化事件;
		initEvent();
	}
	//	初始化控件;
	private void initView(){
		back=(TextView) findViewById(R.id.back);
		title=(TextView) findViewById(R.id.title);
	}
	//	初始化事件;
	private void initEvent(){
//		context=VRATonActivity.this;
		title.setText("吨亏分析");
		back.setText("< 返回");
		back.setOnClickListener(this);
		arc = (LinearLayout) findViewById(R.id.arc);//圆弧计分
		arc.addView(new HomeArc(this, 90)); 
		
		List<Score> list = new ArrayList<Score>();;//柱状图  范围10-100
		for (int i = 0; i < 28; i++) {
			Score s = new Score();
			s.date = "2013-10-" + i;
			s.score = getRandom(10,100);
			list.add(s);
		}
		pillars= (RelativeLayout) findViewById(R.id.pillars);
		pillars.addView(new HomeColumnar(this,list));
		
		List<Integer> lists = new ArrayList<Integer>();//线性图  范围10-100
		for (int i = 0; i < 48; i++) {
			if (i < 8 || i == 28 || i == 12 || i == 18 || i == 20 || i == 30
					|| i == 34) {
				lists.add(0);
			} else {
				lists.add(getRandom(0, 500));
			}
		}
		linear= (RelativeLayout) findViewById(R.id.linear);
		linear.addView(new HomeDiagram(this,lists));
	}
	@Override
	public void onClick(View view) {
		int nVid=view.getId();
		switch (nVid) {
		case R.id.back:
			finish();
			break;

		default:
			break;
		}
	}
	public int getRandom(int min,int max){
		return (int) Math.round(Math.random()*(max-min)+min);
	}
}
