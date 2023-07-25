package com.example;

import java.util.Timer;
import java.util.TimerTask;

import com.example.AlphaMoveExample3.Direction;

import util.Alpha;
import util.VT100;

public class AlphaCrossExample3 { //선생님과 같이한 것 다수
	
	enum Direction{
		UP,DOWN,LEFT,RIGHT
	}
	
	static class Cross extends Alpha {
		
		final Direction direction;
		
		public Cross() {
			line = 10;
			column = 20;
			direction = Direction.values()[(int)(Math.random()*4)];
			show();
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
		void right() {
			hide();
			column++;
			show();
			
		}
		void left() {
			hide();
			column--;
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
	
	static class CrossTask extends TimerTask {
		static int count=0;
		Cross alpha = new Cross();
		
		public CrossTask() {
			CrossTask.count++;
		}
		@Override
		public void run() {
						if(alpha.getLine()==1 || alpha.getColumn()==1
					|| alpha.getLine()==20 || alpha.getColumn()==40) {
				alpha.show();
				alpha.hide();
				cancel();
				CrossTask.count--;
				
				if(CrossTask.count==0) {
					VT100.cursorMove(21, 1);
					VT100.reset();
					timer.cancel();
				}
				return;
			}
						
						
			alpha.move();
		}
		
	}
	
	static Timer timer = new Timer();
	
	public static void main(String[] args) throws InterruptedException {
		VT100.clearScreen();
		
		for(int i=0; i<50; i++) {
			CrossTask ct = new CrossTask();
			int speed = (int)(Math.random()*200+20);
			timer.schedule(ct, 0, speed);
			Thread.sleep(50);
		}
		
		
		VT100.reset();
	}

}
