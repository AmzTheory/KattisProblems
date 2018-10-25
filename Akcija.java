
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Akcija {
    public ArrayList<Integer> values;
    public Akcija(Integer[] ls){
        values=new ArrayList<Integer>(Arrays.asList(ls));;
        Collections.sort(values);
        Collections.reverse(values);
        System.out.println(getTotalPay(values));
    }

    private int getTotalPay(ArrayList<Integer> splitted){
        int sum=0;
        for(int i=0;i<splitted.size();i++){
            if((i+1)%3==0)
                continue;
            else
                sum+=splitted.get(i);
        }
        if(sum==0){
            System.out.println();
        }
        return sum;
    }

}
