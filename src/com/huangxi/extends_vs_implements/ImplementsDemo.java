package com.huangxi.extends_vs_implements;
//ʹ��ʵ��Runnable�ӿڷ�ʽ��ʵ������ͬѧ��50��ƻ���ı���

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
				�̰߳�ȫ���⣺���sleep����ʹ����������������ԣ�������ʹ����sleep������ų������⣬�Ǳ���ʹ��ڵ�
				���Ƿ��ֽ���в�ͬ���̳߳���ͬһ��ƻ��
				�磺СA���˱��Ϊ50��ƻ��
				СB���˱��Ϊ49��ƻ��
				СC���˱��Ϊ50��ƻ��
				...
				СA���˱��Ϊ1��ƻ��        ���ڴ�ʱABC���Ѿ�����if(num>0) �õ��Ķ���1
				СB���˱��Ϊ0��ƻ��
				СC���˱��Ϊ-1��ƻ��
				
				��ӡ������num--Ӧ����һ��ԭ�Ӳ��������ָܷ������������,���Ա���ͬ������������
				*/
				System.out.println(Thread.currentThread().getName()+"���˱��Ϊ"+num+"��ƻ��");//ʹ��ʵ�ַ�ʽʹ��Thread.currentThread().getName() ��ȡ��������
				num--;
			}
		}
		/*static Thread currentThread() 
          	���ضԵ�ǰ����ִ�е��̶߳�������á� 
		 * */
		
	}
	
}


public class ImplementsDemo {
public static void main(String[] args) {
	//���������̣߳�ͬѧ������ƻ��
	Apple a=new Apple();
	new Thread(a,"СA").start();
	new Thread(a,"СB").start();
	new Thread(a,"СC").start();
	//�۲�������ʹ��ʵ��Runnable��ʽ��ʵ��ABCһ������50��ƻ������Ϊֻ������һ��ƻ�����󣬴��������̹߳�����һ��Apple���� 
	 
	
	/*new Thread(new Apple()).start();
	 * new Thread(new Apple()).start();
	 * new Thread(new Apple()).start();
	 * �����ôд�ᷢ��ÿ���˶�����50��ƻ������Ϊ����������ƻ������
	 * */
}
}
