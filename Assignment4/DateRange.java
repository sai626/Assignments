package Assignment4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by zemoso on 10/7/17.
 */
public class DateRange {

    private Calendar signup,current;
    private SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");

    /**
     * Parses a sting containing 2 space separated dates with format dd-MM-yyyy
     * @param input The string to be parsed
     * @throws ParseException If the string cannot be converted to 2 calendar object of the specified format
     */
    public void parseDate(String input) throws ParseException {
        signup=Calendar.getInstance();
        current=Calendar.getInstance();

        String[] temp=input.split(" ");

        signup.setTime(simpleDateFormat.parse(temp[0]));
        current.setTime(simpleDateFormat.parse(temp[1]));
    }

    /**
     * Returns the date range as array of calender object according to KYC specification
     * @return An array of calendar object where 1st element represents starting date and 2nd element
     * represents end date
     * @throws IndexOutOfBoundsException Is thrown when the date range lies in future to current date
     */
    public Calendar[] getDateRange() throws IndexOutOfBoundsException{
        Calendar[] range=new Calendar[2];
        Calendar kyc_start,kyc_end;

        kyc_start= (Calendar) signup.clone();
        kyc_start.set(Calendar.YEAR,current.get(Calendar.YEAR));
        kyc_start.add(Calendar.DAY_OF_MONTH,-30);

        kyc_end= (Calendar) signup.clone();
        kyc_end.set(Calendar.YEAR,current.get(Calendar.YEAR));
        kyc_end.add(Calendar.DATE,30);

        if (current.after(kyc_start)){
            range[0]=kyc_start;
            if (current.after(kyc_end)){
                range[1]=kyc_end;
            }else {
                range[1]=current;
            }
        }else {
            throw new IndexOutOfBoundsException("KYC date in future");
        }
        return range;
    }

    /**
     * Prints the date range in the format dd-MM-yyyy
     * @param str The input string containing the KYC signup date and the current date. The string must
     * be formatted as dd-MM-yyyy with a space between the two dates.
     * @throws ParseException Is thrown when the string can not be parsed to dates.
     */
    public void printDateRange(String str) throws ParseException {
        parseDate(str);
        try {
            Calendar[] cal = getDateRange();
            StringBuilder s=new StringBuilder(simpleDateFormat.format(cal[0].getTime()));
            s.append(" ");
            s.append(simpleDateFormat.format(cal[1].getTime()));

            System.out.println(s);
        }catch (IndexOutOfBoundsException e){
            System.out.println("No Range");
        }
    }

}
