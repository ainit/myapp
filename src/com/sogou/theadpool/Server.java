package com.sogou.theadpool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	private static int port= 9008;
	private static ExecutorService pool = Executors.newFixedThreadPool(10);
	
	public void service(){
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(port);
			while(true){
				socket = serverSocket.accept();
				pool.submit(new ServiceThread(socket));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			pool.shutdown();
			try {
				socket.close();
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		server.service();
	}
}
