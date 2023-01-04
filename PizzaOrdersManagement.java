import java.util.*;

public class PizzaOrdersManagement {
    public static Scanner sc = new Scanner(System.in);

    public static String[] set = sc.nextLine().split(" ");
    public static int input = Integer.parseInt(set[0]);

    public static final int n = Integer.parseInt(sc.nextLine());
    public static String[] array = new String[n];

    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextLine();
        }

        if(input == 1)
            getTotalPrice();
        if(input == 2) {
            System.out.println("Search by ID: " + set[1]);
            search();
        }
        if(input == 3) {
            System.out.println("Search by Date: " + set[1]);
            search();
        }
        if(input == 4) {
            sortByID();
        }
        if(input == 5) {
            sortByDateAndTime();
        }
        if(input == 6) {
            mostPopularSize();
        }
        if(input == 7){
            mostPopularPizzaType();
        }
    }

    static void getTotalPrice(){
        System.out.println("Total Price:");
        int sum = 0;
        for (String order: array)
            sum += Integer.parseInt(order.split(" ")[3]);

        System.out.println(sum);
    }

    static void search(){
        boolean notFound = true;
        for (String order : array)
            if (order.split(" ")[input - 2].equals(set[1])) {
                System.out.println(order);
                notFound = false;
            }

        if (notFound)
            System.out.println("No result");
    }

    static void sortByID(){
        System.out.println("Sort by ID:");
        Arrays.sort(array, Comparator.comparingInt(a -> Integer.parseInt(a.substring(0, 4))));
        for (String s : array) {
            System.out.println(s);
        }
    }
    static void sortByDateAndTime(){
        System.out.println("Sort by date and time:");
        for (int i = 0; i < n; i++) {
            String[] part = array[i].split(" ")[1].split("\\.");
            array[i] = array[i].substring(0, 5) + part[2] + "." + part[1] + "." + part[0] + array[i].substring(15);
        }
        Arrays.sort(array, Comparator.comparing(a -> a.substring(5, 21)));
        for (int i = 0; i < n; i++) {
            String[] part = array[i].split(" ")[1].split("\\.");
            array[i] = array[i].substring(0, 5) + part[2] + "." + part[1] + "." + part[0] + array[i].substring(15);
        }
        for (String s : array) {
            System.out.println(s);
        }
    }
    static void mostPopularSize(){
        System.out.println("Most popular size:");
        int[] size = new int[3];
        for (String order: array)
            size[(Integer.parseInt(order.split(" ")[5]) - 20) / 10]++;

        int max = 0;
        for (int i = 0; i < 3; i++)
            if (max < size[i])
                max = size[i];

        if (size[0] == max)
            System.out.println(20);
        if (size[1] == max)
            System.out.println(30);
        if (size[2] == max)
            System.out.println(40);
    }
    static void mostPopularPizzaType(){
        System.out.println("Most popular pizza type:");
        HashMap<String, Integer> hashMap = new HashMap<>();
        String[] topping = {"Cheese", "Meat", "Sausage", "Vegetables"};

        for (String order: array) {
            String[] part = order.split(" ");
            StringBuilder typeBuilder = new StringBuilder();

            for (int i = 6; i < 10; i++)
                if (part[i].equalsIgnoreCase("yes"))
                    typeBuilder.append(topping[i - 6]).append("+");

            if (typeBuilder.length() > 0)
                typeBuilder.deleteCharAt(typeBuilder.length() - 1);
            String type = typeBuilder.toString();

            if (!hashMap.containsKey(type)) hashMap.put(type, 1);
            else        hashMap.put(type, hashMap.get(type) + 1);
        }

        int max = 0;
        for (Map.Entry<String, Integer> entry: hashMap.entrySet())
            if (max < entry.getValue())
                max = entry.getValue();

        for (Map.Entry<String, Integer> entry: hashMap.entrySet())
            if (max == entry.getValue()) {
                if(!entry.getKey().isEmpty())
                    System.out.println(entry.getKey());
                else System.out.println("Pizza without topping combinations");
            }

    }
}
