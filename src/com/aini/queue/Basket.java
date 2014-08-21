package com.aini.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Basket {
	private BlockingQueue<String> queue= new LinkedBlockingQueue<String>(10);
	
	public void produce(String app){
		try {
			System.out.println(app+" produce start...");
			queue.put(app);
			System.out.println(app+" produce end...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void consume(){
		try {
			System.out.println("consume start...");
			System.out.println(queue.take());
			System.out.println("consume end...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
