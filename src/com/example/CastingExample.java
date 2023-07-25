package com.example;

public class CastingExample {
	
	static class A{
		
	}
	
	static class B extends A {
		
	}

	public static void main(String[] args) {
		
		A a = new A();
		B b = new B();
		
		A aa = b;	// 자동 형변화 (Up-casting)
		
		if (a instanceof B) {
			B bb = (B)a;	// 수동 형변화 (Down-casting)
		}
		System.out.println("Program End...");
	}

}
