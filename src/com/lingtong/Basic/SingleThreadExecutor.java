package com.lingtong.Basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {
   
	public static void main(String[] args) {
		
		ExecutorService exec = Executors.newSingleThreadExecutor();
		//创建了只有一条单一线程的线程池
		//但是提交了五个任务给线程池   ， 每个任务只能在前一个提交的任务结束之后才能开始运行  
		for(int i = 0 ; i < 5 ; i++){
			exec.execute(new LiftOff());
		}
		
		exec.shutdown();
		
		System.out.println("Waiting for LiftOff");
	}
}
