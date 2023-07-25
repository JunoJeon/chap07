package com.example;

import java.util.Timer;
import java.util.TimerTask;

import com.example.AlphaMoveExample3.Direction;

import util.Alpha;
import util.VT100;

public class AlphaCrossExample2 { //선생님과 같이한 것 1개짜
	
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
	
	
	
	public static void main(String[] args) throws InterruptedException {
		VT100.clearScreen();
		Cross c = new Cross();
		
		for(;;) {
			c.move();
			if(c.getLine()==1 || c.getColumn()==1
					|| c.getLine()==20 || c.getColumn()==40) {
				c.hide();
				break;
			}
			Thread.sleep(100);
		}
		
		VT100.reset();
	}

}
