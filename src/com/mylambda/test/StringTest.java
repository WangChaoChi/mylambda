package com.mylambda.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class StringTest {
	public static void main(String[] args) {
		//jdk8增加的join方法，中第一个参数是分隔符，后面接收一个CharSequence类型的可变参数数组或一个Iterable。
		String str =String.join("/", "a","b","c");
		System.out.println(str);
		
		String[] strArray={"1","2",null,"3"};
		String str1 =String.join("/", strArray);
		System.out.println(str1);
		
		ArrayList<String> strList=new ArrayList<>(Arrays.asList(strArray));;
		String str2 =String.join("/", strList);
		System.out.println(str2);
		
		/*
		 * Null检查Objects类添加了两个静态方法isNull和nonNull，在使用流的时候非常有用。
		 * 例如获取一个流的所有不为null的对象:
		 * */
		Stream.of(strArray)
        .filter(Objects::nonNull)
        .forEach(System.out::println);

	}

}
