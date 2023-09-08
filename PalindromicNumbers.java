public class PalindromicNumbers
{
    public static void main(String[] args)
    {
        // creating variables
        int a, b, numA = 0, numB = 0;
        int maxNumber = 0;
        int firstDigit, secondDigit, thirdDigit, fourthDigit, fifthDigit, sixthDigit;
        int firstDigitMath, secondDigitMath, thirdDigitMath, fourthDigitMath, fifthDigitMath, sixthDigitMath;

        // counting loop
        for (a = 100; a <= 999; a = a + 1)
        {
            for (b = 100; b <= 999; b = b + 1)
            {
                // separating the product into digits (math)
                firstDigitMath = (a*b/100000);
                secondDigitMath = (a*b/10000);
                thirdDigitMath = (a*b/1000);
                fourthDigitMath = (a*b/100);
                fifthDigitMath = (a*b/10);
                sixthDigitMath = (a*b);

                // separating the product into digits, continuation
                firstDigit = firstDigitMath;
                secondDigit = secondDigitMath-(firstDigitMath*10);
                thirdDigit = thirdDigitMath-(secondDigitMath*10);
                fourthDigit = fourthDigitMath-(thirdDigitMath*10);
                fifthDigit = fifthDigitMath-(fourthDigitMath*10);
                sixthDigit = sixthDigitMath-(fifthDigitMath*10);

                // creating conditions (stating what a palindromic number is)
                if ((firstDigit == sixthDigit)&&(secondDigit == fifthDigit)&&(thirdDigit == fourthDigit)&&(firstDigit != 0))
                {
                    // storing the maximum palindromic number and its factors
                    if (a*b > maxNumber)
                    {
                        maxNumber = a*b;
                        numA = a;
                        numB = b;
                    }
                }

                if ((firstDigit == 0)&&(secondDigit == sixthDigit)&&(thirdDigit == fifthDigit)&&(secondDigit != 0))
                {
                    if (a*b > maxNumber)
                    {
                        maxNumber = a*b;
                        numA = a;
                        numB = b;
                    }
                }

                if ((firstDigit == 0)&&(secondDigit == 0)&&(thirdDigit == sixthDigit)&&(fourthDigit == fifthDigit)&&(thirdDigit != 0))
                {
                    if (a*b > maxNumber)
                    {
                        maxNumber = a*b;
                        numA = a;
                        numB = b;
                    }
                }

                if ((firstDigit == 0)&&(secondDigit == 0)&&(thirdDigit == 0)&&(fourthDigit == sixthDigit)&&(fourthDigit != 0))
                {
                    if (a*b > maxNumber)
                    {
                        maxNumber = a*b;
                        numA = a;
                        numB = b;
                    }
                }

                if ((firstDigit == 0)&&(secondDigit == 0)&&(thirdDigit == 0)&&(fourthDigit == 0)&&(fifthDigit == sixthDigit)&&(fifthDigit != 0))
                {
                    if (a*b > maxNumber)
                    {
                        maxNumber = a*b;
                        numA = a;
                        numB = b;
                    }
                }
            }
        }
        // printing the result
        System.out.println("The maximum palindromic number found is " + maxNumber);
        System.out.println("Number 1 = " + numA);
        System.out.println("Number 2 = " + numB);
    }
}

/*---------- SAMPLE RUN ----------

C:\Users\wibl25202.VDI\Desktop>java Assignment4
The maximum palindromic number found is 906609
Number 1 = 913
Number 2 = 993

--------------------------------*/ 