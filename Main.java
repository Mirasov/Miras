import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Main
{
    public static void main(String [] args){
        Orders order = new Orders();
        Scanner keyboard = new Scanner(System.in);	
        boolean discount = false;     		
        char choice;                  		
        String input;                 		
        String[] orders = new String[10];	
        int numOfOrders = 0;				

        System.out.println("====================================");
        System.out.println("Welcome to \"Eat&Chat\" Pizza Order!");
        System.out.println("====================================");

        System.out.print("Today is: ");
        order.printCurrentDate();		// prints current date (today)
        System.out.println();
        System.out.print("> Is it your BIRTHDAY? (10% discount available on presenting ID)  (Y/N):  ");
        input = keyboard.nextLine();

        if(input.equals("y") || input.equals("Y")){
            discount=true;
        }

        orders[numOfOrders++] = order.orderPizza();	// get first order
        order.previewOrder(orders);	// view order info



        while(true){
            order.printMenu();	// print action menu options

            input = keyboard.nextLine();

            choice = input.charAt(0);

            switch(choice){

                // Complete order
                case '1':
                    order.confirmOrder(orders, discount);			// complete order
                    System.exit(0);
                // Add another pizza
                case '2':
                    orders[numOfOrders++] = order.orderPizza();	// save new order
                    order.previewOrder(orders);					// view order info
                    break;

                // Exit
                case '3':
                    System.out.print("Good bye!");
                    System.exit(0);// exit program
                default:
                    System.exit(0);
            }
        }

    }
    
}