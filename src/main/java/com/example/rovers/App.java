package com.example.rovers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {

	public static void main(String[] args) {

		// if file is missing
		if (args.length < 1) {
			System.out.println("input is missing");
			return;
		}

		String inputFile = args[0];

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {

			// read the first line
			String line = reader.readLine();

			if (line == null || line.isEmpty()) {
				System.out.println("Input file is empty.");
				return;
			}

			String[] plateauSize = line.trim().split("\\s+");

			// verify if x and y exists
			if (plateauSize.length < 2) {
				System.out.println("Invalid plateau coordinates.");
				return;
			}

			PlateauSize size = Parser.parseSize(plateauSize);

			if (size != null) {
				String roverLine;
				while ((roverLine = reader.readLine()) != null) {
					String[] positionTab = roverLine.split("\\s+");

					Position position = Parser.parsePosition(positionTab);

					if (position != null) {
						Rovers rover = new Rovers(position.getX(), position.getY(), position.getHeading(),
								size.getMaxX(), size.getMaxY());
						String instructions = reader.readLine();
						rover.processInstructions(instructions);
						System.out.println(rover.getPosition());
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
