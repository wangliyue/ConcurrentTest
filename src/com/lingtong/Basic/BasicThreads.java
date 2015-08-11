package com.lingtong.Basic;

public class BasicThreads {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Thread t = new Thread(new LiftOff());
		
		t.start();
        
		System.out.println("Waiting for LiftOff");     
		
		//这里包含两条线程   ：main线程 ，t线程    
	}

}
