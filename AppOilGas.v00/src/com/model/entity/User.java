package com.model.entity;

import java.util.ArrayList;

public class User {
	private String name;
	private String nickname;
	private String tel;
	private String address;
	private String info;
	private ArrayList<User> list;
	
	public User() {
		super();
	}
	public User(String name, String nickname, String tel, String address,
			String info) {
		super();
		this.name = name;
		this.nickname = nickname;
		this.tel = tel;
		this.address = address;
		this.info = info;
	}
	
	public void setTestInfo(){
		list=new ArrayList<User>();
		list.add(new User("克雷托司", "奎爷", "12345678901", "希腊-北欧-神坛周围或者一棵树下", "Sony第一代的游戏产品"));
		list.add(new User("阿卡柔斯", "奎爷儿子", "13385678901", "北欧-一棵树下", "Sony第一代的最新游戏产品中相应的角色"));
		list.add(new User("久石让", "作曲家", "12345612301", "爱住哪里住哪里", "作曲家"));
		list.add(new User("宫崎骏", "画家", "15545678901", "不知道住哪", "画画的"));
		list.add(new User("SONY", "电玩公司", "12345678901", "不知道在哪", "做游戏的单位"));
		list.add(new User("圣莫妮卡工作室", "做战神系列的公司", "13385678901", "北美里的美国", "战神系列公司的制作单位"));
		list.add(new User("联想", "作曲家", "12345612301", "爱住哪里住哪里", "作曲家"));
		list.add(new User("网易", "吃鸡单位", "15545678901", "不知道住哪", "画画的"));
		list.add(new User("小米", "米兔", "15545678901", "不知道住哪", "卖手机的"));
		list.add(new User("华为", "荣耀", "15590878001", "爱住哪是哪", "卖手机也想卖电脑"));
		list.add(new User("京东", "快递王", "12233332121", "可能在北京", "主要是卖东西"));
		list.add(new User("淘宝", "卖东西的", "15545893945", "阿里巴巴下边的", "主要是卖东西"));
		list.add(new User("天猫", "卖水果的", "15545672345", "不知道在哪里办公", "也是卖东西"));
		list.add(new User("宝马", "买车的", "15234578901", "应该在德国", "德国卖车的"));
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public ArrayList<User> getList() {
		return list;
	}
	public void setList(ArrayList<User> list) {
		this.list = list;
	}
}
