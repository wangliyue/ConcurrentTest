package com.lingtong.Basic;

public class BasicThreads {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Thread t = new Thread(new LiftOff());
		
		t.start();
        
		System.out.println("Waiting for LiftOff");     
		
		//������������߳�   ��main�߳� ��t�߳�    
	}

}
