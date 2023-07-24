package com.example;

import java.util.Timer;
import java.util.TimerTask;

import util.Alpha;
import util.VT100;

public class AlphaCrossExample {
	
	static class AlphaCross extends Alpha {
		public AlphaCross() {
			line = 10;
			column = 20;
		}
		
		void right()	{
			hide();
			column++;
			show();
		}
		void down()	{
			hide();
			line++;
			show();
		}
		void left()	{
			hide();
			column--;
			show();
		}
		void up()	{
			hide();
			line--;
			show();
		}
	}
	
	
	
	static class CrossTimerTask extends TimerTask {
		static int totalCount = 0;
		int count = 0;
		
		public CrossTimerTask() {
			totalCount++;
		}
		
		AlphaCross alphaCross = new AlphaCross();
		int random = (int)(Math.random()*4+1);
		
		@Override
		public void run() {
			switch (random) {
			case 1:
				alphaCross.right();
				break;
			case 2:
				alphaCross.down();
				break;
			case 3:
				alphaCross.left();
				break;
			case 4:
				alphaCross.up();
				break;
			default:
				break;
			}
			
			if(alphaCross.getLine()==10 && alphaCross.getColumn()==40) {
				alphaCross.hide();
				cancel();
			}	else if (alphaCross.getLine()==1 && alphaCross.getColumn()==20) {
				alphaCross.hide();
				cancel();
			}	else if (alphaCross.getLine()==10 && alphaCross.getColumn()==1) {
				alphaCross.hide();
				cancel();
			}	else if (alphaCross.getLine()==20 && alphaCross.getColumn()==20) {
				alphaCross.hide();
				cancel();
			}
			
			
		}
	}
	static Timer timer = new Timer();
	
	public static void main(String[] args) throws InterruptedException {
		VT100.clearScreen();
		for(int i=0; i<10; i++) {
			CrossTimerTask t = new CrossTimerTask();
			Thread.sleep(50);
			int speed = (int)(Math.random()*1000+20);
			timer.schedule(t, 0, speed);	
		}
		
		VT100.reset();
		
	}

}
