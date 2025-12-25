package util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class StringtoArray {
    public static String[] readfile(String filepath) throws IOException{   
        Path path=Paths.get(filepath);
        ArrayList<String> lines = new ArrayList<>(
                Files.readAllLines(path, StandardCharsets.UTF_8)
        );
        return lines.toArray(new String[0]);
    //     String file="C://Users//kowsh//OneDrive//Desktop//lexical//file.txt";
    //     String input = null;
    //     BufferedReader br;
    //     try {
    //         br = new BufferedReader(new FileReader(file));
    //         input=br.readLine();
    //     } 
    //     catch (FileNotFoundException ex) {
    //         System.getLogger(lexer.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
    //     }
    // }
    // public static char[] convert(String line){
    //     return line.toCharArray();
    }
    // public static void main(String[] args) throws IOException {
    //     // String input = readfile("file.txt");
    //     // char[] arr=convert(line);
    //     // System.out.println("array is "+line);
    //     String file ="c://Users//kowsh//OneDrive//Desktop//lexical//input//file.txt";
        
    //     // try {
    //     String[] fileLines = readfile(file);
    //     System.out.println("File successfully read.");

    //     for (String line : fileLines) {
    //         System.out.println(line);
    //     }
    //     // } 
    //     // catch (IOException e) {
    //     //     System.err.println("Error reading file: " + e.getMessage());
    //     //     e.printStackTrace();
    //     // }
    //     // catch (IOException e) {
    //     //     System.out.println("An error occurred while reading the file.");
    //     //     e.printStackTrace();
    //     // }
    //     // System.out.println(input);
    //     // return input;
    //     // char[] arr=line.toCharArray();
        
    // }
}