package com.huangxi.why;
/*�������̵߳�����
 * ���̣��ж������ڴ�ռ䣬�����е����ݴ�ſռ䣨�ѿռ�� ջ�ռ䣩�Ƕ����ģ�������һ���̣߳���˽��̼��ͨ�ŷǳ��鷳
 * �̣߳��ѿռ��ǹ���ģ�ջ�ռ��Ƕ����ģ��߳����ĵ���ԴҲ�Ƚ���С���໥֮�����Ӱ��ģ��ֳ�Ϊ���ͽ��̻����Ԫ
 * ��Ϊһ���߳��еĶ���߳��ǲ������еģ���ô��΢�۽Ƕ��Ͽ���Ҳ�����Ⱥ�˳��ģ���ô�ĸ��߳�ִ����ȫȡ����CPU��������java����JVM��������Ա�ǿ��Ʋ��˵�
 * ���ǿ��԰Ѷ��̲߳����Կ����Ƕ���߳���˲����CPU��Դ��˭������Դ˭�����У���Ҳ������˶��̵߳������
 * Java����Ľ���������Ҫ�������̺߳����������߳�,JVM���õ�����ռʽ����
 * */
public class GameDemo {
public static void main(String[] args) {
	//�ȴ�����Ϸ���ٲ�������
	System.out.println("begin...");
	playGame();
	playMusic();
	System.out.println("end...");
}

private static void playMusic() {
for(int i=0;i<50;i++){
		System.out.println("��������"+i);
		
	}
	
}

private static void playGame() {
	for(int i=0;i<50;i++){
		System.out.println("����Ϸ"+i);
		
	}
	
}
}
