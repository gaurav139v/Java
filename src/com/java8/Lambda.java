package com.java8;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.concurrent.*;
/*
 * It helps to iterate, filter and extract data from collection.
 * Java lambda expression
 * A functional interface is an interface that contains only one abstract method.
 * Syntax : ( arguments ) -> { body }
 * You must use return keyword when lambda expression contains multiple statements.
*/

// functional interface 
interface Student {
	public void studentDetails();
}

public class Lambda {

	public static void main(String[] args) {
		
		// implement interface without lambda
		// using anonymous class
		Student s1 = new Student() {
			
			@Override
			public void studentDetails() {
				System.out.println("Student name : Gaurav");
			}			
		};
		s1.studentDetails();
		
		// using lambda expression
		// lambda expression can have single parameter , multiple parameter or no parameter.
		Student s2 = () -> {
			System.out.println("Student name : Neelam");
		};
		s2.studentDetails();
		
		// in for each loop
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(32);
		list.add(43);
		list.add(5354);
		list.add(534);
		list.add(534);
		
		list.forEach((n) -> System.out.println(n));
		
		// createing thread
		Runnable rw = () -> {
			
//			try {
//				Thread.sleep(5000);
				System.out.println("Thread is created");
				
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		};
		
		Thread t1 = new Thread(rw);
		t1.start();
		try {
			t1.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		list.forEach((n) ->{ 
//			System.out.println(n);
//			System.out.println("hello");
//		});
		
		// in comparator
		Collections.sort(list, (a, b) -> b.compareTo(a));
		System.out.println(list);
		
		// filter collections
//		Stream<Integer> filter = list.stream().filter((a) -> a > 50);
//		filter.forEach(a -> System.out.println(a));
//		
//		System.out.println(list.stream().distinct());
//		list.stream().distinct().forEach(System.out::println);
//		
//		Map<Integer, Long> m = list.stream().collect(Collectors.groupingBy(k -> k, Collectors.counting()));
//	
		
//		Arrays.parallelSort(list);
		for(int i=0; i<1000; i++) {
			list.add(i);
		}
		
//		CopyOnWriteArrayList<Interger>
		list.parallelStream().forEach(a -> System.out.println(a));
	}

}
