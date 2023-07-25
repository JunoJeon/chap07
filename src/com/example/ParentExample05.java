package com.example;

public class ParentExample05 {

	public class Parent {
		public String name;
		
		public Parent() {
			
		}
		
		public Parent(String name) {
			this.name = name;
		}
	}
	
	public class Child extends Parent {
		private int studentNo;
		
		public Child (String name, int studentNo) {
			
			this.name = name;
			this.studentNo = studentNo;
			
		}
	}
	
	public static void main(String[] args) {

	}

}
