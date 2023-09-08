import java.util.Scanner;
public class SlotMachine
{
    public static Scanner in = new Scanner(System.in);
    private static int BAR_PROBABILITY = 38;
    private static int CHERRIES_PROBABILITY = 40;
    private static int SPACE_PROBABILITY = 7;
    private static int SEVEN_PROBABILITY = 15;


    public static void main(String[] args)
    {
        while (true)
        {
            int bet = getBet();
            TripleString thePull = pull();
            int multiplier = getPayMultiplier(thePull);
            int winnings = multiplier*bet;
            display(thePull, winnings);
        }
    }

    public static int getBet()
    {
        while (true)
        {
            System.out.println("Input a bet between $0 and $50.");
            if (in.hasNextInt())
            {
                int userInput = in.nextInt();
                if (userInput >= 0 && userInput <= 50)
                {
                    return userInput;
                }
            }
            in.nextLine();
        }
    }

    private static String randString()
    {
        int rand = (int) (Math.random() * 100);
        if (BAR_PROBABILITY + CHERRIES_PROBABILITY + SPACE_PROBABILITY + SEVEN_PROBABILITY != 100)
        {
            return "Probabilities invalid";
        }
        if (rand <= BAR_PROBABILITY)
        {
            return "BAR";
        }
        else if (rand < CHERRIES_PROBABILITY + BAR_PROBABILITY)
        {
            return "Cherries";
        }
        else if (rand < CHERRIES_PROBABILITY + BAR_PROBABILITY + SPACE_PROBABILITY)
        {
            return "(Space)";
        }
        else
        {
            return "7";
        }
    }

    public static TripleString pull()
    {
        TripleString tripleString = new TripleString();
        tripleString.setString1(randString());
        tripleString.setString2(randString());
        tripleString.setString3(randString());
        return tripleString;
    }

    public static void display(TripleString thePull, int winnings)
    {
        System.out.println(thePull.getString1() + " " + thePull.getString2() + " " + thePull.getString3());
        if (winnings == 0)
        {
            System.out.println("Sorry, you lose." + "\n");
        }
        else
        {
            System.out.println("Congratulations, you won $" + winnings + "." + "\n");
        }
    }

    public static int getPayMultiplier(TripleString thePull)
    {
        if (thePull.getString1().equals("Cherries") && !thePull.getString2().equals("Cherries"))
        {
            return 5;
        }
        else if (thePull.getString1().equals("Cherries") && thePull.getString2().equals("Cherries") && !thePull.getString3().equals("Cherries"))
        {
            return 15;
        }
        else if (thePull.getString1().equals("Cherries") && thePull.getString2().equals("Cherries") && thePull.getString3().equals("Cherries"))
        {
            return 30;
        }
        else if (thePull.getString1().equals("BAR") && thePull.getString2().equals("BAR") && thePull.getString3().equals("BAR"))
        {
            return 50;
        }
        else if (thePull.getString1().equals("7") && thePull.getString2().equals("7") && thePull.getString3().equals("7"))
        {
            return 100;
        }
        else
        {
            return 0;
        }
    }
}
class TripleString
{
    public static void main(String[]args)
    {
        // creating object
        TripleString x = new TripleString();

        // tests
        if(!x.setString1("Hello World"))
            System.out.println("Mutating string1 is not possible");
        else
            System.out.println("Mutating string1 successful");
        System.out.println("string1 = " + x.getString1());

        if(!x.setString2(""))
            System.out.println("Mutating string2 is not possible");
        else
            System.out.println("Mutating string2 successful");
        System.out.println("string2 = " + x.getString2());

        if(!x.setString3("Test"))
            System.out.println("Mutating string3 is not possible");
        else
            System.out.println("Mutating string3 successful");
        System.out.println("string3 = " + x.getString3());
    }

    public static final int MIN_LENGTH =1;
    public static final int MAX_LENGTH =50;
    public static final String DEFAULT_STRING = "(undefined)";

    private String string1;
    private String string2;
    private String string3;

    //constructor
    public TripleString()
    {
        string1 = DEFAULT_STRING;
        string2 = DEFAULT_STRING;
        string3 = DEFAULT_STRING;
    }

    // mutator
    public boolean setString1(String X)
    {
        if(!validString(X))
            return false;

        string1 = X;
        return true;
    }
    public boolean setString2(String X)
    {
        if(!validString(X))
            return false;

        string2 = X;
        return true;
    }
    public boolean setString3(String X)
    {
        if(!validString(X))
            return false;

        string3 = X;
        return true;
    }
    private boolean validString(String X)
    {
        if (X.length() < MIN_LENGTH || X.length() > MAX_LENGTH)
            return false;
        return true;
    }

    // accessor
    public String getString1()
    {
        return string1;
    }
    public String getString2()
    {
        return string2;
    }
    public String getString3()
    {
        return string3;
    }
}

/*--------------------------------------------

Cherries Cherries Cherries: Pulls 18, 40, 48
BAR BAR BAR: Pulls 50, 45, 36, 21, 4

Extra

SAMPLE RUNS:

Input a bet between $0 and $50.
50
BAR Cherries Cherries
Sorry, you lose.

Input a bet between $0 and $50.
50
BAR BAR Cherries
Sorry, you lose.

Input a bet between $0 and $50.
50
BAR BAR Cherries
Sorry, you lose.

Input a bet between $0 and $50.
0
BAR BAR BAR
Congratulations, you won $2500.

Input a bet between $0 and $50.
50
BAR 7 BAR
Sorry, you lose.

Input a bet between $0 and $50.
0
BAR (Space) Cherries
Sorry, you lose.

Input a bet between $0 and $50.
50
BAR Cherries Cherries
Sorry, you lose.

Input a bet between $0 and $50.
0
BAR Cherries (Space)
Sorry, you lose.

Input a bet between $0 and $50.
50
BAR (Space) Cherries
Sorry, you lose.

Input a bet between $0 and $50.
0
(Space) Cherries Cherries
Sorry, you lose.

Input a bet between $0 and $50.
50
BAR 7 BAR
Sorry, you lose.

Input a bet between $0 and $50.
0
7 7 Cherries
Sorry, you lose.

Input a bet between $0 and $50.
50
BAR Cherries Cherries
Sorry, you lose.

Input a bet between $0 and $50.
0
7 Cherries BAR
Sorry, you lose.

Input a bet between $0 and $50.
50
Cherries (Space) Cherries
Congratulations, you won $250.

Input a bet between $0 and $50.
0
Cherries 7 7
Congratulations, you won $250.

Input a bet between $0 and $50.
50
Cherries BAR Cherries
Congratulations, you won $250.

Input a bet between $0 and $50.
0
Cherries Cherries Cherries
Congratulations, you won $1500.

Input a bet between $0 and $50.
50
7 BAR Cherries
Sorry, you lose.

Input a bet between $0 and $50.
0
BAR 7 BAR
Sorry, you lose.

Input a bet between $0 and $50.
50
BAR BAR BAR
Congratulations, you won $2500.

Input a bet between $0 and $50.
0
7 BAR Cherries
Sorry, you lose.

Input a bet between $0 and $50.
50
Cherries Cherries 7
Congratulations, you won $750.

Input a bet between $0 and $50.
0
Cherries BAR Cherries
Congratulations, you won $250.

Input a bet between $0 and $50.
50
Cherries Cherries BAR
Congratulations, you won $750.

Input a bet between $0 and $50.
0
BAR 7 BAR
Sorry, you lose.

Input a bet between $0 and $50.
50
(Space) Cherries Cherries
Sorry, you lose.

Input a bet between $0 and $50.
0
7 BAR Cherries
Sorry, you lose.

Input a bet between $0 and $50.
50
Cherries Cherries BAR
Congratulations, you won $750.

Input a bet between $0 and $50.
0
7 BAR 7
Sorry, you lose.

Input a bet between $0 and $50.
50
7 BAR Cherries
Sorry, you lose.

Input a bet between $0 and $50.
0
Cherries BAR 7
Congratulations, you won $250.

Input a bet between $0 and $50.
50
(Space) BAR BAR
Sorry, you lose.

Input a bet between $0 and $50.
0
Cherries Cherries BAR
Congratulations, you won $750.

Input a bet between $0 and $50.
50
7 BAR Cherries
Sorry, you lose.

Input a bet between $0 and $50.
0
BAR BAR BAR
Congratulations, you won $2500.

Input a bet between $0 and $50.
50
BAR Cherries BAR
Sorry, you lose.

Input a bet between $0 and $50.
0
7 Cherries BAR
Sorry, you lose.

Input a bet between $0 and $50.
50
Cherries BAR BAR
Congratulations, you won $250.

Input a bet between $0 and $50.
0
Cherries Cherries Cherries
Congratulations, you won $1500.

Input a bet between $0 and $50.
50
7 Cherries (Space)
Sorry, you lose.

Input a bet between $0 and $50.
50
BAR BAR BAR
Congratulations, you won $2500.

Input a bet between $0 and $50.
0
Cherries (Space) Cherries
Congratulations, you won $250.

Input a bet between $0 and $50.
50
Cherries 7 (Space)
Congratulations, you won $250.

Input a bet between $0 and $50.
0
BAR 7 Cherries
Sorry, you lose.

Input a bet between $0 and $50.
50
BAR (Space) 7
Sorry, you lose.

Input a bet between $0 and $50.
50
Cherries BAR Cherries
Congratulations, you won $250.

Input a bet between $0 and $50.
50
Cherries Cherries Cherries
Congratulations, you won $1500.

Input a bet between $0 and $50.
50
BAR BAR Cherries
Sorry, you lose.

Input a bet between $0 and $50.
50
BAR BAR BAR
Congratulations, you won $2500.

Input a bet between $0 and $50.
pupper
Input a bet between $0 and $50.
Input a bet between $0 and $50.
pupper
Input a bet between $0 and $50.
pupperino
Input a bet between $0 and $50.

--------------------------------------------*/



