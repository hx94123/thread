package com.huangxi.extends_vs_implements;
//使用实现Runnable接口方式来实现三个同学吃50个苹果的比赛

class Apple implements Runnable{
	private int num=50;
	
	public void run() {
		for(int i=0;i<50;i++){
			if(num>0){
				/*try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				线程安全问题：添加sleep方法使本来的问题更加明显，并不是使用了sleep方法后才出现问题，是本身就存在的
				我们发现结果中不同的线程吃了同一个苹果
				如：小A吃了编号为50的苹果
				小B吃了编号为49的苹果
				小C吃了编号为50的苹果
				...
				小A吃了编号为1的苹果        由于此时ABC都已经进入if(num>0) 拿到的都是1
				小B吃了编号为0的苹果
				小C吃了编号为-1的苹果
				
				打印操作和num--应该是一个原子操作，不能分割，导致上述问题,所以必须同步操作！！！
				*/
				System.out.println(Thread.currentThread().getName()+"吃了编号为"+num+"的苹果");//使用实现方式使用Thread.currentThread().getName() 获取进程名称
				num--;
			}
		}
		/*static Thread currentThread() 
          	返回对当前正在执行的线程对象的引用。 
		 * */
		
	}
	
}


public class ImplementsDemo {
public static void main(String[] args) {
	//创建三个线程（同学），吃苹果
	Apple a=new Apple();
	new Thread(a,"小A").start();
	new Thread(a,"小B").start();
	new Thread(a,"小C").start();
	//观察结果发现使用实现Runnable方式来实现ABC一共吃了50个苹果，因为只创建了一个苹果对象，创建三个线程共享了一个Apple对象 
	 
	
	/*new Thread(new Apple()).start();
	 * new Thread(new Apple()).start();
	 * new Thread(new Apple()).start();
	 * 如果这么写会发现每个人都吃了50个苹果，因为创建了三个苹果对象
	 * */
}
}
