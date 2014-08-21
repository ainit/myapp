package com.sogou.queue;

public class Consume implements Runnable{

	private Basket basket;
	public Consume(Basket basket){
		this.basket = basket;
	}
	
	@Override
	public void run() {
		while(true){
			basket.consume();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
