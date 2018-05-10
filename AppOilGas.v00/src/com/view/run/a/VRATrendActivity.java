package com.view.run.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.zhugeyang.R;
import com.model.entity.User;
import com.model.view.ChooseMenuView;
import com.model.view.HomeColumnar;
import com.model.view.MenuAdapter;
import com.model.view.Score;
import com.view.VDiagActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class VRATrendActivity extends Activity implements OnClickListener{
	private Context context;
	private TextView back,title;
	private RelativeLayout pillars;
	private RelativeLayout lay0,lay1,lay2;
	private ChooseMenuView chooseMenuView;
	private RelativeLayout[] lays;
	private User user;
	private ListView listUsers;
	private MenuAdapter menuAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_run_a_trend);
		//	初始化控件;
		initView();
		//	初始化事件;
		initEvent();
	}
	//	初始化控件;
	private void initView(){
		back=(TextView) findViewById(R.id.back);
		title=(TextView) findViewById(R.id.title);
		lay0=(RelativeLayout) findViewById(R.id.lay1);
		lay1=(RelativeLayout) findViewById(R.id.lay2);
		lay2=(RelativeLayout) findViewById(R.id.lay3);
		//	设置相应的列表信息;
		listUsers=(ListView) findViewById(R.id.laytop);
	}
	@SuppressWarnings("rawtypes")
	private String[] loadData(User user){
		ArrayList<User> list= user.getList();
		int size=list.size();
		String[] names=new String[size];
		Iterator iterator=list.iterator();
		int index=0;
		while(iterator.hasNext()){
			User item=(User) iterator.next();
			String nickname=item.getNickname();
			names[index]=nickname;
			index++;
		}
		return names;
	}
	
	
	//	初始化事件;
	private void initEvent(){
		context = VRATrendActivity.this;
		//	设置相应的对象信息;
		user	= new User();
		user.setTestInfo();
		menuAdapter=new MenuAdapter(context, loadData(user));
		listUsers.setAdapter(menuAdapter);
		//	基本控件的内容添加;
		title.setText("客户消费趋势变化分析");
		back.setText("< 返回");
		back.setOnClickListener(this);
		//	进行数据的样式添加;
		lays=new RelativeLayout[3];
		lays[0]=lay0;
		lays[1]=lay1;
		lays[2]=lay2;
		chooseMenuView=new ChooseMenuView(lays);
		chooseMenuView.setIndex(0);
		chooseMenuView.dochoose();
		int layid=0;
		for(RelativeLayout lay:lays){
			lay.setOnClickListener(this);
			lay.setId(layid);
			layid++;
		}
		//	设置图形;
		setChart();
		//	进行相应的数据的查询;
		listUsers.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int position,
					long id) {
				Intent 			intent	=	new Intent(context, VDiagActivity.class);
				ArrayList<User> list	=	user.getList();
				User			item	=	list.get(position);
				String 			nickname=	item.getNickname();
				String			tel		=	item.getTel();
				String 			address =	item.getAddress();
				String 			info	=	item.getInfo();
				
				Bundle bundle=new Bundle();
				bundle.putString("id",Math.random()*(position+1)*1000+"");
				
				String string		 =
				"昵称  " +nickname+"\r\n"+
				"电话  " +tel+"\r\n" +
				"地址  " +address+"\r\n" +
				"备注  " +info;
				
				bundle.putString("content",string);
				intent.putExtras(bundle);
				context.startActivity(intent);
				
			}
		});
	}
	public int getRandom(int min,int max){
		return (int) Math.round(Math.random()*(max-min)+min);
	}
	private void setChart(){
		//
		List<Score> list = new ArrayList<Score>();//柱状图  范围10-100
		for (int i = 0; i < 28; i++) {
			Score s = new Score();
			s.date = "2013-10-" + i;
			s.score = getRandom(10,100);
			list.add(s);
		}
		pillars= (RelativeLayout) findViewById(R.id.pillars);
		pillars.addView(new HomeColumnar(this,list));
	}
	
	@Override
	public void onClick(View view) {
		int nVid=view.getId();
		if(nVid<3){
			chooseMenuView.setIndex(nVid);
			chooseMenuView.dochoose();
			pillars.removeAllViews();
			setChart();
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
