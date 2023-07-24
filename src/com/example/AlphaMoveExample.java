package com.example;

import util.Alpha;
import util.VT100;

public class AlphaMoveExample {
	
	static class AlphaMove extends Alpha {
		public AlphaMove() {
			line = 1;
			column = 1;
		}
		
		void right() {
			hide();
			column++;
			show();
		}
		void down() {
			hide();
			line++;
			show();
		}
		void left() {
			hide();
			column--;
			show();
		}
		void up() {
			hide();
			line--;
			show();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		VT100.clearScreen();
		AlphaMove am = new AlphaMove();
		
		for(;;) {
		for (int i=0; i<10; i++) {
			am.right();
			Thread.sleep(100);
			}
		for (int i=0; i<10; i++) {
			am.down();
			Thread.sleep(100);
			}
		for (int i=0; i<10; i++) {
			am.left();
			Thread.sleep(100);
			}
		for (int i=0; i<10; i++) {
			am.up();
			Thread.sleep(100);
			}
		}
		
//		VT100.reset();
	}

}
