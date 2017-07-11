package Assignment3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by zemoso on 7/7/17.
 */
public class Ping {

    /**
     * This function pings the specified address. Takes 11 readings of the time taken and returns the
     * median of the times. If pinging the host gives error, it will continue to try pinging the host. If
     * the number of error reaches 20 times, this function will throw Error.
     * @param address The ip address of the host
     * @return the median time taken to ping
     * @throws IOException If error occurs while invoking system ping utility or if ping returns error more
     * than 20 times before it give the 11 readings
     */
    public double medianTime(String address) throws IOException {

        double[] time=new double[11];
        int error_count=0;

        //creating and starting the process
        Process p=new ProcessBuilder("ping", address).start();

        //Connecting the output stream of ping to input stream of the program
        BufferedReader result=new BufferedReader(new InputStreamReader(p.getInputStream()));

        String[] temp;

        result.readLine();
        int i=0;
        while(i<11){
            temp=result.readLine().split(" ");
            try {
                //Storing the time
                time[i] = Double.parseDouble(temp[temp.length - 2].substring(5));
                i++;
            }catch (Exception e){
                error_count++;
                if (error_count==20){
                    throw new IOException("Ping Error");
                }
            }
        }

        //Killing the process
        p.destroy();

        //Returning median time
        Arrays.sort(time);
        return time[5];

    }

    public static void main(String[] arg) {
        Ping p=new Ping();
        try {
            double time = p.medianTime("8.8.8.8");
            System.out.println("Median time taken to ping = " + time + " ms");
        }catch (Exception e){
            System.out.println("Error Occured");
        }
    }
}
