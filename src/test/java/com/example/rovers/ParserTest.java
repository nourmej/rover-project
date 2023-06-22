package com.example.rovers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.OutputCaptureExtension;

@ExtendWith(OutputCaptureExtension.class)
public class ParserTest {


    @Test
    public void parseSize() {
    	String[] plateauSize = {"5","5"};
        assertEquals((new PlateauSize(5, 5)).getMaxX(), Parser.parseSize(plateauSize).getMaxX());
    }

    @Test
    public void parsePosition() {
        String[] position = {"1" ,"2","N"};
        assertEquals((new Position(1, 2, 'N')).getX(), Parser.parsePosition(position).getX());
    }
}
