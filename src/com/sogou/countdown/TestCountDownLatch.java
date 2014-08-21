package com.sogou.countdown;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 模拟百米赛跑，运动员准备
 * @author zwb
 *
 */
public class TestCountDownLatch {
	public static void main(String[] args) {
		CountDownLatch begin = new CountDownLatch(1);
		CountDownLatch end = new CountDownLatch(5);
		Runner r1 = new Runner(begin,end);
		Runner r2 = new Runner(begin,end);
		Runner r3 = new Runner(begin,end);
		Runner r4 = new Runner(begin,end);
		Runner r5 = new Runner(begin,end);
		ExecutorService service = Executors.newFixedThreadPool(10);
		service.execute(r1);
		service.execute(r2);
		service.execute(r3);
		service.execute(r4);
		service.execute(r5);
		begin.countDown();
		try {
			end.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("finish");
		service.shutdown();
		
	}
	
}


class Runner implements Runnable{
	private CountDownLatch latch;
	private CountDownLatch end;
	Runner(CountDownLatch latch,CountDownLatch end){
		this.latch = latch;
		this.end = end;
	}
	@Override
	public void run() {
		try {
			latch.await();
			System.out.println(Thread.currentThread().getName()+"race...");
			Thread.sleep(1000);
			end.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}