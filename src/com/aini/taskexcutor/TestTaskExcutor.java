package com.aini.taskexcutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestTaskExcutor {
	public static void main(String[] args) {
		
		BlockingQueue queue = new LinkedBlockingQueue(5);
		
		ThreadPoolExecutor executor = new ThreadPoolExecutor(3,5,100,TimeUnit.MILLISECONDS,queue);
		
		for(int i=0;i<20;i++){
			final int index = i;
			System.out.println(queue.size());
			executor.submit(new Runnable(){
				@Override
				public void run() {
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}	
					System.out.println(String.format("Thread %d finish", index));
				}
				
			});
		}
	}
}
