import java.util.ArrayList;
import java.util.PriorityQueue;

public class arrivingOnTime {
//    ArrayList<Lane> lanes;
//    int numberOfStops;
//    int meetingTime;
//    public arrivingOnTime(int[][] info,int numberOfLines,int meetingTime,int numberOfStops){
//        this.meetingTime=meetingTime;
//        this.numberOfStops=numberOfStops;
//        defineLane(info);
//        PriorityQueue<Integer> elements=new PriorityQueue<>();
//    }
//    private void defineLane(int info[][]){
//        for (int[] lan:info){
//            this.lanes.add(new Lane(lan[0],lan[1],lan[2],lan[3],lan[4]));
//        }
//    }
//    private ArrayList<Lane> geStopsStart(int n){
//        ArrayList elements=new ArrayList();
//        for (Lane l:this.lanes) {
//            if(l.getU()==n)
//                elements.add(l);
//        }
//        return elements;
//    }
//


}
class Lane
{
    private int u;
    private int v;
    private int to;
    private int every;
    private int time;

    public Lane(int u, int v, int to, int every, int time) {
        this.u = u;
        this.v = v;
        this.to = to;
        this.every = every;
        this.time = time;
    }
    public int nextBus(int n){
        int current=this.to;
        while(current<n){
            current+=this.every;
        }
        return current;
    }
    public int getU() {
        return u;
    }

    public void setU(int u) {
        this.u = u;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getEvery() {
        return every;
    }

    public void setEvery(int every) {
        this.every = every;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}

