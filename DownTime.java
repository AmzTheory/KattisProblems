import java.util.ArrayList;

public class DownTime {
    private ArrayList<Request> requests;
    private int k;
    public DownTime(int k, ArrayList<Integer> items){
        this.k=k;
        defineRequests(items);
    }
    private void defineRequests(ArrayList<Integer> items){
        requests=new ArrayList<>();
        for (Integer i:items) {
            requests.add(new Request(i));
        }
    }
    public int calc(){
         Request[] working=new Request[requests.size()];
         int counter=0;
         int lastIndex=0;
         int sum=0;
         for(Request r:requests){
            counter+=checkFinished(working,r.getTime());
            working[lastIndex++]=r;
            counter+=1;
            sum=getCurrentSum(sum,counter);
        }
        return sum;
    }
    private void checkFinished(ArrayList<Request> working,int time){
        for(int i=0;i<working.size();i++){
            if(working.get(i).finish(time))
                working.remove(i);//will remove it
        }
    }
    private int checkFinished(Request[] working,int time){
        int add=0;
        for(int i=0;i<working.length;i++){
            if(working[i]!=null) {
                if (working[i].finish(time)) {
                    working[i] = null;//will remove it
                    add -= 1;
                }
            }
        }
        return add;
    }

    private int getCurrentSum(int current,int nRequests){
        int needed=(int)Math.ceil((double)nRequests/(double)k);
        if(needed>current)
            return needed;

        return current;
    }
}
class Request{
    private int time;

    public Request(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    public boolean finish(int i){
        if(i<time+1000)
            return false;

        return true;
    }
}
