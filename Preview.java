public class Preview extends TotalCost{
	public static void preview(String[] orders){
        System.out.println("-----------------------------");
        System.out.println("Your order: ");
        int i=0;

        while(orders[i]!=null){
            System.out.println((i+1) + ")" + orders[i]);
            i++;
        }
        System.out.println("Total: " + cost(orders) + " T");
    }
}