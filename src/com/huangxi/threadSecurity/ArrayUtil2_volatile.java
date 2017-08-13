package com.huangxi.threadSecurity;
//单例模式-懒汉式
//懒加载存在线程不安全问题,需要同步！
public class ArrayUtil2_volatile {
	private ArrayUtil2_volatile(){
	}
	private static volatile ArrayUtil2_volatile instance=null;
	
	/*
	//同步方法，该方法是静态方法，同步监听对象是（ArrayUtil2_volatile.class）
	synchronized public static ArrayUtil2_volatile getInstance(){
		//A B在等
		if(instance==null){
			//C进入
			instance=new ArrayUtil2();
		}
		return instance;
	} //上述代码使用同步方法，已经解决了懒汉式的线程安全问题，但是synchronized的作用域太大了 ，损耗性能，需要尽量减小作用域
	//使用同步代码块亦是如此！
	 */
	
	
	/*解决线程安全问题且能够使性能不受太大的影响，我们使用“双重检查加锁”机制.
	 * 它指的是：并不是每次进入getInstance方法都需要同步，而是先不同步，进入方法后，先检查实例是否存在，如果不存在才进行下面的同步块，
	 * 			这是第一重检查，进入同步块后，再次检查实例是否存在，如果不存在，就在同步的 情况下创建一个实例，这是第二重检查。这样一
	 * 			来，就只需要同步一次了，从而减少了多次在同步情况下进行判断所浪费的时间
	 *“双重检查加锁”机制的实现使用关键字volatile，它的意思是：被volatile修饰的变量的值，将不会被本地线程缓存，所有对该变量的读写都是
	 *				直接操作共享内存，从而确保多个线程能正确处理该变量
	 *注意：只在java5以后使用，但是由于volatile关键字可能会屏蔽掉虚拟机中一些必要的代码优化，所以运行效率不是很高。因此一般建议，没有
	 *		特别的要求不要使用。所以单例模式推荐使用饿汉式写法，简单、安全、粗暴。
	 */
	
	 public static ArrayUtil2_volatile getInstance(){
		
		if(instance==null){
			//A B
			synchronized (ArrayUtil2_volatile.class) {
				if(instance==null){
					instance=new ArrayUtil2_volatile();
				}
			}
		}
		return instance;
	} 
	public void sort(int[] arr){
		//TODO
	}
}
