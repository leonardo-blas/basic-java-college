class DateProfile
{
    private char gender;
    private char searchGender;
    private int romance;
    private int finance;
    private String name;

    public static final int MIN_ROMANCE = 1;
    public static final int MAX_ROMANCE = 10;
    public static final int MIN_FINANCE = 1;
    public static final int MAX_FINANCE = 10;
    public static final int MIN_NAME_LEN = 1;
    public static final int MAX_NAME_LEN = 50;


    public static final char DEFAULT_GENDER  = 'M';
    public static final char DEFAULT_SEARCH_GENDER  = 'F';
    public static final int DEFAULT_ROMANCE = 1;
    public static final int DEFAULT_FINANCE = 1;
    public static final String DEFAULT_NAME = "No Name";

    public DateProfile(char g, char s, int r, int f, String n)
    {
        setDefaults();
        setAll(g, s, r, f, n);
    }

    public DateProfile()
    {
        setDefaults();
    }

    public void setDefaults()
    {
        gender = DEFAULT_GENDER;
        searchGender = DEFAULT_SEARCH_GENDER;
        finance = DEFAULT_FINANCE;
        romance = DEFAULT_ROMANCE;
        name = DEFAULT_NAME;
    }

    public void setAll(char g, char s, int r, int f, String n)
    {
        setGender(g);
        setSearchGender(s);
        setRomance(r);
        setFinance(f);
        setName(n);
    }

    private static boolean validGender(char g)
    {
        char checkGender = Character.toLowerCase(g);
        if (checkGender != 'm' && checkGender != 'f')
        {
            return false;
        }
        return true;
    }

    public boolean setGender(char g)
    {
        if (!validGender(g))
        {
            return false;
        }
        gender = Character.toUpperCase(g);
        return true;
    }

    public boolean setSearchGender(char g)
    {
        if (!validGender(g))
        {
            return false;
        }
        searchGender = Character.toUpperCase(g);
        return true;
    }

    public boolean setRomance(int rvalue)
    {
        if (MIN_ROMANCE > rvalue || MAX_ROMANCE < rvalue)
        {
            return false;
        }
        romance = rvalue;
        return true;
    }

    public boolean setFinance(int fvalue)
    {
        if (MIN_FINANCE > fvalue || MAX_FINANCE < fvalue)
        {
            return false;
        }
        finance = fvalue;
        return true;
    }

    public boolean setName(String n)
    {
        if (MIN_NAME_LEN > n.length() || MAX_NAME_LEN < n.length())
        {
            return false;
        }
        name = n;
        return true;
    }

    public char getGender()
    {
        return gender;
    }

    public char getSearchGender()
    {
        return searchGender;
    }

    public int getRomance()
    {
        return romance;
    }

    public int getFinance()
    {
        return finance;
    }

    String getName()
    {
        return name;
    }

    private double determineGenderFit(DateProfile partner)
    {
        if (gender != partner.searchGender)
        {
            return 0.0;
        }
        if (searchGender != partner.gender)
        {
            return 0.0;
        }
        return 1.0;
    }

    //Because of the defaults, romance and finance are always greater than 1. My equations will always give 0.1 as a minimum.
    private double determineRomanceFit(DateProfile partner)
    {
        double profileRomance, partnerRomance, deltaRomance, fitRomance;

        profileRomance = romance;
        partnerRomance = partner.romance;
        deltaRomance = Math.abs(profileRomance - partnerRomance);
        if(deltaRomance == 0)
        {
            fitRomance = 1;
        }
        else
        {
            fitRomance = 1 - Math.abs(deltaRomance / 10);
        }
        return fitRomance;
    }

    private double determineFinanceFit(DateProfile partner)
    {
        double profileFinance, partnerFinance, deltaFinance, fitFinance;

        profileFinance = finance;
        partnerFinance = partner.finance;
        deltaFinance = Math.abs(profileFinance - partnerFinance);
        if(deltaFinance == 0)
        {
            fitFinance = 1;
        }
        else
        {
            fitFinance = 1 - Math.abs(deltaFinance / 10);
        }
        return fitFinance;
    }

    public double fitValue(DateProfile partner)
    {
        double determinedGender, determinedRomance, determinedFinance, determinedTotal;

        determinedGender = determineGenderFit(partner);
        determinedRomance = determineRomanceFit(partner);
        determinedFinance = determineFinanceFit(partner);
        determinedTotal = (determinedRomance + determinedFinance)/2 * determinedGender;
        return determinedTotal;
    }
}

public class DatingFit
{
    public static void main(String[] args)
    {
        DateProfile

                p1 = new DateProfile('f', 'm', 7, 3, "Pink Whale"),
                p2 = new DateProfile('m', 'm', 6, 2, "Lazy Slug"),
                p3 = new DateProfile('f', 'm', 10, 1, "Fat Pupperina"),
                p4 = new DateProfile('m', 'f', 4, 7, "Striped Cat");

        displayTwoProfiles(p1, p1);
        displayTwoProfiles(p1, p2);
        displayTwoProfiles(p1, p3);
        displayTwoProfiles(p1, p4);

        displayTwoProfiles(p2, p1);
        displayTwoProfiles(p2, p2);
        displayTwoProfiles(p2, p3);
        displayTwoProfiles(p2, p4);

        displayTwoProfiles(p3, p1);
        displayTwoProfiles(p3, p2);
        displayTwoProfiles(p3, p3);
        displayTwoProfiles(p3, p4);

        displayTwoProfiles(p4, p1);
        displayTwoProfiles(p4, p2);
        displayTwoProfiles(p4, p3);
        displayTwoProfiles(p4, p4);
    }

    public static void displayTwoProfiles( DateProfile profile1, DateProfile profile2 )
    {
        System.out.println("Fit between " + profile1.getName() + " and " + profile2.getName() + ":      " + profile1.fitValue(profile2));
    }
}


/*------------------------------------------------------------------

Fit between Pink Whale and Pink Whale:      0.0
Fit between Pink Whale and Lazy Slug:      0.0
Fit between Pink Whale and Fat Pupperina:      0.0
Fit between Pink Whale and Striped Cat:      0.6499999999999999
Fit between Lazy Slug and Pink Whale:      0.0
Fit between Lazy Slug and Lazy Slug:      1.0
Fit between Lazy Slug and Fat Pupperina:      0.0
Fit between Lazy Slug and Striped Cat:      0.0
Fit between Fat Pupperina and Pink Whale:      0.0
Fit between Fat Pupperina and Lazy Slug:      0.0
Fit between Fat Pupperina and Fat Pupperina:      0.0
Fit between Fat Pupperina and Striped Cat:      0.4
Fit between Striped Cat and Pink Whale:      0.6499999999999999
Fit between Striped Cat and Lazy Slug:      0.0
Fit between Striped Cat and Fat Pupperina:      0.4
Fit between Striped Cat and Striped Cat:      0.0

--------------------------------------------------------------------*/