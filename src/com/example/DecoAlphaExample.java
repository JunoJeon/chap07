package com.example;

import util.Alpha;
import util.VT100;

public class DecoAlphaExample {
	
	static class DecoAlpha extends Alpha {
		
//		@Override
		public void show() {
			super.show();
		}
		@Override
		public void hide() {
			super.hide();
			VT100.cursorMove(getLine(), getColumn());
			VT100.reset();
			VT100.print('_');
		}
		
		void blink() throws InterruptedException	{
				show();
				Thread.sleep(1000);
				hide();
				Thread.sleep(1000);
		}
	}
		
		
		
	public static void main(String[] args) throws InterruptedException {
		VT100.clearScreen();
		
		DecoAlpha a = new DecoAlpha();
		
		for(int i=0; i<=10; i++) {
			a.blink();
		}
		
		VT100.reset();
		
		}
}
