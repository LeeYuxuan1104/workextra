package com.view.user;

import com.app.zhugeyang.R;
import com.model.view.MenuAdapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class VUserPayActivity extends Activity implements OnClickListener{
    private Context  context;
    private TextView back,home,title;
    private ListView listView;
    private String[] names=new String[]{"IC卡支付","银联POS支付","第三方平台支付","APP支付","其他支付方式"};
    private MenuAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vuser_pay);
        initView();
        initEvent();
    }
    private void initView(){
        context=VUserPayActivity.this;
        back =(TextView) findViewById(R.id.back);
        home =(TextView) findViewById(R.id.home);
        title=(TextView) findViewById(R.id.title);
        listView=(ListView) findViewById(R.id.list);
    }
    private void initEvent(){
        title.setText("客户消费支付");
        back.setText("< 返回");
        home.setText("主页");
        back.setOnClickListener(this);
        home.setOnClickListener(this);
        adapter=new MenuAdapter(context, names);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,names[position],Toast.LENGTH_SHORT).show();
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
