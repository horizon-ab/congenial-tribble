import java.util.Scanner;

public class Primitives {

    public static void main(String[] args) {
        Scanner input;
        double firstUnit, secondUnit;
        boolean userConfirm;
        int userOption;

        input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = input.nextLine();
        input.close();

        System.out.println("Hello " + name + "!");
        System.out.println("Welcome to the unit convertor!");

        // Loop of conversions
        while (true) {

            System.out.println("Would you like to convert something (true/false): ");
            input = new Scanner(System.in);
            userConfirm = input.nextBoolean();
            input.close();

            if (userConfirm) {
                System.out.println("Here are a list of options below:");
                System.out.println("\t1. Pounds (lbs) to grams (g)");
                System.out.println("\t2. Grams (g) to pounds (lbs)");
                System.out.println("\t3. Feet (ft) to meters (m)");
                System.out.println("\t4. Meters (m) to feet (ft)");
                System.out.println("What would you like to convert (enter int): ");
                input = new Scanner(System.in);
                userOption = input.nextInt();
                input.close();

                switch (userOption) {
                    case 1:
                        System.out.println("Enter the amount in lbs (double): ");
                        input = new Scanner(System.in);
                        firstUnit = input.nextDouble();
                        secondUnit = firstUnit * 453.592;
                        System.out.println(firstUnit + " lbs is " + secondUnit + " g.");
                        input.close();
                        break;

                    case 2:
                        input = new Scanner(System.in);
                        System.out.println("Enter the amount in g (double): ");
                        firstUnit = input.nextDouble();
                        secondUnit = firstUnit * 0.00220462;
                        System.out.println(firstUnit + " g is " + secondUnit + " lbs.");
                        input.close();
                        break;

                    case 3:
                        input = new Scanner(System.in);
                        System.out.println("Enter the amount in ft (double): ");
                        firstUnit = input.nextDouble();
                        secondUnit = firstUnit * 0.3048;
                        System.out.println(firstUnit + " ft is " + secondUnit + " m.");
                        input.close();
                        break;

                    case 4:
                        input = new Scanner(System.in);
                        System.out.println("Enter the amount in m (double): ");
                        firstUnit = input.nextDouble();
                        secondUnit = firstUnit * 3.28084;
                        System.out.println(firstUnit + " m is " + secondUnit + " ft.");
                        input.close();
                        break;
                }

            } else {
                break;
            }
            


            
        }
        
    }
}

Primitives.main(null);