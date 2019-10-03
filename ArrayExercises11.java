/********************************************************************
 * Programmer: Lauren
 * 
 * Class: CS20S
 *
 * Assignment: Array Exercises 1 Q1-5
 *
 * Description: brief description of program.
 ***********************************************************************/
 
 // import java libraries here as needed
 
 import javax.swing.*;
 //import java.text.DecimalFormat;
 import java.io.*;

public class ArrayExercises11 {  // begin class
    
    public static void main(String[] args)throws IOException {  // begin main
    
    // ********* declaration of constants **********
    
    // ********** declaration of variables **********

        String strin;				// string data input from keyboard
        String strout;				// processed info string to be output
        String bannerOut;			// string to print banner to message dialogs

        String prompt;				// prompt for use in input dialogs

        String delim = "";		        // delimiter string for splitting input string
        String[] tokens;                        // string array for gathering input
        
        String nl = System.lineSeparator();     // new line character for file writing
        
        int numofnum = 0;                       // quantity of numbers entered
        int place = 0;                          // place of the digit
        int[] array;                            // array of numbers
        
        int lowest = 9;                         // lowest number in the array
        int highest = 0;                        // highest number in the array
        
        char answer = 'y';                      // answer of "would you like to modify any digits?"
    	
    // ***** create objects *******
    
        //Scanner scanner = new Scanner(System.in);
        //DecimalFormat df1 = new DecimalFormat("##.###");
        
        // file IO buffers, for reading data form a text file and writing output to 
        // a text file  
        //BufferedReader fin = new BufferedReader(new FileReader("demo1Data.txt"));
        PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("outFile.txt")));
    	
    // ********** Print output Banner **********

        System.out.println("*******************************************");
        System.out.println("Name: Lauren");
        System.out.println("Class: CS20S");
        System.out.println("Assignment:	Array Exercises 1 Q1-5");
        System.out.println("*******************************************");

        bannerOut = "*******************************************" + nl;
        bannerOut += "Name: Lauren" + nl;
        bannerOut += "Class: CS20S" + nl;
        bannerOut += "Assignment: Array Exercises 1 Q1-5" + nl;
        bannerOut += "*******************************************" + nl + nl;
        
        fout.print(bannerOut);		// prints the banner to the output text file
    	
    // ************************ get input **********************
    
        prompt = "How many numbers do you want to enter?";
        strin = JOptionPane.showInputDialog(bannerOut + prompt);
        numofnum = Integer.parseInt(strin);
        
        array = new int [numofnum];
        
        prompt = "Enter your numbers.";
        strin = JOptionPane.showInputDialog(bannerOut + prompt);
        JOptionPane.showMessageDialog(null, bannerOut + "You entered: " + strin);
        
    // ************************ processing ***************************

        place = 0; // set place to 0
        
        for(int i = place; i < numofnum; i ++){
            tokens = strin.split(delim);
            array[i] = Integer.parseInt(tokens[i]); // parse array
    } //end load array
        
    // ************************ print output ****************************
    
        System.out.print("Array: ");
    
            for (int i = place; i < numofnum; i++){
        System.out.print(array[i]);
    } //end print array forwards
        
        place = numofnum - 1; // set place to sub place
        
        System.out.print("\n");
        
        System.out.print("Array backwards: ");
        
            for (int i = place; i >= 0; i--){
        System.out.print(array[i]);
    } //end print array backwards
    
        System.out.print("\n");
        
        prompt = "Which digit do you want to print? Enter -1 to end.";
        strin = JOptionPane.showInputDialog(bannerOut + prompt);
        
        place = Integer.parseInt(strin); // parse place
        
        while(place != -1){
            
            System.out.print("Digit " + place + ": ");
                                
            place --; // set place to sub place
            
            System.out.println(array[place]);
            
            prompt = "Which digit do you want to print? Enter -1 to end.";
            strin = JOptionPane.showInputDialog(bannerOut + prompt);
            
            place = Integer.parseInt(strin); // parse place
        } // end print digits
        
        System.out.print("\n");
        
        prompt = "Would you like to modify any digits?";
        strin = JOptionPane.showInputDialog(bannerOut + prompt);
        
        tokens = strin.split(delim);
        answer = tokens[0].charAt(0); // parse answer
        
        while(answer == 'y'){
            prompt = "Which digit do you want to modify?";
            strin = JOptionPane.showInputDialog(bannerOut + prompt);
            
            place = Integer.parseInt(strin) - 1; // subtract to set place to sub place
            
            prompt = "What would you like to change it to?";
            strin = JOptionPane.showInputDialog(bannerOut + prompt);
            
            array[place] = Integer.parseInt(strin); // parse modified array digit
            
            place = 0; // reset place 
            
            System.out.print("Array: ");
            
            for (int i = place; i < numofnum; i++){
        System.out.print(array[i]);
    } //end print new array forwards
        
            place = numofnum - 1; // subtract to get sub place
        
            System.out.print("\n");
        
            System.out.print("Array backwards: ");
        
            for (int i = place; i >= 0; i--){
        System.out.print(array[i]);
    } //end print new array backwards
        
        System.out.print("\n");
        
        prompt = "Would you like to modify any more digits?";
        strin = JOptionPane.showInputDialog(bannerOut + prompt);
        
        tokens = strin.split(delim);
        answer = tokens[0].charAt(0); // parse answer
        } // end modify digits
        
        place = 0; // set place to 0
        
        for(int i = place; i < numofnum; i ++){
            if(array[i] > highest){
                highest = array[i];
            } else{
                
            }// end highest
            if(array[i] < lowest){
                lowest = array[i];
            }else{
                
            }// end lowest
        }// end highest and lowest
        
        System.out.println("Lowest number: " + lowest);
        System.out.println("Highest number: " + highest);
        
        
    // ******** closing message *********
        
        System.out.println("\nend of processing :)");
        fout.println("end of processing :)");
        
    // ***** close streams *****
        
        //fin.close();      // close input buffer stream
        fout.close();       // close output stream, note that nothing is printed 
                            // to the output file until the stream is closed		
        
    }  // end main
}  // end class
