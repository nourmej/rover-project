package com.example.rovers;



class Rovers {
    private int x;
    private int y;
    private char heading;

    public Rovers(int x, int y, char heading) {
        this.x = x;
        this.y = y;
        this.heading = heading;
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
            case 'N' -> y++;
            case 'E' -> x++;
            case 'S' -> y--;
            case 'W' -> x--;
        }
    }

    public String getPosition() {
        return x + " " + y + " " + heading;
    }
}

