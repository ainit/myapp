package com.aini.automic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestAutoMic {
	public static AtomicInteger COUNT = new AtomicInteger(0);
	public static void main(String[] args) {
		ExecutorService serivce = Executors.newFixedThreadPool(100);
			for(int i=0;i<100;i++ ){
				serivce.submit(new Runnable(){
					@Override
					public void run() {
						COUNT.incrementAndGet();
					}
			
			});
		}
		try {
			serivce.awaitTermination(1, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		serivce.shutdown();
		System.out.println(COUNT);
		System.out.println(COUNT);
	}
}
