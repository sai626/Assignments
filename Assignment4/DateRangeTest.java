package Assignment4;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Created by zemoso on 10/7/17.
 */
public class DateRangeTest {


    @Test
    public void getDateRange() throws Exception {
        DateRange dateRange=new DateRange();

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
        Calendar[] cal=new Calendar[2];
        cal[0]=Calendar.getInstance();
        cal[1]=Calendar.getInstance();

        cal[0].setTime(simpleDateFormat.parse("16-06-2017"));
        cal[1].setTime(simpleDateFormat.parse("27-06-2017"));
        dateRange.parseDate("16-07-1998 27-06-2017");
        assertArrayEquals(cal,dateRange.getDateRange());

        cal[0].setTime(simpleDateFormat.parse("14-01-2017"));
        cal[1].setTime(simpleDateFormat.parse("15-03-2017"));
        dateRange.parseDate("13-02-1998 27-06-2017");
        assertArrayEquals(cal,dateRange.getDateRange());

        cal[0].setTime(simpleDateFormat.parse("05-01-2017"));
        cal[1].setTime(simpleDateFormat.parse("06-03-2017"));
        dateRange.parseDate("04-02-2016 04-04-2017");
        assertArrayEquals(cal,dateRange.getDateRange());

        cal[0].setTime(simpleDateFormat.parse("05-03-2016"));
        cal[1].setTime(simpleDateFormat.parse("04-04-2016"));
        dateRange.parseDate("04-04-2015 04-04-2016");
        assertArrayEquals(cal,dateRange.getDateRange());

        cal[0].setTime(simpleDateFormat.parse("05-03-2016"));
        cal[1].setTime(simpleDateFormat.parse("15-03-2016"));
        dateRange.parseDate("04-04-2015 15-03-2016");
        assertArrayEquals(cal,dateRange.getDateRange());
    }



}