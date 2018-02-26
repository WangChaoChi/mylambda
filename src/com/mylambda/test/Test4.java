package com.mylambda.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.mylambda.po.Book;

public class Test4 {
	/**
	 * index.do?itemId=1&userId=10000&type=20&token=111111111111&key=index;
	 */
	@Test
	public void test1() {
		String queryString = "itemId=1000&type=20&token=11111&=index";
		Map<String, String> map = Stream.of(queryString.split("&")).map(str -> str.split("="))
				.collect(Collectors.toMap(str -> str[0], str -> str[1]));

		System.out.println(map);
	}

	@Test
	public void test2() {
		List<Integer> bookIds = books().stream().map(book -> book.getId()).collect(Collectors.toList());
		System.out.println(bookIds);

		bookIds = books().stream().map(Book::getId).filter(bid -> bid > 5).collect(Collectors.toList());
		System.out.println(bookIds);

		String idsStr = books().stream().map(book -> book.getId() + "").collect(Collectors.joining(","));
		System.out.println(idsStr);

		idsStr = books().stream().map(book -> book.getId() + "").collect(Collectors.joining(",", "(", ")"));
		System.out.println(idsStr);
	}

	@Test
	public void test3() {
		List<String> types = books().stream().map(Book::getType).collect(Collectors.toList());
		System.out.println(types);
		//distinct()去重
		types = books().stream().map(Book::getType).distinct().collect(Collectors.toList());
		System.out.println(types);

		Set<String> typeSet = books().stream().map(Book::getType).collect(Collectors.toSet());
		System.out.println(typeSet);
	}

	@Test
	public void test4() {
		// books().stream().sorted((book1,book2) ->
		// Double.compare(book1.getPrice(),
		// book2.getPrice())).forEach(System.out::println);

		// 按照书价格排序
		Comparator<Book> comp1 = (book1, book2) -> Double.compare(book1.getPrice(), book2.getPrice());
		Comparator<Book> comp3 = Comparator.comparing(Book::getPrice);

		// 按照发布日期排序
		Comparator<Book> comp2 = Comparator.comparing(Book::getPublishDate);

		// books().stream().sorted(comp3).forEach(System.out::println);

		// reversed() 排序反转
		// books().stream().sorted(comp1.reversed()).forEach(System.out::println);
		// books().stream().sorted(comp2).forEach(System.out::println);

		// thenComparing() 一级排序后的多级排序
		books().stream().sorted(comp3.thenComparing(comp2)).forEach(System.out::println);
	}

	@Test
	public void test5() {
		Map<Integer, Book> books = books().stream().filter(book -> book.getId() == 1)
				.collect(Collectors.toMap(Book::getId, book -> book));
		System.out.println(books);
	}

	@Test
	public void test6() {
		Double avg = books().stream().collect(Collectors.averagingDouble(Book::getPrice));
		System.out.println(avg);
	}

	@Test
	public void test7() {
		Optional<Book> book = books().stream().collect(Collectors.maxBy(Comparator.comparing(Book::getPrice)));
		System.out.println(book);

		book = books().stream().collect(Collectors.minBy(Comparator.comparing(Book::getPrice)));
		System.out.println(book);

		book = books().stream().collect(Collectors.maxBy(Comparator.comparing(Book::getPublishDate)));
		System.out.println(book);

		book = books().stream().collect(Collectors.minBy(Comparator.comparing(Book::getPublishDate)));
		System.out.println(book);

		Comparator<Book> comp = Comparator.comparing(Book::getPrice);
		book = books().stream()
				.collect(Collectors.maxBy(comp.reversed().thenComparing(Comparator.comparing(Book::getPublishDate))));
		System.out.println(book);
	}

	@Test
	public void test8() {
		/*
		 * Map<String, List<Book>> booksMap =
		 * books().stream().collect(Collectors.groupingBy(Book::getType));
		 * booksMap.keySet().forEach(key -> { System.out.println(key);
		 * System.out.println(booksMap.get(key));
		 * System.out.println("----------------------"); });
		 */

		/*Map<String, Double> bookAvg = books().stream()
				.collect(Collectors.groupingBy(Book::getType, Collectors.averagingDouble(Book::getPrice)));
		System.out.println(bookAvg);

		Map<String, Long> bookCount = books().stream()
				.collect(Collectors.groupingBy(Book::getType, Collectors.counting()));
		System.out.println(bookCount);

		Map<String, Double> bookSum = books().stream()
				.collect(Collectors.groupingBy(Book::getType, Collectors.summingDouble(Book::getPrice)));
		System.out.println(bookSum);*/
		
		Map<String, Optional<Book>> booksOp= books().stream().collect(Collectors.groupingBy(Book::getType,Collectors.maxBy(Comparator.comparing(Book::getPrice))));

	}

	private List<Book> books() {
		List<Book> books = new ArrayList<>();
		books.add(new Book(1, "tomcat", 70d, "服务器", LocalDate.parse("2014-05-17")));
		books.add(new Book(2, "jetty", 60d, "服务器", LocalDate.parse("2015-12-01")));
		books.add(new Book(3, "nginx", 65d, "服务器", LocalDate.parse("2016-10-17")));
		books.add(new Book(4, "java", 66d, "编程语言", LocalDate.parse("2011-04-09")));
		books.add(new Book(5, "ruby", 80d, "编程语言", LocalDate.parse("2013-05-09")));
		books.add(new Book(6, "php", 40d, "编程语言", LocalDate.parse("2014-08-06")));
		books.add(new Book(7, "html", 44d, "编程语言", LocalDate.parse("2011-01-06")));
		books.add(new Book(8, "oracle", 150d, "数据库", LocalDate.parse("2013-08-09")));
		books.add(new Book(9, "mysql", 66d, "数据库", LocalDate.parse("2015-04-06")));
		books.add(new Book(10, "ssh", 70d, "编程语言", LocalDate.parse("2016-12-04")));
		books.add(new Book(11, "设计模式", 81d, "其他", LocalDate.parse("2017-04-06")));
		books.add(new Book(12, "重构", 62d, "其他", LocalDate.parse("2012-04-09")));
		books.add(new Book(13, "敏捷开发", 72d, "其他", LocalDate.parse("2016-09-07")));
		books.add(new Book(14, "从技术到管理", 42d, "其他", LocalDate.parse("2016-02-19")));
		books.add(new Book(15, "算法导论", 66d, "其他", LocalDate.parse("2010-05-08")));
		books.add(new Book(16, "oracle 12c", 150d, "数据库", LocalDate.parse("2017-05-08")));
		return books;
	}

}