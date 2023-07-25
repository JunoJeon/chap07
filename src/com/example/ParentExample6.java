package com.example;

public class ParentExample6 {

	public class Parent {
		public String nation;
		
		public Parent() {
			this("대한민국");
			System.out.println("Parent() call");
		}
		
		public Parent(String nation) {
			this.nation = "대한민국";
			System.out.println("Parent(String nation) call");
		}
	}
	
	public class Child extends Parent {
		private String name;
		
		public Child() {
			
			this("홍길동");
			System.out.println("Child() call");
			
		}
		
		public Child(String name) {
			this.name = "홍길동";
			System.out.println("Child(String name) call");
		}
	}
	
	public static void main(String[] args) {
		
//		Child child = new Child();
		
//		System.out.println(child);
		

	}

}
