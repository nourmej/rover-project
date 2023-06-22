package com.example.rovers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {

    public static void main(String[] args){
    	 if (args.length < 1) {
	            return;
	        }

	        String inputFile = args[0];

	        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
	            String plateauSizeLine = reader.readLine();
	            String[] plateauSize = plateauSizeLine.split(" ");
	            int plateauWidth = Integer.parseInt(plateauSize[0]);
	            int plateauHeight = Integer.parseInt(plateauSize[1]);

	            String roverLine;
	            while ((roverLine = reader.readLine()) != null) {
	                String[] position = roverLine.split(" ");
	                int x = Integer.parseInt(position[0]);
	                int y = Integer.parseInt(position[1]);
	                char heading = position[2].charAt(0);

	                Rovers rover = new Rovers(x, y, heading);

	                String instructions = reader.readLine();
	                rover.processInstructions(instructions);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
    }
}
