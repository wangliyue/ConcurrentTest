package com.lingtong.BasicThread;

class Sleeper extends Thread{
	private int duration;
	
	public Sleeper(String name,int sleepTime){
		super(name);
		duration = sleepTime;
		start();
	}
	
	@Override
	public void run() {
		try{
			Thread.sleep(duration);
		}catch (Exception e) {
			System.out.println(getName()+ " was interrupted.");
			return ;
		}
		System.out.println(getName()+" has awakened");
	}
}

class Joiner extends Thread{
	private Sleeper sleeper;

	public Joiner(String name ,Sleeper sleeper) {
		super(name);
		this.sleeper = sleeper;
		start();
	}
	
	@Override
	public void run() {
		try {
			sleeper.join();            //Joiner Thread会在Sleeper Thread结束之后，再继续运行
		} catch (Exception e) {
			System.out.println("Interrupted");
		}
		System.out.println(getName()+" join completed");
	}
}
public class Joining {
   
	public static void main(String[] args) {
		Sleeper sleepy = new Sleeper("Sleepy", 1500);
		Sleeper grumpy = new Sleeper("Grumpy", 1500);
		
		Joiner dopey = new Joiner("Dopey", sleepy);
		Joiner doc = new Joiner("Doc", grumpy);
		
		grumpy.interrupt();          //
	}
}
