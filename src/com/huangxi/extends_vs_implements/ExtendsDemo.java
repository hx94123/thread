package com.huangxi.extends_vs_implements;
//使用继承Thread方式来实现三个同学吃50个苹果的比赛
class Person extends Thread{
	private int num=50;
	public Person(String name) {
		super(name);
	}
	public void run() {
		for(int i=0;i<50;i++){
			if(num>0){
				System.out.println(super.getName()+"吃了编号为"+num--+"的苹果");//继承方式使用super.getName() 获取进程名称
			}
		}
	}
}

public class ExtendsDemo {
public static void main(String[] args) {
	//创建三个线程（同学），吃苹果
	new Person("小A").start();
	new Person("小B").start();
	new Person("小C").start();
	/*观察结果发现使用继承Thread方式来实现ABC都吃了50个苹果，因为在创建三个线程时每个对象在堆中都分得了num=50
	 * */
}
}
