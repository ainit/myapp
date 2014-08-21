package com.sogou.queue;

public class Produce implements Runnable {

	private Basket basket;
	private String p;
	
	public Produce(Basket basket,String p){
		this.basket = basket;
		this.p = p;
	}
	@Override
	public void run() {
		while(true){
			basket.produce(p+System.currentTimeMillis());
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
