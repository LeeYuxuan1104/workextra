package com.view;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.lyz.gallery.activity.ImageAdapter;
import com.model.view.ChooseMenuView;
import com.model.view.GalleryFlow;

import com.app.zhugeyang.R;
import android.os.Bundle;
import android.os.Handler;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class VChooseActivity extends Activity implements OnClickListener{
	private Context		    mContext;
	/*上端框架的处理*/
	// 记录上一次点的位置
	private int     		oldPosition = 0;
	private ViewPager 		mViewPaper;
	private int 		    currentItem;
	// 存放图片的id
	private int[]    		titleIds   = new int[] { R.drawable.a, R.drawable.b,R.drawable.c, R.drawable.d, R.drawable.e };
	private String[] 	    titleNames = new String[] { "巩俐不低俗，我就不能低俗","扑树又回来啦！再唱经典老歌引万人大合唱", "揭秘北京电影如何升级", "乐视网TV版大派送", "热血屌丝的反杀" };
	private List<ImageView> titleImages;
	private List<View> 		titleDots;
	private TextView 		tvTitle;
	private ViewPagerAdapter vpAdapter;
	private ScheduledExecutorService scheduledExecutorService;
	
	/*中间按钮的布局*/	
	// 布局的列表;
	private RelativeLayout layrun,laydevice,laycustomer,laytrans;
	private ChooseMenuView chooseMenuView;
	private RelativeLayout[] lays;
	
	/*下端框架的处理*/
	//	下方列表;
	private GalleryFlow    gallery_flow;
	//构造存放图片id的数组
	private int[] 		   imageIds = null;
	//存放图片id的数组
	private ImageAdapter   imageAdapter=null;
	private int 		   index	= 0;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_main_menu);
		//	初始化控件;
		initView();
		//	初始化事件;
		initEvent();
	}
	//	初始化控件;
	private void initView(){
		//	上方控件的初始化;
		mViewPaper = (ViewPager) findViewById(R.id.vp);
		tvTitle    = (TextView) findViewById(R.id.title);
		//	管理按钮的初始化;
		layrun	   = (RelativeLayout) findViewById(R.id.run);
		laydevice  = (RelativeLayout) findViewById(R.id.device);
		laycustomer= (RelativeLayout) findViewById(R.id.customer);
		laytrans   = (RelativeLayout) findViewById(R.id.trans);
		//	下边的按钮;
		gallery_flow = (GalleryFlow) findViewById(R.id.gallery_flow);

	}
	//	事件初始化;
	private void initEvent(){
		mContext   = VChooseActivity.this;
		// 上方控件初始化
		titleImages= new ArrayList<ImageView>();
		int size   = titleIds.length;
		for(int i=0;i<size;i++){
			ImageView imageView = new ImageView(this);
			imageView.setBackgroundResource(titleIds[i]);
			titleImages.add(imageView);
		}
		titleDots  = new ArrayList<View>();
		titleDots.add(findViewById(R.id.dot_0));
		titleDots.add(findViewById(R.id.dot_1));
		titleDots.add(findViewById(R.id.dot_2));
		titleDots.add(findViewById(R.id.dot_3));
		titleDots.add(findViewById(R.id.dot_4));
		//	初始化名称;
		tvTitle.setText(titleNames[0]);
		vpAdapter  = new ViewPagerAdapter(titleImages);
		mViewPaper.setAdapter(vpAdapter);
		
		//	管理按钮的布局;
		lays	   = new RelativeLayout[4];
		lays[0]	   = layrun;
		lays[1]	   = laydevice;
		lays[2]	   = laycustomer;
		lays[3]	   = laytrans;
		chooseMenuView=new ChooseMenuView(lays);
		chooseMenuView.setIndex(0);
		chooseMenuView.dochoose();
		///////////////////////////
		index		 = 0;
		imageIds	 = new int[]{R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6,R.drawable.a7};
		imageAdapter = new ImageAdapter(mContext, imageIds);
		imageAdapter.createRefectedBitmap();
		gallery_flow.setAdapter(imageAdapter);
		
		layrun.setOnClickListener(this);
		laydevice.setOnClickListener(this);
		laycustomer.setOnClickListener(this);
		laytrans.setOnClickListener(this);
		mViewPaper.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				tvTitle.setText(titleNames[position]);
				titleDots.get(position).setBackgroundResource(R.drawable.dot_focused);
				titleDots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);

				oldPosition = position;
				currentItem = position;
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
		
		//	进行相应数据的选择;
		gallery_flow.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int position,
					long id) {
				String str="";
				switch (index) {
				case 0:
					switch (position) {
					case 0:
						str="经营分析";
						
						break;
					case 1:
						str="进销存管理";
						break;
					case 2:
						str="PLC控制系统管理";
						break;
					case 3:
						str="员工管理";
						break;
					case 4:
						str="财务对账";
						break;
					case 5:
						str="交接班管理";
						break;
					case 6:
						str="单价、折返";
						break;

					default:
						break;
					}
					break;
				case 1:
					switch (position) {
					case 0:
						str="安全管理";
						
						break;
					case 1:
						str="消耗、更新";
						break;
					case 2:
						str="智能诊断";
						break;
					default:
						break;
					}
					break;
				case 2:
					switch (position) {
					case 0:
						str="客户信息档案";
						
						break;
					case 1:
						str="客户身份识别";
						break;
					case 2:
						str="客户消费支付";
						break;
					default:
						break;
					}
					break;
				case 3:
					switch (position) {
					case 0:
						str="LNG加气机数据记录";
						
						break;
					case 1:
						str="CNG加油机数据记录";
						break;
					case 2:
						str="加油机数据记录";
						break;
					default:
						break;
					}
					break;

				default:
					break;
				}
				Toast.makeText(mContext, str, Toast.LENGTH_SHORT).show();
			}
		});
		
	}
	
	
	//	页面的适配器;
	public class ViewPagerAdapter extends PagerAdapter {

		private int size;
		private List<ImageView> titleImages;
		
		public ViewPagerAdapter(List<ImageView> titleImages) {
			this.titleImages=titleImages;
			this.size=this.titleImages.size();
		}
		
		@Override
		public int getCount() {
			return size;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

		@Override
		public void destroyItem(ViewGroup view, int position, Object object) {
			view.removeView(titleImages.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup view, int position) {
			view.addView(titleImages.get(position));
			return titleImages.get(position);
		}
	}

	/**
	 * 利用线程池定时执行动画轮播
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutorService.scheduleWithFixedDelay(new ViewPageTask(), 2,2, TimeUnit.SECONDS);
	}

	private class ViewPageTask implements Runnable {

		@Override
		public void run() {
			currentItem = (currentItem + 1) % titleIds.length;
			mHandler.sendEmptyMessage(0);
		}
	}

	/**
	 * 接收子线程传递过来的数据
	 */
	@SuppressLint("HandlerLeak")
	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			mViewPaper.setCurrentItem(currentItem);
		};
	};

	@Override
	protected void onStop() {
		super.onStop();
	}
	@Override
	public void onClick(View view) {
		int nVid=view.getId();
		switch (nVid) {
		case R.id.run:
			index		 = 0;
			imageIds	 = new int[]{R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6,R.drawable.a7};
			break;
		case R.id.device:
			index		 = 1;
			imageIds	 = new int[]{R.drawable.b1,R.drawable.b2,R.drawable.b3};
			break;
		case R.id.customer:
			index		 = 2;
			imageIds	 = new int[]{R.drawable.c1,R.drawable.c2,R.drawable.c3};
			break;
		case R.id.trans:
			index		 = 3;
			imageIds	 = new int[]{R.drawable.d1,R.drawable.d2,R.drawable.d3};
			break;
		default:
			break;
		}
		chooseMenuView.setIndex(index);
		chooseMenuView.dochoose();
		imageAdapter 	 = new ImageAdapter(mContext, imageIds);
		imageAdapter.createRefectedBitmap();
		gallery_flow.setAdapter(imageAdapter);
	}
}
