package com.example.rovers;

public class PlateauSize {
	    private int maxX;
	    private int maxY;

	    public PlateauSize(int maxX, int maxY) {
	        this.maxX = maxX;
	        this.maxY = maxY;
	    }

		public int getMaxX() {
			return maxX;
		}

		public void setMaxX(int maxX) {
			this.maxX = maxX;
		}

		public int getMaxY() {
			return maxY;
		}

		public void setMaxY(int maxY) {
			this.maxY = maxY;
		}
	    
}
