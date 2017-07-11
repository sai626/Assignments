package Assignment2;

/**
 * Created by zemoso on 7/7/17.
 */
public class Letters {

    /**
     * This function keeps track of the letters present by a boolean array. If a character is present it
     * sets corresponding value to true.
     * @param str The string to check for characters
     * @return true if all characters a-z (case-insensitive) are present else false
     */
    public boolean check(String str){
        boolean[] presence=new boolean[26];

        for (char ch:str.toLowerCase().toCharArray()){
            try {
                presence[ch - 97] = true;
            }catch (Exception e){}
        }

        for(int i=0;i<26;i++){
            if (!presence[i]){
                return false;
            }
        }
        return true;
    }
}
