// creating class
public class TripleString
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
    public boolean setString1(String stringerino)
    {
        if(!validString(stringerino))
            return false;

        string1 = stringerino;
        return true;
    }
    public boolean setString2(String stringerino)
    {
        if(!validString(stringerino))
            return false;

        string2 = stringerino;
        return true;
    }
    public boolean setString3(String stringerino)
    {
        if(!validString(stringerino))
            return false;

        string3 = stringerino;
        return true;
    }
    private boolean validString(String stringerino)
    {
        if (stringerino.length() < MIN_LENGTH || stringerino.length() > MAX_LENGTH)
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
/*---------------------------
Mutating string1 successful
string1 = Hello World
Mutating string2 is not possible
string2 = (undefined)
Mutating string3 successful
string3 = Test
 --------------------------*/