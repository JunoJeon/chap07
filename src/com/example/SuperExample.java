package com.example;

public class SuperExample {
	static class A {
		public A() {
			System.out.println("A()...");
		}
	}
	
	static class B extends A {
		public B() {
			super(); //객체지향은 부모를 자동으로 먼저 호출한다.
			System.out.println("B()..."); 
		}
	}
	
	static class C {
		public C(int speed) {
			//개발자가 하나라도 생성자를 정의하면 자녀 생성자는 super을 넣지않는다.
		}
	}
	
	static class D extends C {
		public D() {
			super(100);   //부모에 디폴트 생성자가 없으면 에러
		// 에러를 없애는방법은 C에 디폴트생성자를 만들어주거나 super에 부모생성자의 정의에 맞춰 넣거나이다.
		}
		
		public D (int line) {
			super(20); 
		}
		public D (int line, int column) {
			super(40);
		}
		// 부모생성자에 디폴트가없고 자녀에 생성자를 만들었을때
		// 자녀 생성자에 super를 쓰지않아도 기본적으로 들어가있어서 값을주지않으면 오류
	}
	
	public static void main(String[] args) {
		B b = new B();
		System.out.println(b);
	}

}
