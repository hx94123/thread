package com.huangxi.threadCreate;
/*（2）实现Runnable接口
 * 		1)定义一个类A实现Runnable接口 ，注意类A不是线程类
 * 		2）在类中覆盖Runnable接口中的run方法
 * 		3）在run方法里编写需要执行的操作
 * 		4）在main方法中 创建线程对象，并启动线程
 * 			Thread thread=new Thread(new A());
 * 			thread.statrt();
 * */

class MusicThread2 implements Runnable{
	public void run() {
		for(int i=0;i<50;i++){
			System.out.println("播放音乐"+i);
		}
	}
}
public class ThreadCreateDemo2 {
	public static void main(String[] args) {
		//主线程，运行游戏
		for(int i=0;i<50;i++){
			System.out.println("打游戏"+i);
			if(i==10){
				//创建播放音乐线程
				Runnable target =new MusicThread2();
				Thread thread=new Thread(target);
				thread.start();
			}
		}
	}
}
