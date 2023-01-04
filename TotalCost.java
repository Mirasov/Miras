public class TotalCost{
	public static int cost(String[] orders){
        int n = 0;
        int res=0;
        while(orders[n]!=null){
            res+= Integer.parseInt(orders[n].substring(orders[n].length()-4));
            n++;
        }

        return res;
    }
}