package com.sogou.caller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

public class TestCaller {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(10);
		List<Future<Long>> tasks = new ArrayList<Future<Long>>();
		for(int i=0;i<10;i++){
			MyCaller task = new MyCaller();
			tasks.add(service.submit(task));
		}
		Long sum = 0L;
		for(Future<Long> f:tasks){
			try {
				System.out.println(f.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println(sum);
		service.shutdown();
		
	}
}

class MyCaller implements Callable<Long>{
    private static AtomicLong count = new AtomicLong(0);
	@Override
	public Long call() throws Exception {
		
		return count.incrementAndGet();
	}
	
}
