import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.BufferedReader;

import java.util.ArrayList;

public class Main {
  public static int numberOfInstances(String string, char character) {
    int output = 0;
    int index = string.indexOf(character);
    while (index >= 0) {
      output++;
      index = string.indexOf(character, index+1);
    }

    return output;
  }
  public static void main (String args[]) throws Exception {
    // Open the file
    FileInputStream fstream = new FileInputStream("input.txt");
    BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

    String strLine;

    ArrayList<String> input = new ArrayList<String>();

    //Read File Line By Line
    while ((strLine = br.readLine()) != null)   {
      // Print the content on the console
      input.add(strLine);
    }

    //Close the input stream
    br.close();

    System.out.println(input);

    int doubles = 0;
    int triples = 0;

    for (String line : input) {
      boolean gotDouble = false;
      boolean gotTriple = false;
      for (int i = 0; i < line.length(); i++) {
        char c = line.charAt(i);
        int numInstances = numberOfInstances(line, c);
        if (numInstances == 2 && !gotDouble) {
          gotDouble = true;
          doubles++;
        } else if (numInstances == 3 && !gotTriple) {
          gotTriple = true;
          triples++;
        }
      }
    }

    int output = doubles * triples;
    System.out.println(output);
  }
}
