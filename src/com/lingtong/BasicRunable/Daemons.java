package com.lingtong.BasicRunable;

import java.util.concurrent.TimeUnit;

class Daemon implements Runnable{
    
	private Thread[] t = new Thread[10];
	@Override
	public void run() {
		for(int i = 0 ; i < t.length; i++){
			t[i] = new Thread(new DaemonSpawn()); 
			t[i].start();          
			System.out.println("DaemonSpawn "+i+" started");
		}
		
		for(int i = 0 ; i < t.length;i++){
			System.out.println("t[" +i+"].isDaemon() = "+t[i].isDaemon());
		}
		
		while(true){
			Thread.yield();
		}
	}
	
}

class DaemonSpawn implements Runnable{

	@Override
	public void run() {
		while(true){
			Thread.yield();
		}
	}
	
}
public class Daemons {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
	     Thread d = new Thread(new Daemon());
	     d.setDaemon(true);        //将一个线程设置为后台线程，那么这个线程任务中启动的线程都将自动成为后台线程
	     d.start();
	     
         System.out.println("d.isDaemon() = " +d.isDaemon());
         
         //Allow the daemon threads to finish their startup processes
         TimeUnit.SECONDS.sleep(1);
	}

}
