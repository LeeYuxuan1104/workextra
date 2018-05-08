package com.view;

import com.model.view.SlidingMenuView;

import com.app.zhugeyang.R;
import android.os.Bundle;
import android.app.ActivityGroup;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class VMenuActivity extends ActivityGroup implements OnClickListener{
	private Context context;
	private SlidingMenuView slidingMenuView;
	private ViewGroup tabcontent;
	private ListView listMenu;
	private String[] names = { "个人信息管理", "实名认证", "信息反馈", "关于我们" };
	private MenuAdapter adapter;
	private TextView btnexit;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_menu);
		// 初始化控件;
		initView();
		initEvent();
		showDefaultTab();
	}

	// 默认显示的tab页;
	void showDefaultTab() {
		Intent i = new Intent(this, VChooseActivity.class);
		View v = getLocalActivityManager().startActivity(
				VChooseActivity.class.getName(), i).getDecorView();
		tabcontent.removeAllViews();
		tabcontent.addView(v);
	}

	// 隐藏菜单;
	public void hideMenu(View view) {
		slidingMenuView.snapToScreen(1);
	}

	// 初始化空间;
	private void initView() {
		slidingMenuView = (SlidingMenuView) findViewById(R.id.sliding_menu_view);
		tabcontent = (ViewGroup) slidingMenuView
				.findViewById(R.id.sliding_body);
		listMenu   = (ListView) findViewById(R.id.listLeft);
		btnexit	   = (TextView) findViewById(R.id.btnexit);
	}

	// 初始化事件;
	private void initEvent() {
		context = VMenuActivity.this;
		adapter = new MenuAdapter(context, names);
		listMenu.setAdapter(adapter);
		btnexit.setOnClickListener(this);
		listMenu.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterview, View view, int position,
					long id) {
				String content="";
				switch (position) {
				case 0:
					content="个人信息管理";
					break;
				case 1:
					content="实名认证";
					break;
				case 2:
					content="信息反馈";
					break;
				case 3:
					content="关于我们";
					break;

				default:
					break;
				}
				Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
				
			}
		});
	}

	// 进行相应的适配器;
	public class MenuAdapter extends BaseAdapter {
		private Context mContext;
		private String[] names;;
		private int size = 0;

		public MenuAdapter(Context context, String[] names) {
			this.mContext = context;
			this.names = names;
			this.size = names.length;
		}

		@Override
		public int getCount() {
			return size;
		}

		@Override
		public Object getItem(int position) {
			return names[position];
		}

		@Override
		public long getItemId(int id) {
			return id;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			final ViewHolder viewHolder;
			// map映射的内容;
			String name = names[position];
			// 控件的内容;
			if (convertView == null) {
				viewHolder = new ViewHolder();
				convertView = LayoutInflater.from(mContext).inflate(
						R.layout.act_item, null);

				// 文本内容;
				viewHolder.tvorder = (TextView) convertView
						.findViewById(R.id.order);
				viewHolder.tvcontent = (TextView) convertView
						.findViewById(R.id.content);
				viewHolder.tvdetail = (TextView) convertView
						.findViewById(R.id.detail);

				convertView.setTag(viewHolder);
			} else {
				viewHolder = (ViewHolder) convertView.getTag();
			}
			int order = position + 1;
			String detail = ">";

			viewHolder.tvorder.setText(order + "");
			viewHolder.tvcontent.setText(name);
			viewHolder.tvdetail.setText(detail);

			return convertView;
		}

		// 对象类;
		private class ViewHolder {
			/** 序号文本 */
			private TextView tvorder;
			private TextView tvcontent;
			private TextView tvdetail;
		}

	}

	@Override
	public void onClick(View view) {
		int nVid=view.getId();
		switch (nVid) {
		case R.id.btnexit:
			Builder builder=new Builder(context);
			builder.setTitle("消息");
			builder.setMessage("确认退出?");
			builder.setPositiveButton(R.string.test_ok, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					Toast.makeText(context, R.string.test_gone, Toast.LENGTH_SHORT).show();
					finish();
				}
			});
			builder.setNegativeButton(R.string.test_no, null);
			builder.create();
			builder.show();
			break;

		default:
			break;
		}
		
	}
}
