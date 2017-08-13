package com.huangxi.why;
/*进程与线程的区别：
 * 进程：有独立的内存空间，进程中的数据存放空间（堆空间和 栈空间）是独立的，至少有一个线程，因此进程间的通信非常麻烦
 * 线程：堆空间是共享的，栈空间是独立的，线程消耗的资源也比进程小，相互之间可以影响的，又称为轻型进程或进程元
 * 因为一个线程中的多个线程是并发运行的，那么从微观角度上考虑也是有先后顺序的，那么哪个线程执行完全取决于CPU调度器（java中是JVM），程序员是控制不了的
 * 我们可以把多线程并发性看成是多个线程在瞬间抢CPU资源，谁抢到资源谁就运行，这也就造成了多线程的随机性
 * Java程序的进程里至少要包含主线程和垃圾回收线程,JVM采用的是抢占式调度
 * */
public class GameDemo {
public static void main(String[] args) {
	//先打完游戏，再播放音乐
	System.out.println("begin...");
	playGame();
	playMusic();
	System.out.println("end...");
}

private static void playMusic() {
for(int i=0;i<50;i++){
		System.out.println("播放音乐"+i);
		
	}
	
}

private static void playGame() {
	for(int i=0;i<50;i++){
		System.out.println("打游戏"+i);
		
	}
	
}
}
