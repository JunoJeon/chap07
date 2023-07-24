package com.example;

import java.util.TimerTask;

public class OverridingExample {
	
	static class A {
		void show() {
			System.out.println("A.show()...");
		}
	
	}
	
	static class B extends A {
		
		void show() {			//부모의 시그니처와 동일해야 오버라이드 된다.
								//부모의 권한보다 더 가시성을 낮추는것은 안된다 privit (X) public (O)
			System.out.println("B.show()...");
		}

	}
	
	static class C extends TimerTask {
		
		@Override
		public void run() {
			
		}
	}
	
	
	public static void main(String[] args) {
		
		B b = new B();
		A a = b;		//부모타입에서 자식타입의 참조는 아무런 문제가 없다.
		a.show();
	}

}
