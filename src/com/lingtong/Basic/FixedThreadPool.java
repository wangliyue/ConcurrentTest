package com.lingtong.Basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		ExecutorService exec = Executors.newFixedThreadPool(5);
		
		for(int i = 0 ; i < 5 ; i++){
			exec.execute(new LiftOff());
		}
		
		exec.shutdown();
		
		System.out.println("Waiting for LiftOff");

	}

}
