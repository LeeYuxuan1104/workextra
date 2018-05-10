package com.view.run.a;

import java.util.ArrayList;
import java.util.List;

import com.app.zhugeyang.R;
import com.model.view.ChooseMenuView;
import com.model.view.HomeArc;
import com.model.view.HomeColumnar;
import com.model.view.HomeDiagram;
import com.model.view.Score;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;



public class VRAIncomeActivity extends Activity implements OnClickListener{
	private Context context;
	private TextView back,title;
	//
	private LinearLayout arc;
    private RelativeLayout pillars,linear;
    //	进行数据的的声明;
    private RelativeLayout lay1,lay2,lay3,lay4,lay5,lay6,lay7,lay8,lay9,lay10,lay11;
    private TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,txt11;
    private RelativeLayout[] lays;
    private TextView[] txts;
    private ChooseMenuView chooseMenuView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_run_a_income);
		//	进行控件的设定;
		initView();
		initEvent();
		initTop();
	}
	
	
	//	控件初始化;
	private void initView(){
		back =(TextView) findViewById(R.id.back);
		title=(TextView) findViewById(R.id.title);
		back.setText("< 返回");
		title.setText("销售收入");
		
		//	上方按钮的初始化;
		lay1=(RelativeLayout) findViewById(R.id.lay1);
		txt1=(TextView) findViewById(R.id.txt1);
		lay2=(RelativeLayout) findViewById(R.id.lay2);
		txt2=(TextView) findViewById(R.id.txt2);
		lay3=(RelativeLayout) findViewById(R.id.lay3);
		txt3=(TextView) findViewById(R.id.txt3);
		lay4=(RelativeLayout) findViewById(R.id.lay4);
		txt4=(TextView) findViewById(R.id.txt4);
		lay5=(RelativeLayout) findViewById(R.id.lay5);
		txt5=(TextView) findViewById(R.id.txt5);
		lay6=(RelativeLayout) findViewById(R.id.lay6);
		txt6=(TextView) findViewById(R.id.txt6);
		lay7=(RelativeLayout) findViewById(R.id.lay7);
		txt7=(TextView) findViewById(R.id.txt7);
		lay8=(RelativeLayout) findViewById(R.id.lay8);
		txt8=(TextView) findViewById(R.id.txt8);
		lay9=(RelativeLayout) findViewById(R.id.lay9);
		txt9=(TextView) findViewById(R.id.txt9);
		lay10=(RelativeLayout) findViewById(R.id.lay10);
		txt10=(TextView) findViewById(R.id.txt10);
		lay11=(RelativeLayout) findViewById(R.id.lay11);
		txt11=(TextView) findViewById(R.id.txt11);
	}
	// 控件的初始化;
	private void initTop(){
		lays=new RelativeLayout[11];
		txts=new TextView[11];
		lays[0]=lay1;
		txts[0]=txt1;
		lays[1]=lay2;
		txts[1]=txt2;
		lays[2]=lay3;
		txts[2]=txt3;
		lays[3]=lay4;
		txts[3]=txt4;
		lays[4]=lay5;
		txts[4]=txt5;
		lays[5]=lay6;
		txts[5]=txt6;
		lays[6]=lay7;
		txts[6]=txt7;
		lays[7]=lay8;
		txts[7]=txt8;
		lays[8]=lay9;
		txts[8]=txt9;
		lays[9]=lay10;
		txts[9]=txt10;
		lays[10]=lay11;
		txts[10]=txt11;
		chooseMenuView=new ChooseMenuView(lays);
		for(int i=0;i<txts.length;i++){
			txts[i].setText("内容"+(i+1));
		}
		int layid=0;
		for(RelativeLayout lay:lays){
			lay.setOnClickListener(this);
			lay.setId(layid);
			layid++;
		}
	}
	
	
	//	事件初始化;
	private void initEvent(){
		
		context=VRAIncomeActivity.this;
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
	public int getRandom(int min,int max){
		return (int) Math.round(Math.random()*(max-min)+min);
	}

	@Override
	public void onClick(View view) {
		int nVid=view.getId();
		if(nVid<11){
			chooseMenuView.setIndex(nVid);
			chooseMenuView.dochoose();
			Toast.makeText(context, "收入"+(Math.random()*(nVid+1)*1000)+"元", Toast.LENGTH_SHORT).show();
		}
		switch (nVid) {
		case R.id.back:
			finish();
			break;
		default:
			break;
		}
	}
}
