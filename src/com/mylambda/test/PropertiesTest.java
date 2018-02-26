package com.mylambda.test;

import java.util.ResourceBundle;

public class PropertiesTest {
	public static void main(String[] args) {
		String bundle_name = "com.mylambda.po.messages"; //路径
		ResourceBundle resource_bundle = ResourceBundle.getBundle(bundle_name);
		System.out.println(resource_bundle.getString("adnubName"));
		System.out.println(resource_bundle.getString("pwd"));
	}
}
