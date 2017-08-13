package com.huangxi.threadSecurity;

import java.util.concurrent.locks.ReentrantLock;

/*Lock�ӿڣ�����ʹ�� ����ʵ����ReentrantLock������������
 * 
 * class X {
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
 * 
 *  void lock() 
          ��ȡ���� 
 	void lockInterruptibly() 
          �����ǰ�߳�δ���жϣ����ȡ���� 
 	Condition newCondition() 
          ���ذ󶨵��� Lock ʵ������ Condition ʵ���� 
 	boolean tryLock() 
          ���ڵ���ʱ��Ϊ����״̬�Ż�ȡ������ 
 	boolean tryLock(long time, TimeUnit unit) 
          ������ڸ����ĵȴ�ʱ���ڿ��У����ҵ�ǰ�߳�δ���жϣ����ȡ���� 
 	void unlock() 
          �ͷ����� 

 * */

class Apple3 implements Runnable{
	private int num=50;
	private final ReentrantLock lock=new ReentrantLock();//����һ��������
	
	public void run() {
		for(int i=0;i<50;i++){
			eat();
		}
	}
	
	private void eat(){
		//���뷽���������
		lock.lock();//��ȡ��
		try {
			if(num>0){
				Thread.sleep(10);//ģ�������ӳ�
				System.out.println(Thread.currentThread().getName()+"���˱��Ϊ"+num+"��ƻ��");//ʹ��ʵ�ַ�ʽʹ��Thread.currentThread().getName() ��ȡ��������
				num--;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();//�ͷ���
		}
		
	}
}
public class LockDemo {
public static void main(String[] args) {
	Apple3 a = new Apple3();
	new Thread(a, "СA").start();
	new Thread(a, "СB").start();
	new Thread(a, "СC").start();
}
}
