package com.huangxi.process;

import java.io.IOException;
import java.util.List;

/*Runtime�ࣨ�����������õ���exit��gc��exec����
 * ProcessBuilder��
 * */

//��java����ο���һ�����̣����м��±�����
public class ProcessDemo {
public static void main(String[] args) throws Exception {
	//��ʽ1��ʹ��Rruntime��exec����
	Runtime runtime = Runtime.getRuntime();
	runtime.exec("notepad");
	
	//��ʽ2��ProcessBuilder���start����
	//ProcessBuilder pd=new ProcessBuilder("notepad");
	//pd.start();
}
}

