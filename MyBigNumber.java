/**
* Class MyBigNumber is the class to sum the 2 number with 2 number know as string
* Class sum is that to sum two number
*/

public class MyBigNumber { 

    /**
    * 2 string only contain number from 0 to 9
    * @param s1 is the first string
    * @param s2 is the second string
    * @return the result is sum of the s1 and s2
    */
    
    public String sum(final String s1, final String s2) { 
        String result = "";// the result value
        int str1 = s1.length(); // lenght of the 1st string
        int str2 = s2.length();	// lenght of the 2nd string 

        int max = (str1 > str2) ? str1 : str2;// Take the longest length of the 1st and 2nd string
        int sur = 0;// value save the projected value
    	char digit1 = '0'; // the value save the character is taken
        char digit2 = '0'; //
        int pos1;// the last postion of 1st string
        int pos2; // the last position of the 2nd string
    
        int tong = 0;// the value to sum the last digit of 2 number
        
        for (int i = 0; i < max; i++) { 
            pos1 = str1 - i - 1;// update the position of the number
            pos2 = str2 - i - 1; 
            
            if (pos1 >= 0) { 
                digit1 = s1.charAt(pos1); // take the last digit of the number
            } 
            if (pos2 >= 0) { 
                digit2 = s2.charAt(pos2); 
            } 

            tong = (digit1 - '0') + (digit2 - '0') + nho;// turn sting into number and then sum with the projected value 
            result += (tong % 10); // result'Take the value Tong / 10 and then sum into value result.
            sur = tong / 10;// update the projected number.
        }
        
        return result;
    }
}