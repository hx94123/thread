package com.huangxi.process;

import java.io.IOException;
import java.util.List;

/*Runtime类（单例），常用的有exit、gc、exec方法
 * ProcessBuilder类
 * */

//在java中如何开启一个进程：运行记事本程序
public class ProcessDemo {
public static void main(String[] args) throws Exception {
	//方式1：使用Rruntime的exec方法
	Runtime runtime = Runtime.getRuntime();
	runtime.exec("notepad");
	
	//方式2：ProcessBuilder类的start方法
	//ProcessBuilder pd=new ProcessBuilder("notepad");
	//pd.start();
}
}

