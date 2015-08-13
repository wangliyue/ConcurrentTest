package com.lingtong.BasicRunable;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable {

	@Override
	public void run() {
		try{
			while(true){
				TimeUnit.MILLISECONDS.sleep(175);
				System.out.println(Thread.currentThread()+" "+this);
			}
		}catch(InterruptedException e){
			System.out.println("sleep() interrupted");
		}

	}
	
	public static void main(String[] args) throws InterruptedException {
		for(int i = 0 ; i < 10 ;i++){
			Thread daemon = new Thread(new SimpleDaemons());
			daemon.setDaemon(true);             //在start()方法之前调用 
			daemon.start();
		}
		
		System.out.println("All daemons started");
		
		TimeUnit.MILLISECONDS.sleep(175);
		System.out.println("main Thread is dead");
	}

}
