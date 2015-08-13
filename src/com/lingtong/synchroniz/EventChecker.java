package com.lingtong.synchroniz;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �������߳�����
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
			   System.out.println(val +" not even!");        //even --ż��
			   generator.cancle();
		   }
	   }
      
	}
    
	
	public static void test(IntGenerator gp,int count){
		System.out.println("Press Control-C to exit");
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		for(int i = 0; i < count ; i++){
			exec.execute(new EventChecker(gp, i));         //n���߳�������ͬһ����Դgp
		}
	}
	
	public static void test(IntGenerator gp){
		test(gp,10);
	}
}
