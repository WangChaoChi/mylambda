package com.mylambda.test;

import java.util.function.BiFunction;
import java.util.function.Function;

import com.mylambda.test.Test2.User;

public class Test2 {

	public static void main(String[] args) {
		Runnable r1=() -> get();
		Runnable r2=() -> find();
		Runnable r3=() -> exec();
		
		/*
		 *1、函数式接口对象可接收的返回值是根据该函数式接口中抽象方法的返回值来决定的，
		 *	函数式接口对象只能接受与它内部抽象方法返回值相同的的lambda表达式
		 *	如果该函数式接口无返回值则lambda表达式的函数体只是调用方法，但不会返回方法的值。
		 * 
		 * */
		Foo f1=() -> get();
		//Foo f2 = () -> find();
		//Foo f3 = () -> exec();
		Foo f4 = () -> 1;
		
		//Noo n1= () -> get();
		Noo n2 = () -> find();
		//Noo n3 = () -> exec();
		Noo n4 = () -> "";
		
		Voo v1 =() -> get();
		Voo v2 =() -> find();
		Voo v3 =() -> exec();
		Voo v4 = () -> {};
		//Voo v5 = () -> 1;
		//Voo v6 = () -> "";
		
		UserMapper u1= new UserMapper() {
			public void insert(User user) {
				System.out.println("inster u1 "+user);
			}
		};
		u1.insert(new User());
		
		UserMapper u2= (User user) ->{System.out.println("inster u2 "+user);};
		u2.insert(new User());
		
		UserMapper u3 =(user) -> System.out.println("inster u3 "+user);
		u3.insert(new User());
		
		OrderMapper o1 =new OrderMapper() {
			
			@Override
			public int insert(Order order) {
				return 1;
			}
		};
		System.out.println(o1.insert(new Order()));
		
		OrderMapper o2 =(Order order) -> {return 1;};
		System.out.println(o2.insert(new Order()));
		
		OrderMapper o3 =(order) -> 1;
		System.out.println(o3.insert(new Order()));
		
		Function<String, Integer> fun1 =(a) ->  a.length();
		System.out.println(fun1.apply("JavaEE"));
		
		BiFunction<String,String, Integer> biFun1=(a,b) -> a.length()+b.length();
		System.out.println(biFun1.apply("Android", "IOS"));
	}
	/**********************************************************************************/
	private static int get(){
		return 1;
	}
	
	private static String find(){
		return "";
	}
	
	private static void exec(){
		find();
	}
	
	//自定义的函数式接口
	interface Foo{
		int get();
	}
	
	interface Noo{
		String get();
	}
	
	interface Voo{
		void get();
	}
	
	interface UserMapper{
		void insert(User user);
	}
	
	interface OrderMapper{
		int insert(Order order);
	}
	
	static class User{
		
	}
	
	static class Order{
		
	}
}
