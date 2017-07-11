package Assignment4;

import java.text.ParseException;

/**
 * Created by zemoso on 10/7/17.
 */
public class Main {

    public static void main(String args[]) throws ParseException {
        DateRange dateRange=new DateRange();

        dateRange.printDateRange("16-07-1998 27-06-2017");
        dateRange.printDateRange("13-02-1998 27-06-2017");
        dateRange.printDateRange("04-02-2016 04-04-2017");
        dateRange.printDateRange("04-05-2017 04-04-2017");
        dateRange.printDateRange("04-04-2015 04-04-2016");
        dateRange.printDateRange("04-04-2015 15-03-2016");
    }
}
