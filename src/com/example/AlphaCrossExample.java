package com.example;

import java.util.Timer;
import java.util.TimerTask;

import com.example.AlphaMoveExample3.Direction;

import util.Alpha;
import util.VT100;

public class AlphaCrossExample {	//내가한 것
	
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
			
//			if(alphaCross.getLine()==10 && alphaCross.getColumn()==40) {
//				alphaCross.hide();
//				cancel();
//			}	else if (alphaCross.getLine()==1 && alphaCross.getColumn()==20) {
//				alphaCross.hide();
//				cancel();
//			}	else if (alphaCross.getLine()==10 && alphaCross.getColumn()==1) {
//				alphaCross.hide();
//				cancel();
//			}	else if (alphaCross.getLine()==20 && alphaCross.getColumn()==20) {
//				alphaCross.hide();	
//				cancel();
//			}
			if( alphaCross.getColumn()==40 || alphaCross.getLine()==1 ||
					alphaCross.getColumn()==1 || alphaCross.getLine()==20) {
				alphaCross.hide();
				cancel();
				totalCount--;
			}
			if(totalCount==0) {
				VT100.reset();
				VT100.cursorMove(21, 1);
				System.out.println("Program End...");
				timer.cancel();
			}
			
		}
		
	}
	static Timer timer = new Timer();
	
	public static void main(String[] args) throws InterruptedException {
		VT100.clearScreen();
		for(int i=0; i<1000; i++) {
			CrossTimerTask t = new CrossTimerTask();
			Thread.sleep(50);
			int speed = (int)(Math.random()*1000+20);
			timer.schedule(t, 0, speed);	
		}
		
		VT100.reset();
		
	}

}
