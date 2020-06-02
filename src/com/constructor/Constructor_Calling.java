package com.constructor;

class Demo {
	public void demoMethod() {
		System.out.println("Demo Method");
	}
}

public class Constructor_Calling extends Demo {
	private String name = "";

	public Constructor_Calling() {
		System.out.println("Constructor output");
	}

	public Constructor_Calling(String name) {
		this.name = name;
		System.out.println("Name from constructor: " + name);
	}

	public void sample() {
		System.out.println("Sample method output");
		System.out.println("Name from method: " + name);
		super.demoMethod();
	}

	public static void main(String[] args) {
		Constructor_Calling cc = new Constructor_Calling();
		Constructor_Calling cc1 = new Constructor_Calling("Subba");
		cc.sample();
	}
}
