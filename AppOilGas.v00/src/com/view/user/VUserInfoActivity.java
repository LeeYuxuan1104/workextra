package com.view.user;

import com.app.zhugeyang.R;
import com.model.view.MenuAdapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class VUserInfoActivity extends Activity implements OnClickListener{
    private Context  context;
    private TextView back,home,title;
    private ListView listView;
    private String[] names=new String[]{"客户信息分类录入","客户消费积分","客户折扣分类","对应会员权限"};
    private MenuAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vuser_info);
        initView();
        initEvent();
    }
    private void initView(){
        context=VUserInfoActivity.this;
        back =(TextView) findViewById(R.id.back);
        home =(TextView) findViewById(R.id.home);
        title=(TextView) findViewById(R.id.title);
        listView=(ListView) findViewById(R.id.list);
    }
    private void initEvent(){
        title.setText("客户信息档案");
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
