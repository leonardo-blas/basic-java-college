import java.util.Scanner;

public class MaskString
{
    public static Scanner input = new Scanner(System.in);
    final static int MIN_STRING_LENGTH = 4;
    final static int MAX_STRING_LENGTH = 500;

    // masking method
    public static String maskCharacter(String theString, char keyCharacter)
    {
        final String dollarSymbol = "$";
        String maskString = "";
        for (int i = 0; i < theString.length(); i++)
        {
            if (theString.charAt(i) == keyCharacter)
            {
                maskString = maskString + dollarSymbol;
            }
            else
            {
                maskString = maskString + theString.charAt(i);
            }
        }
        return maskString;
    }

    // replacing method
    public static String removeCharacter(String theString, char keyCharacter)
    {
        String replaceString = "";
        for (int i = 0; i < theString.length(); i++)
        {
            if (theString.charAt(i) != keyCharacter)
            {
                replaceString = replaceString + theString.charAt(i);
            }
        }
        return replaceString;
    }

    // counting method
    public static int countKey(String theString, char keyCharacter)
    {
        int count = 0;
        for (int i = 0; i < theString.length(); i++)
        {
            if (theString.charAt(i) == keyCharacter)
            {
                count++;
            }
        }
        return count;
    }

    // key input
    public static char getKeyCharacter()
    {
        while (true)
        {
            System.out.print("Please enter a SINGLE character to act as key: ");
            String userInput = input.nextLine();
            if (userInput.length() == 1)
            {
                return userInput.charAt(0);
            }
        }
    }

    // string input
    public static String getString()
    {
        while (true)
        {
            System.out.println("Please enter a phrase or sentence >= " + MIN_STRING_LENGTH + " and <= " + MAX_STRING_LENGTH + " characters:");
            String userInput = input.nextLine();
            if (userInput.length() >= MIN_STRING_LENGTH && userInput.length() <= MAX_STRING_LENGTH)
            {
                return userInput;
            }
        }
    }

    // result
    public static void main(String[] args)
    {
        char key = getKeyCharacter();
        String string = getString();
        System.out.println("String with '" +key+ "' masked: ");
        System.out.println(maskCharacter(string,key));
        System.out.println("String with '" + key + "' removed:");
        System.out.println(removeCharacter(string,key));
        System.out.print("# " + key + "'s: ");
        System.out.println(countKey(string,key));
    }
}
/*----------SAMPLE RUNS---------

C:\Users\wibl25202\Desktop>java Assignment5
Please enter a SINGLE character to act as key: o
Please enter a phrase or sentence >= 4 and <= 500 characters:
doggerinoooooooooooOO
String with 'o' masked:
d$ggerin$$$$$$$$$$$OO
String with 'o' removed:
dggerinOO
# o's: 12

C:\Users\wibl25202\Desktop>java Assignment5
Please enter a SINGLE character to act as key: a
Please enter a phrase or sentence >= 4 and <= 500 characters:
CamelCase
String with 'a' masked:
C$melC$se
String with 'a' removed:
CmelCse
# a's: 2

C:\Users\wibl25202\Desktop>java Assignment5
Please enter a SINGLE character to act as key: e
Please enter a phrase or sentence >= 4 and <= 500 characters:
Stem Center
String with 'e' masked:
St$m C$nt$r
String with 'e' removed:
Stm Cntr
# e's: 3

C:\Users\wibl25202\Desktop>java Assignment5
Please enter a SINGLE character to act as key: tuna can
Please enter a SINGLE character to act as key: no
Please enter a SINGLE character to act as key: i
Please enter a phrase or sentence >= 4 and <= 500 characters:
chi
Please enter a phrase or sentence >= 4 and <= 500 characters:

Please enter a phrase or sentence >= 4 and <= 500 characters:
chihuahua
String with 'i' masked:
ch$huahua
String with 'i' removed:
chhuahua
# i's: 1

* ----------------------------*/