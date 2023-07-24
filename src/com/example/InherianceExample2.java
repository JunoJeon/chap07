package com.example;

public class InherianceExample2 {
	// 사용의 불편함을 줄이기위해 static을 쓴다.

	static class Parent {
		int line;
		int column;
		
		public Parent() {
			line = 10;
			column = 20;
		}
		
		void show() {
			System.out.printf("[%d, %d]", line, column);
		}
	}
	
	static class Child extends Parent {
		
	}
	
	public static void main(String[] args) {
		Child c = new Child();
		c.show();
		System.out.println();
		System.out.println(c.line);
		System.out.println(c.column);
	}
}