package com.lingtong.synchroniz;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 消费者线程任务
 * @author wly
 *
 */
public class EventChecker implements Runnable {
    
	private IntGenerator generator;
	
	private final int id;
	
	
	public EventChecker(IntGenerator generator, int id) {
		this.generator = generator;
		this.id = id;
	}


	@Override
	public void run() {
	   while(!generator.isCanceled()){
		   int val = generator.next();
		   if(val % 2!=0){
			   System.out.println(val +" not even!");        //even --偶数
			   generator.cancle();
		   }
	   }
      
	}
    
	
	public static void test(IntGenerator gp,int count){
		System.out.println("Press Control-C to exit");
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		for(int i = 0; i < count ; i++){
			exec.execute(new EventChecker(gp, i));         //n个线程任务共享同一个资源gp
		}
	}
	
	public static void test(IntGenerator gp){
		test(gp,10);
	}
}
