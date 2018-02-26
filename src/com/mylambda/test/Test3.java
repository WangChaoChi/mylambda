package com.mylambda.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class Test3 {
	
	static void gen1(){
		String[] str={"a","b","3","5","5"};
		Stream<String> stream =Stream.of(str);
		stream.forEach(System.out::println);
	}
	
	static void gen2(){
		List<String> list=Arrays.asList("a","2","4");
		Stream<String> stream =list.stream();
		stream.forEach(System.out::println);
	}
	
	static void gen3(){
		Stream<Integer> stream =Stream.generate( ()->1 );
		stream.limit(10).forEach(System.out::println);
	}
	
	static void gen4(){
		Stream<Integer> stream =Stream.iterate(10, x -> x+1);
		stream.limit(10).forEach(System.out::println);
	}
	
	static void gen5() throws IOException{
		String str ="abcd";
		IntStream stream =str.chars();
		stream.forEach(System.out::println);
		
		Files.lines(Paths.get("f:/StringTest.java")).forEach(System.out::println);
	}
	
	public static void main(String[] args) throws IOException {
		//gen1();
		//gen2();
		//gen3();
		//gen4();
		//gen5();
		
	//	Arrays.asList(1,2,3,4,5).stream().filter(x->x%2==0).forEach(System.out::println);
		int sum =Arrays.asList(1,2,3,4,5,6).stream().filter(x->x%2==0).mapToInt(x -> x).sum();
//		System.out.println(sum);
		
		int max=Arrays.asList(1,2,3,4,5,6).stream().max((x,y) -> x-y).get();
//		System.out.println(max);
		
		int min=Arrays.asList(1,2,3,4,5,6).stream().min((x,y) -> x-y).get();
		//System.out.println(min);
		
		Optional<Integer> optional= Arrays.asList(1,2,3,4,5,6).stream().filter(x->x%2==0).findAny();
		//System.out.println(optional.get());
		
		Optional<Integer> optional2= Arrays.asList(1,2,3,4,5,6).stream().filter(x->x%2==0).findFirst();
//		System.out.println(optional2.get());
		
		Optional<Integer> optional3= Arrays.asList(1,2,3,4,5,6).stream().filter(x->x%2==0).sorted((x,y)->y-x).findFirst();
//		System.out.println(optional3.get());
		
//		Arrays.asList(12,25,3,45).stream().sorted().forEach(System.out::println);
//		Arrays.asList(12,25,3,45).stream().sorted((a,b)->b-a).forEach(System.out::println);
		
//		Arrays.asList("nio","admin","net","cn").stream().sorted((a,b) ->a.length()-b.length()).forEach(System.out::println);
		
		//从1-50里面找出所有的偶数，放到一个list里面
//		List<Integer> list= Stream.iterate(1, x -> x+1).limit(50).filter(x -> x%2==0).collect(Collectors.toList());
//		System.out.println(list);
		
		//去重	
//		Arrays.asList(1,4,5,4,5,7,8,1).stream().distinct().forEach(System.out::println);
//		
//		Set<Integer> set= Arrays.asList(1,4,5,4,5,7,8,1).stream().collect(Collectors.toSet());
//		System.out.println(set);
		
		//limit和skip配合可实现分页
//		List<Integer> num=  Stream.iterate(1, x -> x+1).limit(30).sorted((a,b) -> b-a).skip(20).limit(10).collect(Collectors.toList());
//		System.out.println(num);
		
		String str="11,12,13,14,15";
//		int sum1 =Stream.of(str.split(",")).mapToInt(x -> Integer.valueOf(x)).sum();
//		System.out.println(sum1);
		
//		int sum2=Stream.of(str.split(",")).mapToInt(Integer::valueOf).sum();
//		System.out.println(sum2);
		
		String str2 ="tomcat,nginx,apahce,jetty";
	//	Stream.of(str2.split(",")).map(x -> new User(x)).forEach(System.out::println);
//		Stream.of(str2.split(",")).map(User::new).forEach(System.out::println);
		
	//	Stream.of(str2.split(",")).map(Persion::build).forEach(System.out::println);
		
		String str3="11,22,33,44,55";
		int sum2 =Stream.of(str3.split(",")).mapToInt(Integer::valueOf).peek(System.out::println).sum();
		System.out.println(sum2);
	}
	

}
class User{
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

class Persion{
	private String name;

	public static Persion build(String name){
		Persion p=new Persion();
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
		return "Persion [name=" + name + "]";
	}
}