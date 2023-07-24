package util;

public class Alpha {
	protected int line;
	protected int column;
	protected Color fg;
	protected Color bg;
	protected char ch;
	
	public Alpha() {
		line = (int)(Math.random()*20 + 1);
		column = (int)(Math.random()*40 + 1);
		
		do {
		fg = Color.values()[(int)(Math.random()*8)];
		bg = Color.values()[(int)(Math.random()*8)];
		} while (fg==bg);
		
		ch = (char)(Math.random()*26 + 'A');

	}
	
	public void show() {
		VT100.cursorMove(line, column);
		VT100.setForeground(fg);
		VT100.setBackground(bg);
		VT100.print(ch);
	}
	
	public void hide() {
		VT100.cursorMove(line, column); //커서위치로 이동한뒤 색을원래색으로 돌리고 스페이스를 찍어 글자를 지우는 것
		VT100.reset();
		VT100.print(' ');
	}
	
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public Color getFg() {
		return fg;
	}

	public void setFg(Color fg) {
		this.fg = fg;
	}

	public Color getBg() {
		return bg;
	}

	public void setBg(Color bg) {
		this.bg = bg;
	}

	public char getCh() {
		return ch;
	}

	public void setCh(char ch) {
		this.ch = ch;
	}
}
