package com.huangxi.threadSecurity;
//����ģʽ-����ʽ
//�����ش����̲߳���ȫ����,��Ҫͬ����
public class ArrayUtil2_volatile {
	private ArrayUtil2_volatile(){
	}
	private static volatile ArrayUtil2_volatile instance=null;
	
	/*
	//ͬ���������÷����Ǿ�̬������ͬ�����������ǣ�ArrayUtil2_volatile.class��
	synchronized public static ArrayUtil2_volatile getInstance(){
		//A B�ڵ�
		if(instance==null){
			//C����
			instance=new ArrayUtil2();
		}
		return instance;
	} //��������ʹ��ͬ���������Ѿ����������ʽ���̰߳�ȫ���⣬����synchronized��������̫���� ��������ܣ���Ҫ������С������
	//ʹ��ͬ�������������ˣ�
	 */
	
	
	/*����̰߳�ȫ�������ܹ�ʹ���ܲ���̫���Ӱ�죬����ʹ�á�˫�ؼ�����������.
	 * ��ָ���ǣ�������ÿ�ν���getInstance��������Ҫͬ���������Ȳ�ͬ�������뷽�����ȼ��ʵ���Ƿ���ڣ���������ڲŽ��������ͬ���飬
	 * 			���ǵ�һ�ؼ�飬����ͬ������ٴμ��ʵ���Ƿ���ڣ���������ڣ�����ͬ���� ����´���һ��ʵ�������ǵڶ��ؼ�顣����һ
	 * 			������ֻ��Ҫͬ��һ���ˣ��Ӷ������˶����ͬ������½����ж����˷ѵ�ʱ��
	 *��˫�ؼ����������Ƶ�ʵ��ʹ�ùؼ���volatile��������˼�ǣ���volatile���εı�����ֵ�������ᱻ�����̻߳��棬���жԸñ����Ķ�д����
	 *				ֱ�Ӳ��������ڴ棬�Ӷ�ȷ������߳�����ȷ����ñ���
	 *ע�⣺ֻ��java5�Ժ�ʹ�ã���������volatile�ؼ��ֿ��ܻ����ε��������һЩ��Ҫ�Ĵ����Ż�����������Ч�ʲ��Ǻܸߡ����һ�㽨�飬û��
	 *		�ر��Ҫ��Ҫʹ�á����Ե���ģʽ�Ƽ�ʹ�ö���ʽд�����򵥡���ȫ���ֱ���
	 */
	
	 public static ArrayUtil2_volatile getInstance(){
		
		if(instance==null){
			//A B
			synchronized (ArrayUtil2_volatile.class) {
				if(instance==null){
					instance=new ArrayUtil2_volatile();
				}
			}
		}
		return instance;
	} 
	public void sort(int[] arr){
		//TODO
	}
}
