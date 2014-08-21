package com.sogou.theadpool;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 9008);
			java.io.OutputStream out = socket.getOutputStream();
			InputStream is = socket.getInputStream();
			while(true){
				out.write("hello service ,I am client".getBytes());
				out.flush();
				byte b[] = new byte[1024];
				int len = is.read(b);
				String message = new String(b);
				System.out.println(message+":"+len);
				Thread.sleep(2000);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
