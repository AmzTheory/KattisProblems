import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AliceInDigitalWorld {
    private Integer m;
    private ArrayList<Integer> elements;
    public AliceInDigitalWorld(ArrayList<Integer> elements,Integer m){
        this.elements=elements;
        this.m=m;
    }
    public int  findMax(){

        PriorityQueue<Record> records=new PriorityQueue<>(new Comparator<Record>() {
            //here I want have PQ to order elements from the highest to the lowest
            @Override
            public int compare(Record o1, Record o2) {
                if (o1.sum > o2.sum)
                    return -1;
                else if (o1.sum < o2.sum)
                    return 1;
                return 0;//if equals
            }
        });
        int counterM=0;
        int lastIndex=-1;
        int sum=0;
        for(int i=0;i<elements.size();i++){
            if(elements.get(i)<m){
                records.add(new Record(sum));
                sum=0;
                i++;
                counterM=0;
                lastIndex=i;
                continue;
            }
            else if(elements.get(i)==m && counterM==1) {
                records.add(new Record(sum));
                sum=0;
                i=lastIndex+1;
                counterM=elements.get(i)==m ? 1:0;
                lastIndex=elements.get(i)==m?i:lastIndex;
            }else if(elements.get(i)==m) {
                counterM += 1;
                lastIndex=i;
            }

            sum+=elements.get(i);
        }
        if(sum!=0)
            records.add(new Record(sum));
        Record max=records.poll();
        return max.sum;
    }
}
class Record{
    public Record(int sum){this.sum=sum;}
    int sum;
}
