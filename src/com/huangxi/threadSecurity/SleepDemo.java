package com.huangxi.threadSecurity;
/*ע�����̵߳�run�����ϲ���ʹ��throws������ �׳��쳣��ֻ���ڷ�����ʹ��try-catch������
 * ԭ�����า�Ǹ���ķ�����ԭ�����಻���׳��µ��쳣����Runnable�ӿ���run��������û�������׳��쳣 
 * 
 */
public class SleepDemo {
public static void main(String[] args) throws Exception {
	System.out.println("begin...");
	for (int i = 5; i >=0; i--) {
		System.out.println("i="+i);
		Thread.sleep(1000);
		}
	System.out.println("ending...");
}
}
