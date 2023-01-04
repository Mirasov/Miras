public class Confim extends Orders{
    public static void confim(String[] orders, boolean discount){
        final int DISCOUNT_AMOUNT = 10; // discount amount in percentage

        //display order confirmation
        System.out.println("#############################################");
        previewOrder(orders);

        // calculate total cost
        int cost = getTotalCost(orders);

        if(discount){
            System.out.println("-----------------------------");
            cost*=0.9;
            System.out.printf("TOTAL with DISCOUNT (on preseenting ID only!): \n%d T \n", cost);
        }

        System.out.println("-----------------------------");
        System.out.println("Your order will be ready for pickup in 30 minutes.");

        System.out.print("Date: ");
        printCurrentDate();             // prints current date

        System.out.print("\tTime: ");
        printCurrentTime();             // prints current time
        System.out.println();
    }
}