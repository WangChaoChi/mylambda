package com.lamdbatest;

import java.util.Optional;
import java.util.stream.Stream;

public class App2  {
	public static void main(String[] args) throws Exception {
		//-Djava.util.concurrent.ForkJoinPool.common.parallelism=5
		
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "5");
		
		Optional<Integer> max = Stream.iterate(1, x -> x+1).limit(200).peek(x -> {
			System.out.println(Thread.currentThread().getName());
		}).parallel().sequential().max(Integer::compare);
		
		System.out.println(max);
	}
}
