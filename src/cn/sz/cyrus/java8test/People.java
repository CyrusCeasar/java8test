package cn.sz.cyrus.java8test;

import java.util.Random;

public class People {
	private String name;
	private int age;
	
	public People(){
		name = "people"+hashCode();
		
	}
	public People(String name){
		this.name = name;
		age = new Random().nextInt(100);
	}
	
	public String getName(){
		return name;
	}
}
