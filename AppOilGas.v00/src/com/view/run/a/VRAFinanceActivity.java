package com.view.run.a;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.app.zhugeyang.R;
import com.model.entity.User;
import com.model.view.HomeDiagram;
import com.view.run.a.VRAHabitActivity.MyAdapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class VRAFinanceActivity extends Activity implements OnClickListener{
	private Context context;
	private TextView back,title,home;
	private ListView listInfos;
	private MyAdapter adapter;
	private User	 user;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_run_a_finance);
		//	初始化控件;
		initView();
		//	初始化事件;
		initEvent();
	}
	//	初始化控件;
	private void initView(){
		title	 =(TextView) findViewById(R.id.title);
		back 	 =(TextView) findViewById(R.id.back);
		listInfos=(ListView) findViewById(R.id.laytop);
	}
	//	初始化事件;
	private void initEvent(){
		context=VRAFinanceActivity.this;
		title.setText("财务分析报表");
		back.setText("< 返回");
		back.setOnClickListener(this);
		//
		home=(TextView) findViewById(R.id.home);
		home.setText("上传");
		home.setVisibility(View.VISIBLE);
		user=new User();
		user.setTestInfo();
		adapter=new MyAdapter(context, user.getList());
		listInfos.setAdapter(adapter);
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
}
