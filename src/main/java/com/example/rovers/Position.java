package com.example.rovers;

public class Position {
	 private int x;
	    private int y;
	    private char heading;

	    public Position(int x, int y, char heading) {
	        this.x = x;
	        this.y = y;
	        this.heading = heading;
	    }

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public char getHeading() {
			return heading;
		}

		public void setHeading(char heading) {
			this.heading = heading;
		}

}
