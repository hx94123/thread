package com.huangxi.threadSecurity;
class Apple2 implements Runnable {
	private int num = 50;

	public void run() {
		for (int i = 0; i < 50; i++) {
				eat();
			}	
	}
	
	synchronized private void eat(){//此时的同步监听器就是Apple2的对象
		if (num > 0) {
			try {
				Thread.sleep(10);//模拟网络延迟
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "吃了编号为"+ num + "的苹果");// 使用实现方式使用Thread.currentThread().getName()获取进程名称			
			num--;
		}
	}
}
public class SynMethodDemo {
public static void main(String[] args) {
	Apple2 a = new Apple2();
	new Thread(a, "小A").start();
	new Thread(a, "小B").start();
	new Thread(a, "小C").start();
}
}
