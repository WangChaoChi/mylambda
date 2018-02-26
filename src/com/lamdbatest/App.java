package com.lamdbatest;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App  {
	
	static void gen1() {
		String[] arr = {"a", "b", "1", "2"};
		Stream<String> stream = Stream.of(arr);
		stream.forEach(System.out::println);
	}
	
	static void gen2() {
		List<String> list = Arrays.asList("a", "b", "1", "2");
		Stream<String> stream = list.stream();
		stream.forEach(System.out::println);
	}
	
	static void gen3() {
		Stream<Integer> stream = Stream.generate( () -> 1);
		stream.limit(10).forEach(System.out::println);
	}
	
	static void gen4() {
		Stream<Integer> stream = Stream.iterate(1, x -> x + 1);
		stream.limit(10).forEach(System.out::println);
	}
	
	static void gen5() throws Exception {
		String str = "abcd";
		IntStream stream = str.chars();
		
//		stream.forEach(x -> System.out.println(x));
		stream.forEach(System.out::println);
		
		Files.lines(Paths.get("d:/Person.java")).forEach(System.out::println);
	}
	
	public static void main(String[] args) throws Exception {
//		App.gen1();
//		App.gen2();
//		App.gen3();
//		App.gen4();
//		App.gen5();
		
//		Arrays.asList(1,2,3,4,5).stream().filter(x -> x%2 == 0).forEach(System.out::println);
//		int sum = Arrays.asList(1,2,3,4,5,6).stream().filter(x -> x%2 == 0).mapToInt(x -> x).sum();
//		System.out.println(sum);
//		
//		int max = Arrays.asList(1,2,3,4,5,6).stream().max((a,b) -> a-b).get();
//		System.out.println(max);
//		
//		int min = Arrays.asList(1,2,3,4,5,6).stream().min((a,b) -> a-b).get();
//		System.out.println(min);
//		
//		Optional<Integer> op = Arrays.asList(1,2,3,4,5,6).stream().filter(x -> x%2 == 0).findAny();
//		System.out.println(op.get());
//		
//		op = Arrays.asList(1,2,3,4,5,6).stream().filter(x -> x%2 == 0).findFirst();
//		System.out.println(op.get());
//		
//		op = Arrays.asList(1,2,3,4,5,6).stream().filter(x -> x%2 == 0).sorted((a,b) -> b-a).findFirst();
//		System.out.println(op.get());
		
//		Arrays.asList(11,3,8,5,10).stream().sorted().forEach(System.out::println);
//		Arrays.asList(11,3,8,5,10).stream().sorted((a,b) -> b-a).forEach(System.out::println);
//		Arrays.asList("cn", "admin", "net", "io").stream().sorted((a,b) -> a.length()-b.length()).forEach(System.out::println);;
//	
	
		//从1-50里面的所有偶数找出来你，放到一个list里面
//		List<Integer> list = Stream.iterate(1, x -> x + 1).limit(50).filter(x -> x%2 == 0).collect(Collectors.toList());
//		System.out.println(list);
		
//		Arrays.asList(1, 3, 4, 2, 2, 5, 1).stream().distinct().forEach(System.out::println);;
		
//		Set<Integer> set = Arrays.asList(1, 3, 4, 2, 2, 5, 1).stream().collect(Collectors.toSet());
//		System.out.println(set);
	
//		List<Integer> list = Stream.iterate(1, x -> x + 1).limit(50).sorted((a,b) -> b-a).skip(20).limit(10).collect(Collectors.toList());
//		System.out.println(list);
		
		//把下列字符串分割，依次转换成int，然后求和
//		String str = "11,22,33,44,55";
//		int sum  = Stream.of(str.split(",")).mapToInt(x -> Integer.valueOf(x)).sum();
//		System.out.println(sum);
//		
//		sum  = Stream.of(str.split(",")).map(x -> Integer.valueOf(x)).mapToInt(x -> x).sum();
//		System.out.println(sum);
//		
//		sum  = Stream.of(str.split(",")).mapToInt(Integer::valueOf).sum();
//		System.out.println(sum);
		
		
//		String str = "tomcat,nginx,apahce,jetty";
//		Stream.of(str.split(",")).map(x -> new User(x)).forEach(System.out::println);
//		Stream.of(str.split(",")).map(User::new).forEach(System.out::println);
//		Stream.of(str.split(",")).map(x -> Person.build(x)).forEach(System.out::println);
//		Stream.of(str.split(",")).map(Person::build).forEach(System.out::println);
		
		String str = "11,22,33,44,55";
		int sum  = Stream.of(str.split(",")).peek(System.out::println).mapToInt(Integer::valueOf).sum();
		System.out.println(sum);
	}

}

class User {
	private String name;
	public User(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
}

class Person {
	private String name;
	
	public static Person build(String name) {
		Person p = new Person();
		p.setName(name);
		return p;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
}


