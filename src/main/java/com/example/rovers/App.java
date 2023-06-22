package com.example.rovers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {

    public static void main(String[] args){
    			
    	 if (args.length < 1) {
               System.out.println("input is missing");		
	            return;
	        }

	        String inputFile = args[0];

	        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
	            String line = reader.readLine();
	            if (line == null || line.isEmpty()) {
	                System.out.println("Input file is empty.");
	                return;
	            }
	            String[] plateauSize = line.split("\\s+");
	            
	            if (plateauSize.length < 2) {
	                System.out.println("Invalid plateau coordinates.");
	                return;
	            }
	            
	            int maxX = Integer.parseInt(plateauSize[0]);
	            int maxY = Integer.parseInt(plateauSize[1]);
	          
	            String roverLine;
	            while ((roverLine = reader.readLine()) != null) {
	                String[] position = roverLine.split(" ");
	                int x = Integer.parseInt(position[0]);
	                int y = Integer.parseInt(position[1]);
	                char heading = position[2].charAt(0);

	                Rovers rover = new Rovers(x, y, heading, maxX, maxY);

	                String instructions = reader.readLine();
	                rover.processInstructions(instructions);
	                
	                System.out.println(rover.getPosition());
	            }
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
    }
}
