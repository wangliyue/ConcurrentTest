package com.lingtong.BasicRunable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * 实现Callable接口的任务  可以有返回值
 * @author wly
 *
 */
class TaskWithResult implements Callable<String> {

	private int id;
	
	public TaskWithResult(int id){
		this.id = id;
	}
	@Override
	public String  call() throws Exception {
		return "result of TaskWithResult " +id;
	}
}

public class CallableDemo{
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exec = Executors.newCachedThreadPool();
		
		List<Future<String>> results = new ArrayList<Future<String>>();
		
		for(int i = 0 ; i < 10 ; i++){
			results.add(exec.submit(new TaskWithResult(i)));
		}
		
		for(Future<String> fs  : results){
			System.out.println(fs.get());
		}
	}
}
