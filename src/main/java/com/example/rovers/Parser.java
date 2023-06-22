package com.example.rovers;

public class Parser {
	
	  public static PlateauSize parseSize(String[] plateauSize) {
	       int maxX;
	       int maxY;
	        try {
                maxX = Integer.parseInt(plateauSize[0]);
                maxY = Integer.parseInt(plateauSize[1]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid plateau coordinates: " + e.getMessage());
                return null;
            }        
	        return new PlateauSize(maxX, maxY);
	    }

	    public static Position parsePosition(String[] position) {
	        if (position.length < 3) {
                System.out.println("Invalid rover position.");
                return null;
            }
            int x;
            int y;
            try {
            	 x = Integer.parseInt(position[0]);
                 y = Integer.parseInt(position[1]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid plateau coordinates: " + e.getMessage());
                return null;
            }
            char heading;
            if (position[2].length() != 1 || !"NSEW".contains(position[2])) {
                System.out.println("Invalid rover heading.");
                return null;
            } else {
                heading = position[2].charAt(0);
            }
            
            return new Position(x, y, heading);
	    }

}
