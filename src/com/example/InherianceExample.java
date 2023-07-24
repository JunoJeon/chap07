package com.example;

public class InherianceExample {
	// 사용의 불편함을 줄이기위해 static을 쓴다.

	static class Parent {
		
	}
	
	public static void main(String[] args) {
		Parent p = new Parent();
	}
	public static void main3(String[] args) {
		
		InherianceExample x = new InherianceExample(); //클래스를 인스턴스형태로 쓰려면 이렇게 해야한다
//		Parent p = x.new Parent();
		
	}

	public static void main2(String[] args) {
//		Parent p = new Parent(); (X)
	}

}
