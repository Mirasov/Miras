import java.util.Scanner;
public class Zakaz{
    
    public static String order(){
        Scanner keyboard = new Scanner(System.in);
        String input;                   //user input
        char choice;                    //user's choice
        int size;                       //size of the pizza
        int cost = 0;                   //cost of the pizza
        int numberOfToppings = 0;       //number of toppings
        String toppings = "Cheese";     //list of toppings
        String result = "";             // resultant String object to be returned
        final int toppingCost = 200;    // cost for one topping

        System.out.println("-----------------------------");
        System.out.println("Pizza Size (cm)      Cost");
        System.out.println("       20            1000 T");
        System.out.println("       30            1500 T");
        System.out.println("       40            2000 T");
        System.out.println("What size pizza would you like?");
        System.out.print("> 20, 30, or 40 (enter the number only): ");
        size = keyboard.nextInt();


        if(size==20)
            cost+=1000;
        else if(size==30)
            cost+=1500;
        else if(size==40)
            cost+=2000;

        keyboard.nextLine();

        System.out.println("-----------------------------");
        System.out.println("All pizzas come with cheese.");
        System.out.println("Additional toppings are 200T each," + " choose from:");
        System.out.println("- Meat, Sausage, Vegetables, Mushroom");

        System.out.print("> Do you want Meat?  (Y/N):  ");
        input = keyboard.nextLine();
        choice = input.charAt(0);
        if (choice == 'Y' || choice == 'y')
        {
            numberOfToppings += 1;
            toppings = toppings + " + Meat";
        }
        System.out.print("> Do you want Sausage?  (Y/N):  ");
        input = keyboard.nextLine();
        choice = input.charAt(0);
        if (choice == 'Y' || choice == 'y')
        {
            numberOfToppings += 1;
            toppings = toppings + " + Sausage";
        }
        System.out.print("> Do you want Vegetables?  (Y/N):  ");
        input = keyboard.nextLine();
        choice = input.charAt(0);
        if (choice == 'Y' || choice == 'y')
        {
            numberOfToppings += 1;
            toppings = toppings + " + Vegetables";
        }
        System.out.print("> Do you want Mushroom?  (Y/N):  ");
        input = keyboard.nextLine();
        choice = input.charAt(0);
        if (choice == 'Y' || choice == 'y')
        {
            numberOfToppings += 1;
            toppings = toppings + " + Mushroom";
        }

        cost+=numberOfToppings*toppingCost;

        
        result += size + "cm pizza, " + toppings;
       
        result += ":" + cost;
        return result;
    }
}