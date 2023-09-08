import java.util.Scanner;

public class CookingAndNutrition
{
    // ingredient 1 constants
    static final String INGREDIENT_1_NAME = "Olive oil";
    static final int INGREDIENT_1_PROTEIN_P100G = 0;
    static final int INGREDIENT_1_CARBOHYDRATES_P100G = 0;
    static final int INGREDIENT_1_FAT_P100G = 100;
    static final int INGREDIENT_1_CALORIES_P100G = 884;
    static final int INGREDIENT_1_OMEGA3_P100G = 761;

    // ingredient 2 constants
    static final String INGREDIENT_2_NAME = "Fresh basil leaves";
    static final double INGREDIENT_2_PROTEIN_P100G = 3.2;
    static final double INGREDIENT_2_CARBOHYDRATES_P100G = 2.7;
    static final double INGREDIENT_2_FAT_P100G = 0.6;
    static final int INGREDIENT_2_CALORIES_P100G = 23;
    static final int INGREDIENT_2_OMEGA3_P100G = 316;

    // ingredient 3 constants
    static final String INGREDIENT_3_NAME = "Raw farmed Atlantic salmon";
    static final double INGREDIENT_3_PROTEIN_P100G = 20.4;
    static final int INGREDIENT_3_CARBOHYDRATES_P100G = 0;
    static final double INGREDIENT_3_FAT_P100G = 13.4;
    static final int INGREDIENT_3_CALORIES_P100G = 208;
    static final int INGREDIENT_3_OMEGA3_P100G = 2506;

    // ingredient 4 constants
    static final String INGREDIENT_4_NAME = "Raw garlic";
    static final double INGREDIENT_4_PROTEIN_P100G = 6.4;
    static final double INGREDIENT_4_CARBOHYDRATES_P100G = 33.1;
    static final double INGREDIENT_4_FAT_P100G = 0.5;
    static final int INGREDIENT_4_CALORIES_P100G = 149;
    static final int INGREDIENT_4_OMEGA3_P100G = 20;

    // ingredient 5 constants
    static final String INGREDIENT_5_NAME = "Cooked whole-wheat spaghetti";
    static final double INGREDIENT_5_PROTEIN_P100G = 5.3;
    static final double INGREDIENT_5_CARBOHYDRATES_P100G = 26.5;
    static final double INGREDIENT_5_FAT_P100G = 0.5;
    static final int INGREDIENT_5_CALORIES_P100G = 124;
    static final int INGREDIENT_5_OMEGA3_P100G = 10;

    // ingredient 6 constants
    static final String INGREDIENT_6_NAME = "Parmigiano Reggiano cheese";
    static final double INGREDIENT_6_PROTEIN_P100G = 32.4;
    static final double INGREDIENT_6_CARBOHYDRATES_P100G = 0;
    static final double INGREDIENT_6_FAT_P100G = 29.7;
    static final int INGREDIENT_6_CALORIES_P100G = 402;
    static final int INGREDIENT_6_OMEGA3_P100G = 0;

    public static void main(String[] args)
    {
        String recipe, userInputStr;
        int servings;
        double quantity;
        double totalProtein, totalCarbs, totalFat, totalCals, totalOmega3;
        double maxQuantity, minQuantity, maxServings, minServings;
        Scanner inputStream = new Scanner(System.in);

        // limits
        maxQuantity = 1500;
        minQuantity = 0;
        maxServings = 9;
        minServings = 2;

        // initialize accumulator variables
        totalProtein = 0;
        totalCarbs = 0;
        totalFat = 0;
        totalCals = 0;
        totalOmega3 = 0;

        // print menu
        System.out.println("---------- List of ingredients ---------" + "\n");
        System.out.println("* Ingredient 1: " + INGREDIENT_1_NAME);
        System.out.println("* Ingredient 2: " + INGREDIENT_2_NAME);
        System.out.println("* Ingredient 3: " + INGREDIENT_3_NAME);
        System.out.println("* Ingredient 4: " + INGREDIENT_4_NAME);
        System.out.println("* Ingredient 5: " + INGREDIENT_5_NAME);
        System.out.println("* Ingredient 6: " + INGREDIENT_6_NAME + "\n");

        // name of dish scanner
        System.out.print("What are you calling this recipe? ");
        recipe = inputStream.nextLine();

        // servings scanner
        System.out.print("How many servings do you need? ");
        userInputStr = inputStream.nextLine();
        servings = Integer.parseInt(userInputStr);

        // servings conditionals
        if((servings > maxServings)||(servings < minServings))
        {
            System.out.println("The number of servings must be between 2 and 9.");
            return;
        }

        // ingredient 1 scanner
        System.out.print("How many grams of " + INGREDIENT_1_NAME + "? ");
        userInputStr = inputStream.nextLine();
        quantity = Double.parseDouble(userInputStr);

        // ingredient 1 conditionals
        if((quantity > maxQuantity)||(quantity < minQuantity))
        {
            System.out.println("The mass of the ingredients must be between 0 and 1500 grams");
            return;
        }

        // update accumulators 1
        totalProtein += quantity * ((INGREDIENT_1_PROTEIN_P100G/100.)/servings);
        totalCarbs += quantity * ((INGREDIENT_1_CARBOHYDRATES_P100G/100.)/servings);
        totalFat += quantity * ((INGREDIENT_1_FAT_P100G/100.)/servings);
        totalCals += quantity * ((INGREDIENT_1_CALORIES_P100G / 100.)/servings);
        totalOmega3  += quantity * ((INGREDIENT_1_OMEGA3_P100G / 100.)/servings);

        // ingredient 2 scanner
        System.out.print("How many grams of " + INGREDIENT_2_NAME + "? ");
        userInputStr = inputStream.nextLine();
        quantity = Double.parseDouble(userInputStr);

        // ingredient 2 conditionals
        if((quantity > 1500)||(quantity < 0))
        {
            System.out.println("The mass of the ingredients must be between 0 and 1500 grams");
            return;
        }

        // update accumulators 2
        totalProtein += quantity * ((INGREDIENT_2_PROTEIN_P100G/100.)/servings);
        totalCarbs += quantity * ((INGREDIENT_2_CARBOHYDRATES_P100G/100.)/servings);
        totalFat += quantity * ((INGREDIENT_2_FAT_P100G/100.)/servings);
        totalCals += quantity * ((INGREDIENT_2_CALORIES_P100G / 100.)/servings);
        totalOmega3  += quantity * ((INGREDIENT_2_OMEGA3_P100G / 100.)/servings);

        // ingredient 3 scanner
        System.out.print("How many grams of " + INGREDIENT_3_NAME + "? ");
        userInputStr = inputStream.nextLine();
        quantity = Double.parseDouble(userInputStr);

        // ingredient 3 conditionals
        if((quantity > 1500)||(quantity < 0))
        {
            System.out.println("The mass of the ingredients must be between 0 and 1500 grams");
            return;
        }

        // update accumulators 3
        totalProtein += quantity * ((INGREDIENT_3_PROTEIN_P100G/100.)/servings);
        totalCarbs += quantity * ((INGREDIENT_3_CARBOHYDRATES_P100G/100.)/servings);
        totalFat += quantity * ((INGREDIENT_3_FAT_P100G/100.)/servings);
        totalCals += quantity * ((INGREDIENT_3_CALORIES_P100G / 100.)/servings);
        totalOmega3  += quantity * ((INGREDIENT_3_OMEGA3_P100G / 100.)/servings);

        // ingredient 4 scanner
        System.out.print("How many grams of " + INGREDIENT_4_NAME + "? ");
        userInputStr = inputStream.nextLine();
        quantity = Double.parseDouble(userInputStr);

        // ingredient 4 conditionals
        if((quantity > 1500)||(quantity < 0))
        {
            System.out.println("The mass of the ingredients must be between 0 and 1500 grams");
            return;
        }

        // update accumulators 4
        totalProtein += quantity * ((INGREDIENT_4_PROTEIN_P100G/100.)/servings);
        totalCarbs += quantity * ((INGREDIENT_4_CARBOHYDRATES_P100G/100.)/servings);
        totalFat += quantity * ((INGREDIENT_4_FAT_P100G/100.)/servings);
        totalCals += quantity * ((INGREDIENT_4_CALORIES_P100G / 100.)/servings);
        totalOmega3  += quantity * ((INGREDIENT_4_OMEGA3_P100G / 100.)/servings);

        // ingredient 5 scanner
        System.out.print("How many grams of " + INGREDIENT_5_NAME + "? ");
        userInputStr = inputStream.nextLine();
        quantity = Double.parseDouble(userInputStr);

        // ingredient 5 conditionals
        if((quantity > 1500)||(quantity < 0))
        {
            System.out.println("The mass of the ingredients must be between 0 and 1500 grams");
            return;
        }

        // update accumulators 5
        totalProtein += quantity * ((INGREDIENT_5_PROTEIN_P100G/100.)/servings);
        totalCarbs += quantity * ((INGREDIENT_5_CARBOHYDRATES_P100G/100.)/servings);
        totalFat += quantity * ((INGREDIENT_5_FAT_P100G/100.)/servings);
        totalCals += quantity * ((INGREDIENT_5_CALORIES_P100G / 100.)/servings);
        totalOmega3  += quantity * ((INGREDIENT_5_OMEGA3_P100G / 100.)/servings);

        // ingredient 6 scanner
        System.out.print("How many grams of " + INGREDIENT_6_NAME + "? ");
        userInputStr = inputStream.nextLine();
        quantity = Double.parseDouble(userInputStr);

        // ingredient 6 conditionals
        if((quantity > 1500)||(quantity < 0))
        {
            System.out.println("The mass of the ingredients must be between 0 and 1500 grams");
            return;
        }

        // update accumulators 6
        totalProtein += quantity * ((INGREDIENT_6_PROTEIN_P100G/100.)/servings);
        totalCarbs += quantity * ((INGREDIENT_6_CARBOHYDRATES_P100G/100.)/servings);
        totalFat += quantity * ((INGREDIENT_6_FAT_P100G/100.)/servings);
        totalCals += quantity * ((INGREDIENT_6_CALORIES_P100G / 100.)/servings);
        totalOmega3  += quantity * ((INGREDIENT_6_OMEGA3_P100G / 100.)/servings);

        // report results
        System.out.println("\nNutritional facts for 1 serving of " + recipe + ":");
        System.out.println("Protein: " + totalProtein + " grams");
        System.out.println("Carbohydrates: " + totalCarbs + " grams");
        System.out.println("Fat: " + totalFat + " grams");
        System.out.println("Calories: " + totalCals + " calories");
        System.out.println("Omega 3: " + totalOmega3 + " mg");
    }
}

/*
                Testing 1:

                C:\Users\psmeguest\Desktop>java Assignment3
                ---------- List of ingredients ---------

                * Ingredient 1: Olive oil
                * Ingredient 2: Fresh basil leaves
                * Ingredient 3: Raw farmed Atlantic salmon
                * Ingredient 4: Raw garlic
                * Ingredient 5: Cooked whole-wheat spaghetti
                * Ingredient 6: Parmigiano Reggiano cheese

                What are you calling this recipe? Pesto pasta and sauteed salmon
                How many servings do you need? 6
                How many grams of Olive oil? 30
                How many grams of Fresh basil leaves? 25
                How many grams of Raw farmed Atlantic salmon? 500
                How many grams of Raw garlic? 10
                How many grams of Cooked whole-wheat spaghetti? 500
                How many grams of Parmigiano Reggiano cheese? 30

                Nutritional facts for 1 serving of Pesto pasta and sauteed salmon:
                Protein: 23.276666666666664 grams
                Carbohydrates: 22.7475 grams
                Fat: 18.101666666666667 grams
                Calories: 344.40833333333336 calories
                Omega 3: 2148.216666666667 mg


                Testing 2:

                C:\Users\psmeguest\Desktop>java Assignment3
                ---------- List of ingredients ---------

                * Ingredient 1: Olive oil
                * Ingredient 2: Fresh basil leaves
                * Ingredient 3: Raw farmed Atlantic salmon
                * Ingredient 4: Raw garlic
                * Ingredient 5: Cooked whole-wheat spaghetti
                * Ingredient 6: Parmigiano Reggiano cheese

                What are you calling this recipe? Salmon Sashimi
                How many servings do you need? 2
                How many grams of Olive oil? 0
                How many grams of Fresh basil leaves? 0
                How many grams of Raw farmed Atlantic salmon? 100
                How many grams of Raw garlic? 0
                How many grams of Cooked whole-wheat spaghetti? 0
                How many grams of Parmigiano Reggiano cheese? 0

                Nutritional facts for 1 serving of Salmon sashimi:
                Protein: 10.2 grams
                Carbohydrates: 0.0 grams
                Fat: 6.7 grams
                Calories: 104.0 calories
                Omega 3: 1253.0 mg


                Testing 3:

                C:\Users\psmeguest\Desktop>java Assignment3
                ---------- List of ingredients ---------

                * Ingredient 1: Olive oil
                * Ingredient 2: Fresh basil leaves
                * Ingredient 3: Raw farmed Atlantic salmon
                * Ingredient 4: Raw garlic
                * Ingredient 5: Cooked whole-wheat spaghetti
                * Ingredient 6: Parmigiano Reggiano cheese

                What are you calling this recipe? Pesto sauce
                How many servings do you need? 6
                How many grams of Olive oil? 30
                How many grams of Fresh basil leaves? 25
                How many grams of Raw farmed Atlantic salmon? 0
                How many grams of Raw garlic? 10
                How many grams of Cooked whole-wheat spaghetti? 0
                How many grams of Parmigiano Reggiano cheese? 30

                Nutritional facts for 1 serving of Pesto sauce:
                Protein: 1.8599999999999999 grams
                Carbohydrates: 0.6641666666666668 grams
                Fat: 6.518333333333334 grams
                Calories: 67.74166666666667 calories
                Omega 3: 51.550000000000004 mg


                Testing 4:

                C:\Users\psmeguest\Desktop>java Assignment3
                ---------- List of ingredients ---------

                * Ingredient 1: Olive oil
                * Ingredient 2: Fresh basil leaves
                * Ingredient 3: Raw farmed Atlantic salmon
                * Ingredient 4: Raw garlic
                * Ingredient 5: Cooked whole-wheat spaghetti
                * Ingredient 6: Parmigiano Reggiano cheese

                What are you calling this recipe? Basil salad
                How many servings do you need? 2
                How many grams of Olive oil? 15
                How many grams of Fresh basil leaves? 30
                How many grams of Raw farmed Atlantic salmon? 0
                How many grams of Raw garlic? 5
                How many grams of Cooked whole-wheat spaghetti? 0
                How many grams of Parmigiano Reggiano cheese? 15

                Nutritional facts for 1 serving of Basil salad:
                Protein: 3.0700000000000003 grams
                Carbohydrates: 1.2325 grams
                Fat: 9.83 grams
                Calories: 103.625 calories
                Omega 3: 104.97500000000001 mg


                Testing 5:

                C:\Users\psmeguest\Desktop>java Assignment3
                ---------- List of ingredients ---------

                * Ingredient 1: Olive oil
                * Ingredient 2: Fresh basil leaves
                * Ingredient 3: Raw farmed Atlantic salmon
                * Ingredient 4: Raw garlic
                * Ingredient 5: Cooked whole-wheat spaghetti
                * Ingredient 6: Parmigiano Reggiano cheese

                What are you calling this recipe? Error input
                How many servings do you need? 0
                The number of servings must be between 2 and 9.
*/