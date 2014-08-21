package com.aini.theadpool;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.locks.ReentrantLock;

public class ServiceThread implements Runnable {
	
	private static ReentrantLock lock = new ReentrantLock();
	private static int count = 0;
	
	private Socket socket;
	
	public ServiceThread(Socket socket){
		this.socket = socket;
	}
	
	
	public int getCount(){
		int ret =0;
		try{
		lock.lock();
		ret = count;
		}finally{
		lock.unlock();
		}
		return ret;
	}
	
	public void increaseCount(){
		try{
			lock.lock();
			count++;
		}finally{
			lock.unlock();
		}
	}
	
	@Override
	public void run() {
		try {
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			while(true){
				byte b[] = new byte[512];
				is.read(b);
				String mes = new String(b);
				System.out.println(mes);
				String msg = "Hello,I'am from socket"+Thread.currentThread().getName();
				os.write(msg.getBytes());
				os.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
