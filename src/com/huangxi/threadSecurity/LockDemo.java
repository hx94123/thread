package com.huangxi.threadSecurity;

import java.util.concurrent.locks.ReentrantLock;

/*Lock接口：我们使用 它的实现类ReentrantLock（可重入锁）
 * 
 * class X {
   private final ReentrantLock lock = new ReentrantLock();
   // ...

   public void m() { //需要同步操作的方法
     lock.lock();  // block until condition holds
     try {
       // ... method body
     } finally {
       lock.unlock()
     }
   }
 }
 * 
 *  void lock() 
          获取锁。 
 	void lockInterruptibly() 
          如果当前线程未被中断，则获取锁。 
 	Condition newCondition() 
          返回绑定到此 Lock 实例的新 Condition 实例。 
 	boolean tryLock() 
          仅在调用时锁为空闲状态才获取该锁。 
 	boolean tryLock(long time, TimeUnit unit) 
          如果锁在给定的等待时间内空闲，并且当前线程未被中断，则获取锁。 
 	void unlock() 
          释放锁。 

 * */

class Apple3 implements Runnable{
	private int num=50;
	private final ReentrantLock lock=new ReentrantLock();//创建一个锁对象
	
	public void run() {
		for(int i=0;i<50;i++){
			eat();
		}
	}
	
	private void eat(){
		//进入方法立马加锁
		lock.lock();//获取锁
		try {
			if(num>0){
				Thread.sleep(10);//模拟网络延迟
				System.out.println(Thread.currentThread().getName()+"吃了编号为"+num+"的苹果");//使用实现方式使用Thread.currentThread().getName() 获取进程名称
				num--;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();//释放锁
		}
		
	}
}
public class LockDemo {
public static void main(String[] args) {
	Apple3 a = new Apple3();
	new Thread(a, "小A").start();
	new Thread(a, "小B").start();
	new Thread(a, "小C").start();
}
}
