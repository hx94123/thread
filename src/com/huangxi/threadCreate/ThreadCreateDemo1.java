package com.huangxi.threadCreate;
/*�����������߳����ִ�ͳ�ķ�ʽ��
 * ��1���̳�Thread��
 * 		1)����һ����̳�Thread��
 * 		2�������и���Thread���е�run����
 * 		3����run�������д��Ҫִ�еĲ���
 * 		4����main������ �����̶߳��󣬲������̣߳�����start�������ײ�����run��������ǧ��Ҫֱ�ӵ���run��������Ϊ��ñ��Ƕ�����÷�������Ȼ����һ���߳�
 *Thread��ʵ��ʵ��Runnable�ӿڵ�
 * ע�����̣߳�main�������У�
 * 
 * */
class MusicThread extends Thread{
	public void run() {
		for(int i=0;i<50;i++){
			System.out.println("��������"+i);
		}
	}
}

public class ThreadCreateDemo1 {
	public static void main(String[] args) {
		//���̣߳�������Ϸ
		for(int i=0;i<50;i++){
			System.out.println("����Ϸ"+i);
			if(i==10){
				//�������������߳�
				Thread thread=new MusicThread();
				thread.start();
			}
		}
	}
}
