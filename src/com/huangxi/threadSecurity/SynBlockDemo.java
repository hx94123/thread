package com.huangxi.threadSecurity;

/*方式1：同步代码块
 * 		synchronized(syncObject){
 * 			需要同步操作的代码
 * 		}
 * -----------------------------------------
 *方式2：同步方法
 *		使用synchronized修饰的方法，保证A线程执行该方法的时候，其他线程只能在方法外等着
 *		synchronized public void doWork(){
 *		//TODO
 *		}
 *		!!!同步锁是谁：对于非static方法，syncObject就是this；对于static方法，我们使用当前方法所在类的字节码对象(Apple.class)
 *		不要使用synchronized去修饰run方法，因为修饰之后某一个线程就执行了所有的功能，如A吃了所有的50个苹果
 *		解决方式：把需要同步操作的代码定义在一个新的方法中并用synchronized修饰，并在run方法中调用 
 *-------------------------------------------
 *方式3：锁机制（Lock）
 *		Lock机制提供了比同步代码块和同步方法更广泛的锁定操作，同步代码块和同步方法具有的功能Lock都有，除此之外更强大，更体现面向对象
 *		Lock是接口，我们使用 它的实现类ReentrantLock（可重入锁）
 *		建议总是 立即实践，使用 lock 块来调用 try，在之前/之后的构造中，最典型的代码如下： 

 class X {
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

 *------------------------------------------
 *同步锁：为了保证每个线程都能正常执行原子操作
 *		 同步监听对象/同步锁/同步监听器/互斥锁
 *		 对象的同步锁只是一个概念，可以想象为在该对象上标记了一个锁,可以理解为syncObject
 *		java程序运行可以使用任何对象作为同步监听对象，但是一般地我们实验当前并发访问的共同资源作为同步监听对象
 *		 注：在任何时候，最多允许一个线程拥有同步锁，谁拿到锁就进入代码块，其他的线程只能等待 
 * 
 * 注：使用synchronized自动获取和释放锁，使用Lock则需手动
 * */

class Apple1 implements Runnable {
	private int num = 50;

	public void run() {
		for (int i = 0; i < 50; i++) {
			synchronized (this) {////this指a,表示Apple1对象，该对象属于多线程共享的资源，不能改成num，因为num一直在变
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
	}
}

public class SynBlockDemo {
	public static void main(String[] args) {
		Apple1 a = new Apple1();
		new Thread(a, "小A").start();
		new Thread(a, "小B").start();
		new Thread(a, "小C").start();
	}
}
