package com.example;

public class FinalClassExample {
	
	static class A {
		
		void xxx() {
			
		}
		
		final void yyy() {
			
		}
		
	}
	
	static class B extends A { 
		@Override
		void xxx() {
			// TODO Auto-generated method stub
			super.xxx();
		}
//		@Override
//			void yyy() { 		//final 이 들어간 클래스는 부모가 될 수 없다.
//				// TODO Auto-generated method stub
//				super.yyy();
//			}
	}
	
	public static void main(String[] args) {

	}

}
