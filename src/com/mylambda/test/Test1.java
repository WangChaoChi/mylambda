package com.mylambda.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author wcc
 * 
 * Java7中出现的函数式接口：
 * Runnable Callable Comparator
 *
 */
public class Test1 {
	public static void main(String[] args) throws Exception {
		Runnable r1=new Runnable() {
			
			@Override
			public void run() {
				System.out.println("r1 run");
			}
		};
		
		r1.run();
		
		Runnable r2=()->{System.out.println("r2 run");};
		r2.run();
		
		//String.join("|", strArray)方法
		Runnable r3=()->{
			String[] strArray={"a","b","c","d"};
			String str=String.join("|", strArray);
			System.out.println(str);
		};
		r3.run();
		
		Runnable r4=()-> System.out.println("r4 run");
		r4.run();
		
		System.out.println("-------------------------------------------");
/************************************************************************/
		Callable<String> c1 = new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "c1 hello";
			}
		};
		System.out.println(c1.call());
		
		Callable<String> c2 =() -> {return "c2 hello";};
		System.out.println(c2.call());
		
		Callable<String> c3 =() -> "c3 hello";
		System.out.println(c3.call());
		
		System.out.println("------------------------------------------");
/**************************************************************************/
		List<String> strs1 =Arrays.asList("websphere","nginx","weblogic","tomcat");
		
		Collections.sort(strs1,new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				return arg0.length()-arg1.length();
			}
		});
		System.out.println("strs1:"+strs1);
		
		List<String> strs2 =Arrays.asList("websphere","nginx","weblogic","tomcat");
		Collections.sort(strs2,(a,b) -> a.length()-b.length());
		System.out.println("strs2:"+strs2);
		
	}
}
