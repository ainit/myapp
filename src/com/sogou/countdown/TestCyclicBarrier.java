package com.sogou.countdown;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 运动员百米赛跑
 * @author zwb
 *
 */
public class TestCyclicBarrier {
	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(5);
		ExecutorService executor = Executors.newFixedThreadPool(5); 
		executor.execute(new MyRunner(barrier));
		executor.execute(new MyRunner(barrier));
		executor.execute(new MyRunner(barrier));
		executor.execute(new MyRunner(barrier));
		executor.execute(new MyRunner(barrier));
		executor.shutdown();
	}
}

class MyRunner implements Runnable{
	private CyclicBarrier barrier;
	MyRunner(CyclicBarrier barrier){
		this.barrier = barrier;
	}
	@Override
	public void run() {
		try {
			barrier.await();
			System.out.println(Thread.currentThread().getName()+"race...");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}