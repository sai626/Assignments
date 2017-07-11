package Assignment3;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by zemoso on 10/7/17.
 */
public class PingTest {
    @Test
    public void medianTime() throws Exception {
        Ping ping=new Ping();
        assertNotNull(ping.medianTime("8.8.8.8"));
    }

}