package com.example;

import java.util.Timer;
import java.util.TimerTask;

import util.Alpha;
import util.VT100;

public class AlphaMoveExample3 {
	
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
	
	enum Direction {
		UP, DOWN, LEFT, RIGHT
	}
	
	static class MoveTimerTask extends TimerTask{ //run필요
		
		static int totalCount = 0;
		
		AlphaMove alphaMove = new AlphaMove();
		
		Direction direction = Direction.RIGHT;
		
		int count = 0;
		
		public MoveTimerTask() {
			totalCount++;
		}
		
		@Override
		public void run() {
			switch (direction) {
			case RIGHT:
				alphaMove.right();
				break;
			case DOWN:
				alphaMove.down();
				break;
			case LEFT:
				alphaMove.left();
				break;
			case UP:
				alphaMove.up();
				break;
			default:
				break;
			}
			
			if (alphaMove.getLine()==1 && alphaMove.getColumn()==1) {
				direction = Direction.RIGHT;
				count++;
			}	else if (alphaMove.getLine()==1 && alphaMove.getColumn()==40)
				direction = Direction.DOWN;
			else if (alphaMove.getLine()==20 && alphaMove.getColumn()==40)
				direction = Direction.LEFT;
			else if (alphaMove.getLine()==20 && alphaMove.getColumn()==1)
				direction = Direction.UP;
			
			if(count==2) {
				alphaMove.hide();
				cancel();
				totalCount--;
				if(totalCount==0) {
					VT100.reset();
					VT100.cursorMove(21, 1);
					System.out.println("Program End...");
					timer.cancel();
				}
			}	
		}
	}
	
	static Timer timer = new Timer();

	public static void main(String[] args) throws InterruptedException {
		VT100.clearScreen();
		
		for(int i=0; i<10; i++) {
			MoveTimerTask t = new MoveTimerTask();
//			int speed = (int)(Math.random()*300+20);
			timer.schedule(t, 0, 1000);	
		}
		
		VT100.reset();
	}

}
