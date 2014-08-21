package com.sogou.queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) {
		Basket basket = new Basket();
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		Produce p1 = new Produce(basket, "apple");
		Produce p2 = new Produce(basket, "orange");
		Consume c = new Consume(basket);
		service.submit(p1);
		service.submit(p2);
		service.submit(c);
		
	}
}
