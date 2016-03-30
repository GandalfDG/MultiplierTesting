/**
* Created by Jack on 3/29/2016.
* Generates a text file to test all possible
* 8-bit multiplication operations.
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestGenerator {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\jac5258\\Documents\\out.txt");
        FileWriter writer = new FileWriter(file);
        int upperBound = (int) java.lang.Math.pow(2, 8);

        for (int i = 0; i < upperBound; i++) {
            for (int j = 0; j < upperBound; j++) {

                String inputA = Integer.toBinaryString(i);
                String inputB = Integer.toBinaryString(j);
                String output = Integer.toBinaryString(i * j);
                
                inputA = "00000000".substring(inputA.length()) + inputA;
                inputB = "00000000".substring(inputB.length()) + inputB;
                output = "0000000000000000".substring(output.length()) + output;

                String line = inputA + " " + inputB + " " + output;
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
