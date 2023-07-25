package com.example;

import java.util.TimerTask;

public class AbstractClassExample {
	static abstract class Animal {
		
		abstract void sound();
		
	}
	
	static class Cat extends Animal {

		@Override
		void sound() {
			System.out.println("야옹");
		}
		
	}
	
	static class Dog extends Animal {
		
		@Override
		void sound() {
			System.out.println("멍멍");
		}
		
	}
	
	static class people extends Animal {
		
		@Override
		void sound() {
			System.out.println("야이 XX야");
		}
		
	}
	
	static class A extends TimerTask {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	}
	static class B extends TimerTask {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	}

	public static void main(String[] args) {
		
		Animal c = new Cat();
		Animal d = new Dog();
		Animal p = new people();
		
		c.sound();
		d.sound();
		p.sound();
		
	}

}
