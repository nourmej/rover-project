package com.example.rovers;

import java.util.Arrays;

class Rovers {
	private int x;
    private int y;
    private char heading;
    private int maxX;
    private int maxY;

    public Rovers(int x, int y, char heading, int maxX, int maxY) {
        this.x = x;
        this.y = y;
        this.heading = heading;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public void processInstructions(String instructions) {
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'L' -> turnLeft();
                case 'R' -> turnRight();
                case 'M' -> move();
            }
        }
    }

    private void turnLeft() {
        heading = switch (heading) {
            case 'N' -> 'W';
            case 'E' -> 'N';
            case 'S' -> 'E';
            case 'W' -> 'S';
            default -> throw new IllegalStateException("Invalid heading: " + heading);
        };
    }

    private void turnRight() {
        heading = switch (heading) {
            case 'N' -> 'E';
            case 'E' -> 'S';
            case 'S' -> 'W';
            case 'W' -> 'N';
            default -> throw new IllegalStateException("Invalid heading: " + heading);
        };
    }

    private void move() {
        switch (heading) {
        case 'N' -> y = Math.min(y + 1, maxY);
        case 'E' -> x = Math.min(x + 1, maxX);
        case 'S' -> y = Math.max(y - 1, 0);
        case 'W' -> x = Math.max(x - 1, 0);
        }
    }

    public String getPosition() {
    	 StringBuilder positionBuilder = new StringBuilder();
    	 positionBuilder.append(x).append(" ").append(y).append(" ").append(heading);
    	 return positionBuilder.toString();
    }
}

