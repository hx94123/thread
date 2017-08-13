package com.huangxi.threadCreate;
//使用匿名内部类创建线程（只适用于某个类只使用一次）
public class ThreadCreateDemo3 {
	public static void main(String[] args) {
		//主线程，运行游戏
		for(int i=0;i<50;i++){
			System.out.println("打游戏"+i);
			if(i==10){
				//使用匿名内部类创建播放音乐线程
				
				//使用接口，底层同方法2，较多
				new Thread(new Runnable(){
					public void run() {
						for(int i=0;i<50;i++){
							System.out.println("播放音乐"+i);
						}	
					}	
				}).start();
				
				//使用类，底层同方法1，较少
				new Thread(){
					public void run() {
						for(int i=0;i<50;i++){
							System.out.println("看电影"+i);
						}	
					}
				}.start();
				
			}
		}
	}
}
