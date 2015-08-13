package com.lingtong.BasicRunable;

public class MainThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LiftOff launch = new LiftOff();
		
	//	launch.run();     //这里直接调用任务的run()方法，并不是由单独的线程驱动的。  
    //  要想让这个任务在单独的线程(非在main线程中)执行，必须显式地将一个任务附在线程上。
		
	
	}

}
