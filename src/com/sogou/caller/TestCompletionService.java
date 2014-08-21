package com.sogou.caller;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCompletionService {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(10);
		CompletionService<Long> serv = new ExecutorCompletionService<Long>(exec);
		
		for(int i=0;i<10;i++){
			final long index = i;
			Callable<Long> call = new Callable<Long>(){
				@Override
				public Long call() throws Exception {
					return index;
				}
				
			};
			serv.submit(call);
		}
		
		for(int i=0;i<10;i++){
			try {
				Future<Long> f = serv.take();
				System.out.println(f.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		exec.shutdown();
		
	}
}
