/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InputOutput;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author 13026
 */
public class Input {

public static void inputCSV() throws IOException {
       
    
try{

BufferedReader r = new BufferedReader(new FileReader("<filename>"));

String row = " ";
while (row != null){
row = r.readLine();
String[] values = row.split(",");
System.out.println(Arrays.toString(values));
// Send out the line?
}
}   
catch(FileNotFoundException e){
    System.out.println("File not found.");
    
}
catch(Exception e){
    e.printStackTrace();
}
}
}
