package com.example;

import java.util.Timer;
import java.util.TimerTask;

public class TimerExample2 {
	
	static class A extends TimerTask {
		@Override
		public void run() {
			System.out.println((int)(Math.random()*10+1));
		}
	}
	static class B extends TimerTask {
		@Override
		public void run() {
			System.out.println((char)(Math.random()*26+'A'));
		}
	}

	public static void main(String[] args) {
//		TimerTask t = new TimerTask();
		Timer timer = new Timer();
		
		timer.schedule(new A(), 0, 500);
		timer.schedule(new B(), 0, 300);
		
		System.out.println("Program End");
		
	}

}
