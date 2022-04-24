package com.threading;

import java.util.Collections;

class MyThread extends Thread{

	public void run() {
		System.out.println("This is "+this.getName());
	}
}

class MyThreadRunnable implements Runnable{

	@Override
	public void run() {		
		System.out.println("This is runnable thread");		
	}
	
}


class ThreadDemo {
	
	
	public static void main(String[] args) {
		Thread t1 = new MyThread();
		t1.start();		
//		t1.start(); //will throw java.lang.IllegalThreadStateException at runtime
//		if you want to run thread twice create new instance and call start()
		
		Thread t2 = new MyThread();
		t2.start();
		
		Thread t3 = new Thread(new MyThreadRunnable());
		t3.start();
		
		
	}
}
