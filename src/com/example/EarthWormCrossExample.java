package com.example;

import java.util.Timer;
import java.util.TimerTask;

import com.example.AlphaCrossExample2.Direction;

import util.Alpha;
import util.VT100;

public class EarthWormCrossExample { 
	
	enum Direction{
		UP, DOWN, LEFT, RIGHT
	}
	
	static class EarthWorm extends Alpha {
		
		 Direction direction;
		
		public EarthWorm() {
			line = (int)(Math.random()*20+1);
			column = (int)(Math.random()*40+1);
			direction = Direction.values()[(int)(Math.random()*4)];
		}
		void up() {
			hide();
			line--;
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
		void right() {
			hide();
			column++;
			show();
		}
		
		void move() {
			
			switch (direction) {
			case UP:
				up();
				break;
			case DOWN:
				down();
				break;
			case LEFT:
				left();
				break;
			case RIGHT:
				right();
				break;
			default:
				break;
			}
		}
		
	}
	
	static class WormTimerTask extends TimerTask {
		
		EarthWorm ew = new EarthWorm();
		
		@Override
		public void run() {
			
			if(ew.getLine()==1 || ew.getColumn()==1
					|| ew.getLine()==20 || ew.getColumn()==40) {
				ew.hide();
				cancel();
				return;
			}
			if()
			ew.move();
		}
		
	}
	
	static Timer timer = new Timer();
	
	public static void main(String[] args) throws InterruptedException{
		VT100.clearScreen();
		
		for(int i=0; i<10; i++) {
			WormTimerTask wt = new WormTimerTask();
			int speed = (int)(Math.random()*1000+200);
			timer.schedule(wt, 0, speed);
		}
		Thread.sleep(500);
		
		VT100.reset();
	}

}
