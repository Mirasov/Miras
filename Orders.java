import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Orders{
	
    public static void printMenu(){
        Print print = new Print();
        print.print();
    }

    public static String orderPizza(){
        Zakaz zakaz = new Zakaz();
        String result = zakaz.order();
        return result;
    }

    
    public static void previewOrder(String[] orders){
        Preview preview = new Preview();
        preview.preview(orders);
    }


    public static int getTotalCost(String[] orders){
        TotalCost total = new TotalCost();
        return total.cost(orders);
    }

    public static void confirmOrder(String[] orders, boolean discount){
        Confim confim = new Confim();
        confim.confim(orders,discount);

        System.out.print("Order ID: " + generateCode());	// generates random ID
    }


    public static void printCurrentDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDateTime now = LocalDateTime.now();
        System.out.print(dtf.format(now));
    }


    public static void printCurrentTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime now = LocalDateTime.now();
        System.out.print(dtf.format(now));
    }

    public static String generateCode(){
        int random = 1000+(int)(Math.random()*1000);
        String code = ""+random;
        return code;
    }
	
}