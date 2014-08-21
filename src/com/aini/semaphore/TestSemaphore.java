package com.aini.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class TestSemaphore {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(20);
		final Semaphore semp = new Semaphore(5);
		
		for(int i=0;i<20;i++){
			final int index = i;
			Runnable r = new Runnable(){

				@Override
				public void run() {
					try {
						semp.acquire();
						System.out.println("accessing"+index);
						Thread.sleep((long)(Math.random()*10000));
						semp.release();
						System.out.println("-----------"+semp.availablePermits());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			};
			
			service.execute(r);
		}
		
		service.shutdown();
		
	}
}
