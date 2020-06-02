package com.practice;
import java.awt.event.KeyEvent;

public class RobotClass {

	public static void main(String[] args) throws Exception  {
		Runtime.getRuntime().exec("notepad");
		java.awt.Robot r=new java.awt.Robot();
		r.keyPress(KeyEvent.VK_A);
		int j=50;
		for(int i=1;i<=10;i++)
		{
			r.mouseMove(j,100);
			j=j+50;
			Thread.sleep(1000);;
		}
		

	}

}
