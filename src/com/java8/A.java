package com.java8;

abstract class B {
	public B() {
		System.out.println("this is constructor in abstract class");
	}
	
	public abstract void say();
}

interface C {
	public int add(int a, int b);
	
	default int sub(int a, int b) {
		return a - b;
	}
	
	public static int div(int a, int b) {
		return a/b;
	}
}

class D extends B {

	@Override
	public void say() {
		System.out.println("this is from class D");
		
	}	
}

public class A {

	public static void main(String[] args) {
		D d = new D(); // this call constructor of abstract class first 
		d.say(); 
		
		

	}

}
