package com.huangxi.threadSecurity;

/*��ʽ1��ͬ�������
 * 		synchronized(syncObject){
 * 			��Ҫͬ�������Ĵ���
 * 		}
 * -----------------------------------------
 *��ʽ2��ͬ������
 *		ʹ��synchronized���εķ�������֤A�߳�ִ�и÷�����ʱ�������߳�ֻ���ڷ��������
 *		synchronized public void doWork(){
 *		//TODO
 *		}
 *		!!!ͬ������˭�����ڷ�static������syncObject����this������static����������ʹ�õ�ǰ������������ֽ������(Apple.class)
 *		��Ҫʹ��synchronizedȥ����run��������Ϊ����֮��ĳһ���߳̾�ִ�������еĹ��ܣ���A�������е�50��ƻ��
 *		�����ʽ������Ҫͬ�������Ĵ��붨����һ���µķ����в���synchronized���Σ�����run�����е��� 
 *-------------------------------------------
 *��ʽ3�������ƣ�Lock��
 *		Lock�����ṩ�˱�ͬ��������ͬ���������㷺������������ͬ��������ͬ���������еĹ���Lock���У�����֮���ǿ�󣬸������������
 *		Lock�ǽӿڣ�����ʹ�� ����ʵ����ReentrantLock������������
 *		�������� ����ʵ����ʹ�� lock �������� try����֮ǰ/֮��Ĺ����У�����͵Ĵ������£� 

 class X {
   private final ReentrantLock lock = new ReentrantLock();
   // ...

   public void m() { //��Ҫͬ�������ķ���
     lock.lock();  // block until condition holds
     try {
       // ... method body
     } finally {
       lock.unlock()
     }
   }
 }

 *------------------------------------------
 *ͬ������Ϊ�˱�֤ÿ���̶߳�������ִ��ԭ�Ӳ���
 *		 ͬ����������/ͬ����/ͬ��������/������
 *		 �����ͬ����ֻ��һ�������������Ϊ�ڸö����ϱ����һ����,�������ΪsyncObject
 *		java�������п���ʹ���κζ�����Ϊͬ���������󣬵���һ�������ʵ�鵱ǰ�������ʵĹ�ͬ��Դ��Ϊͬ����������
 *		 ע�����κ�ʱ���������һ���߳�ӵ��ͬ������˭�õ����ͽ������飬�������߳�ֻ�ܵȴ� 
 * 
 * ע��ʹ��synchronized�Զ���ȡ���ͷ�����ʹ��Lock�����ֶ�
 * */

class Apple1 implements Runnable {
	private int num = 50;

	public void run() {
		for (int i = 0; i < 50; i++) {
			synchronized (this) {////thisָa,��ʾApple1���󣬸ö������ڶ��̹߳������Դ�����ܸĳ�num����Ϊnumһֱ�ڱ�
				if (num > 0) {
					try {
						Thread.sleep(10);//ģ�������ӳ�
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "���˱��Ϊ"+ num + "��ƻ��");// ʹ��ʵ�ַ�ʽʹ��Thread.currentThread().getName()��ȡ��������			
					num--;
				}
			}	
		}
	}
}

public class SynBlockDemo {
	public static void main(String[] args) {
		Apple1 a = new Apple1();
		new Thread(a, "СA").start();
		new Thread(a, "СB").start();
		new Thread(a, "СC").start();
	}
}
