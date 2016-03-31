/**
* Created by Jack on 3/29/2016.
* Generates a text file to test all possible
* 8-bit multiplication operations. The inputs
* are written as 8 bit binary strings, and 
* the output as a 16 bit binary string.
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestGenerator {
    
	public static void main(String[] args) throws IOException {
        
		File file = new File("test.txt");
        FileWriter writer = new FileWriter(file);
        int upperBound = (int) java.lang.Math.pow(2, 8);

        for (int i = 0; i < upperBound; i++) {
            for (int j = 0; j < upperBound; j++) {
            	
            	// create all possible inputs and calculate outputs
                String inputA = Integer.toBinaryString(i);
                String inputB = Integer.toBinaryString(j);
                String output = Integer.toBinaryString(i * j);
                
                // pad inputs to 8 bits and output to 16 bits
                inputA = "00000000".substring(inputA.length()) + inputA; 
                inputB = "00000000".substring(inputB.length()) + inputB;
                output = "0000000000000000".substring(output.length()) + output;
                
                // build individual strings into a line separated by spaces
                String line = inputA + " " + inputB + " " + output;
                
                // write each line separated by a newline character
                try {
                    writer.write(line);
                    writer.write(System.lineSeparator());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        writer.close();
    }
}
