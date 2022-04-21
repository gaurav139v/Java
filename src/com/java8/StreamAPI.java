package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI {

	private static Map<IntStream, Long> collect;

	public static void main(String[] args) {
		
		List<Integer> list1 = List.of(2,4,6,78,32,5); // can't modified this
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(3);
		list2.add(53);
		
		List<Integer> list3 = Arrays.asList(2,3,67,5,7);
		
		
		// odd number in list1
		List<Integer> listEven = new ArrayList<>();
		
		// using stream
		List<Integer> newList1 = list1.stream().filter((a) -> a%2==0).collect(Collectors.toList());
		System.out.println(newList1);
		
		list1.stream().filter(i -> i>50).collect(Collectors.toList()).forEach(System.out::println);
//		List<Integer> newList11 = list1.stream().filter(i -> i>50).collect(Collectors.toList()).forEach(val -> System.out.println(val));
//		System.out.println(newList11);
		
		// Stream of used to process collections or group of object
		
		// empty stream
		Stream<Object> emptyStream = Stream.empty();
		String[] names = {"Gaurav", "Richa", "Ankit", "Neelam", "Kajal", "Saurabh"};
		Stream<String> stream1 = Stream.of(names);
		stream1.forEach(e -> System.out.println(e));
		
		
		// bulder 
		Stream<Object> streamBuilder = Stream.builder().build();
		IntStream stream2 = Arrays.stream(new int[] {2,45,5,67,7});
		stream2.forEach(e -> System.out.println(e));
		
		
		// filter(Predicate)
		// predicate is a boolean function 
		
		// map 
		// perform operation on each element
		// take function it return value
		
		List<String> names1 = List.of("Gaurav", "Ankit", "Neelam", "Saurabh", "Kajal");
		List<String> newNames1 = names1.parallelStream().filter(e -> e.startsWith("A")).collect(Collectors.toList());
		System.out.println(newNames1);
		
		
		List<Integer> list5 = List.of(4,6,7,8,43,43,4);
		List<Integer> newList5 = list5.stream().map(e -> e*e).collect(Collectors.toList());
		System.out.println(newList5);
		
		List<Integer> ne = list5.stream().sorted().collect(Collectors.toList());
		System.out.println(ne);
		
		String test = "Hello this is sampel string";
		String[] st = test.split(" ");
		
		Map<String, Long> result = Stream.of(st).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(result);
		
		
		Map<String,Long> collect = names1.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(collect);
		
		
		Map<String, Long> collect2 = Stream.of("My name is Gaurav Verma My".split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(collect2);
	}
}
