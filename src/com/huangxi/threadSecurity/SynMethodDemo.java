package com.huangxi.threadSecurity;
class Apple2 implements Runnable {
	private int num = 50;

	public void run() {
		for (int i = 0; i < 50; i++) {
				eat();
			}	
	}
	
	synchronized private void eat(){//��ʱ��ͬ������������Apple2�Ķ���
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
public class SynMethodDemo {
public static void main(String[] args) {
	Apple2 a = new Apple2();
	new Thread(a, "СA").start();
	new Thread(a, "СB").start();
	new Thread(a, "СC").start();
}
}
