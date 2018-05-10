package com.model.view;
import android.app.Activity;
import android.graphics.Color;
import android.widget.RelativeLayout;

public class ChooseMenuView extends Activity{
	// 承装布局的数组;
	private RelativeLayout[] lays;
	// 当前指定的角标;
	private int index = 0;
	// 长度大小;
	private int	size  = 0;
	
	public ChooseMenuView(RelativeLayout[] lays) {
		this.lays = lays;
		this.size = this.lays.length;
	}

	// 进行下角标的选择;
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}	
	
	public void dochoose() {
		for(int i=0;i<size;i++){
			RelativeLayout lay=lays[i];
			if(i==index){
				lay.setBackgroundColor((Color.parseColor("#8DB6CD")));
			}else lay.setBackgroundColor((Color.parseColor("#ffffff")));
		}
	}
}
