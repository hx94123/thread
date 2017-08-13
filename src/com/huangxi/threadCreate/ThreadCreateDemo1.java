package com.huangxi.threadCreate;
/*创建和启动线程两种传统的方式：
 * （1）继承Thread类
 * 		1)定义一个类继承Thread类
 * 		2）在类中覆盖Thread类中的run方法
 * 		3）在run方法里编写需要执行的操作
 * 		4）在main方法中 创建线程对象，并启动线程（调用start方法，底层会调用run方法），千万不要直接调用run方法，因为这好比是对象调用方法，依然还是一个线程
 *Thread其实是实现Runnable接口的
 * 注：主线程（main方法运行）
 * 
 * */
class MusicThread extends Thread{
	public void run() {
		for(int i=0;i<50;i++){
			System.out.println("播放音乐"+i);
		}
	}
}

public class ThreadCreateDemo1 {
	public static void main(String[] args) {
		//主线程，运行游戏
		for(int i=0;i<50;i++){
			System.out.println("打游戏"+i);
			if(i==10){
				//创建播放音乐线程
				Thread thread=new MusicThread();
				thread.start();
			}
		}
	}
}
