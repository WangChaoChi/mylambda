package com.mylambda.po;

import java.time.LocalDate;
/**
 * 
 * @author wcc
 * date 2017年10月10日 下午2:28:19
 */
public class Book {
	private int id;
	private String name;
	private double price;
	private LocalDate publishDate;
	
	private String type;
	
	public Book(int id, String name, double price, String type, LocalDate publishDate) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
		this.publishDate = publishDate;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public String getType() {
		return type;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	public void setType(String type) {
		System.out.println(Messages.getString("Book.0")); //$NON-NLS-1$
		this.type = type;
	}
	@Override
	public String toString() {
		return Messages.getString("Book.1") + id + Messages.getString("Book.2") + name + Messages.getString("Book.3") + price + Messages.getString("Book.4") + type + Messages.getString("Book.5") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
				+ publishDate + Messages.getString("Book.6"); //$NON-NLS-1$
	}
}
