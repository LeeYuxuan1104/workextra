package com.model.view;

import com.app.zhugeyang.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MenuAdapter extends BaseAdapter{
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
					R.layout.act_second_item, null);

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
