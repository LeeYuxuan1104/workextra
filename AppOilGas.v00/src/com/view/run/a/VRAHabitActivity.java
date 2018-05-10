package com.view.run.a;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.app.zhugeyang.R;
import com.model.entity.User;
import com.model.view.ChooseMenuView;
import com.model.view.HomeDiagram;
import com.view.VDiagActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class VRAHabitActivity extends Activity implements OnClickListener{
	private Context context;
	private TextView back,title;
	private ListView listInfos;
	private MyAdapter adapter;
	private User	 user;
	private RelativeLayout lay0,lay1,lay2;
	private RelativeLayout[] lays;
	private ChooseMenuView chooseMenuView;
	private RelativeLayout linear;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_run_a_habit);
		//	初始化控件;
		initView();
		//	初始化事件;
		initEvent();
	}
	//	初始化控件;
	private void initView(){
		back=(TextView) findViewById(R.id.back);
		title=(TextView) findViewById(R.id.title);
		listInfos=(ListView) findViewById(R.id.laytop);
		lay0=(RelativeLayout) findViewById(R.id.lay1);
		lay1=(RelativeLayout) findViewById(R.id.lay2);
		lay2=(RelativeLayout) findViewById(R.id.lay3);
	}
	//	初始化事件;
	private void initEvent(){
		context=VRAHabitActivity.this;
		title.setText("客户消费习惯");
		back.setText("< 返回");
		back.setOnClickListener(this);
		user=new User();
		user.setTestInfo();
		adapter=new MyAdapter(context, user.getList());
		listInfos.setAdapter(adapter);
		lays=new RelativeLayout[3];
		lays[0]=lay0;
		lays[1]=lay1;
		lays[2]=lay2;
		chooseMenuView=new ChooseMenuView(lays);
		chooseMenuView.setIndex(0);
		chooseMenuView.dochoose();
		int index=0;
		for(RelativeLayout lay:lays){
			lay.setOnClickListener(this);
			lay.setId(index);
			index++;
		}
		//	列表的加载;
		listInfos.setOnItemClickListener(new OnItemClickListener() {

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
		//	进行图像加载;
		setChart();
	}
	@Override
	public void onClick(View view) {
		int nVid=view.getId();
		if(nVid<3){
			chooseMenuView.setIndex(nVid);
			chooseMenuView.dochoose();
			linear.removeAllViews();
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
	public class MyAdapter extends BaseAdapter{

		private Context context;
		private ArrayList<User> list;
		private int 	size;
		public MyAdapter(Context context,ArrayList<User> list) {
			this.context=context;
			this.list=list;
			this.size=this.list.size();
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return size;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return list.get(position);
		}

		@Override
		public long getItemId(int id) {
			// TODO Auto-generated method stub
			return id;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			final ViewHolder viewHolder;
			User   user=list.get(position);
			// map映射的内容;
			String nickname=user.getNickname();
			String tel=user.getTel();
			// 控件的内容;
			if (convertView == null) {
				viewHolder = new ViewHolder();
				convertView = LayoutInflater.from(context).inflate(R.layout.act_item_table, null);

				// 文本内容;
				viewHolder.tv1 = (TextView) convertView.findViewById(R.id.txt1);
				viewHolder.tv2 = (TextView) convertView.findViewById(R.id.txt2);
				viewHolder.tv3 = (TextView) convertView.findViewById(R.id.txt3);

				convertView.setTag(viewHolder);
			} else {
				viewHolder = (ViewHolder) convertView.getTag();
			}

			viewHolder.tv1.setText(nickname);
			viewHolder.tv2.setText(tel);
			
			DecimalFormat df = new DecimalFormat("0.00");
			String s=String.valueOf(Math.random()*1000*5);
			viewHolder.tv3.setText(df.format(Double.valueOf(s))+"元");

			return convertView;
		}
		// 对象类;
		private class ViewHolder {
			/** 序号文本 */
			private TextView tv1;
			private TextView tv2;
			private TextView tv3;
		}
	}
	private void setChart(){
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
}
