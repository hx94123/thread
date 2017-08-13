package com.huangxi.threadSecurity;
//单例模式-饿汉式
public class ArrayUtil {
	private ArrayUtil(){
	}
	private static ArrayUtil instance=new ArrayUtil();
	public static ArrayUtil getInstance(){
		return instance;
	} 
	
	public void sort(int[] arr){
		//TODO
	}
}
