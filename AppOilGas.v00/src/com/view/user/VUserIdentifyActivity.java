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

public class VUserIdentifyActivity extends Activity implements OnClickListener{
    private Context  context;
    private TextView back,home,title;
    private ListView listView;
    private String[] names=new String[]{"IC卡账户","车牌识别账户","车载屏账户","其他方式账户"};
    private MenuAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vuser_identify);
        initView();
        initEvent();
    }
    private void initView(){
        context=VUserIdentifyActivity.this;
        back =(TextView) findViewById(R.id.back);
        home =(TextView) findViewById(R.id.home);
        title=(TextView) findViewById(R.id.title);
        listView=(ListView) findViewById(R.id.list);
    }
    private void initEvent(){
        title.setText("客户身份识别");
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
