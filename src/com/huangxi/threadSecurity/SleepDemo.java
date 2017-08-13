package com.huangxi.threadSecurity;
/*注：在线程的run方法上不能使用throws来声明 抛出异常，只能在方法中使用try-catch来处理
 * 原因：子类覆盖父类的方法的原则，子类不能抛出新的异常，在Runnable接口中run方法，都没有声明抛出异常 
 * 
 */
public class SleepDemo {
public static void main(String[] args) throws Exception {
	System.out.println("begin...");
	for (int i = 5; i >=0; i--) {
		System.out.println("i="+i);
		Thread.sleep(1000);
		}
	System.out.println("ending...");
}
}
