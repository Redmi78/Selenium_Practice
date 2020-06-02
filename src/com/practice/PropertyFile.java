package com.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertyFile {

	public static void main(String[] args) throws Throwable {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("./GlobalVariable.properties");
		prop.load(fis);
		System.out.println(prop.getProperty("browser"));
		prop.setProperty("browser", "firefox");
		System.out.println(prop.getProperty("browser"));
		FileOutputStream fos = new FileOutputStream("./GlobalVariable.properties");
		prop.store(fos, null);
	}

}
