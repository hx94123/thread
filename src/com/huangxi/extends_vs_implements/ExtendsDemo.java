package com.huangxi.extends_vs_implements;
//ʹ�ü̳�Thread��ʽ��ʵ������ͬѧ��50��ƻ���ı���
class Person extends Thread{
	private int num=50;
	public Person(String name) {
		super(name);
	}
	public void run() {
		for(int i=0;i<50;i++){
			if(num>0){
				System.out.println(super.getName()+"���˱��Ϊ"+num--+"��ƻ��");//�̳з�ʽʹ��super.getName() ��ȡ��������
			}
		}
	}
}

public class ExtendsDemo {
public static void main(String[] args) {
	//���������̣߳�ͬѧ������ƻ��
	new Person("СA").start();
	new Person("СB").start();
	new Person("СC").start();
	/*�۲�������ʹ�ü̳�Thread��ʽ��ʵ��ABC������50��ƻ������Ϊ�ڴ��������߳�ʱÿ�������ڶ��ж��ֵ���num=50
	 * */
}
}
