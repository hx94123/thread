package com.huangxi.threadCreate;
/*��2��ʵ��Runnable�ӿ�
 * 		1)����һ����Aʵ��Runnable�ӿ� ��ע����A�����߳���
 * 		2�������и���Runnable�ӿ��е�run����
 * 		3����run�������д��Ҫִ�еĲ���
 * 		4����main������ �����̶߳��󣬲������߳�
 * 			Thread thread=new Thread(new A());
 * 			thread.statrt();
 * */

class MusicThread2 implements Runnable{
	public void run() {
		for(int i=0;i<50;i++){
			System.out.println("��������"+i);
		}
	}
}
public class ThreadCreateDemo2 {
	public static void main(String[] args) {
		//���̣߳�������Ϸ
		for(int i=0;i<50;i++){
			System.out.println("����Ϸ"+i);
			if(i==10){
				//�������������߳�
				Runnable target =new MusicThread2();
				Thread thread=new Thread(target);
				thread.start();
			}
		}
	}
}
