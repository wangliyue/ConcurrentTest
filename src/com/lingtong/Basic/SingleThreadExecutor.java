package com.lingtong.Basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {
   
	public static void main(String[] args) {
		
		ExecutorService exec = Executors.newSingleThreadExecutor();
		//������ֻ��һ����һ�̵߳��̳߳�
		//�����ύ�����������̳߳�   �� ÿ������ֻ����ǰһ���ύ���������֮����ܿ�ʼ����  
		for(int i = 0 ; i < 5 ; i++){
			exec.execute(new LiftOff());
		}
		
		exec.shutdown();
		
		System.out.println("Waiting for LiftOff");
	}
}
