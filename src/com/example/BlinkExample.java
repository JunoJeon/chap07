package com.example;

import util.Alpha;
import util.VT100;

public class BlinkExample {
	
	static class Blink extends Alpha {
		
		int speed;
		
		public Blink() {
			this(100);
//			super();		//부모 생성자 호출 
		}					// 이소스가 없어도 기본적으로 들어가있다. 생성자의 첫줄에 this가없으면 무조건 생성
		public Blink(int speed) {
//			super();		//첫 필드 첫줄에 this생성자가 들어가있으면 super이 생성되지않음
			this.speed = speed;
		}
		void blink() throws InterruptedException {
			show();
			Thread.sleep(speed);
			hide();
			Thread.sleep(speed);
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		VT100.clearScreen();
		
		Blink b = new Blink();
		for (int i=0; i<=10; i++) {
			b.blink();
		}

		VT100.reset();
		System.out.println("Program End...");

	}

}
