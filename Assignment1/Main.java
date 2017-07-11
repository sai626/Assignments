package Assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zemoso on 10/7/17.
 */
public class Main {

    public static void main(String args[]) throws IOException {
        FileFilter fileFilter=new FileFilter();

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter a regular expression to search. Enter -1 to exit");

        String str=br.readLine();
        while (!str.equals("-1")){
            fileFilter.displayFiles(str);
            System.out.println("Finished Listing....");
            System.out.println("\n");
            str=br.readLine();
        }
    }
}
