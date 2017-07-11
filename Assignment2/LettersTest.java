package Assignment2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zemoso on 10/7/17.
 */
public class LettersTest {
    @Test
    public void check() throws Exception {
        Letters letters=new Letters();
        assertTrue(letters.check("abcdeFGHiJkl m  noPQ  rs tuV WXyyz"));
        assertFalse(letters.check("kjdhkjcz"));
    }

}