package com.huangxi.threadCreate;
//ʹ�������ڲ��ഴ���̣߳�ֻ������ĳ����ֻʹ��һ�Σ�
public class ThreadCreateDemo3 {
	public static void main(String[] args) {
		//���̣߳�������Ϸ
		for(int i=0;i<50;i++){
			System.out.println("����Ϸ"+i);
			if(i==10){
				//ʹ�������ڲ��ഴ�����������߳�
				
				//ʹ�ýӿڣ��ײ�ͬ����2���϶�
				new Thread(new Runnable(){
					public void run() {
						for(int i=0;i<50;i++){
							System.out.println("��������"+i);
						}	
					}	
				}).start();
				
				//ʹ���࣬�ײ�ͬ����1������
				new Thread(){
					public void run() {
						for(int i=0;i<50;i++){
							System.out.println("����Ӱ"+i);
						}	
					}
				}.start();
				
			}
		}
	}
}
