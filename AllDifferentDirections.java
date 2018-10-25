import java.util.ArrayList;

public class AllDifferentDirections {
   private Coordinates cord;
   String instructions;

    public AllDifferentDirections(, String instructions) {
        this.instructions = instructions;
    }

    public void solve(){
        int degree=0;
        ArrayList<Action> actions=this.getActions();
        for(Action a:actions){
            degree=this.rotateDegree(degree,a.getTurn());

        }
    }
    private int rotateDegree(int current,int shiftingDegree){
        int res=current+shiftingDegree;
        if(res>=0) return res;

        return 360-res;
    }
    private ArrayList<Action> getActions(){
        ArrayList<Action> listOfActions=new ArrayList<>();
        String[] list=instructions.split(" ");
        this.cord=new Coordinates(Integer.parseInt(list[0]),Integer.parseInt(list[1]));
        for(int i=2;i<list.length;i+=4){
            listOfActions.add(new Action(Integer.parseInt(list[i+1]),Integer.parseInt(list[i+3])));
        }
        return listOfActions;
    }
}
class Action{
    private int turn;
    private int walk;

    public Action(int turn, int walk) {
        this.turn = turn;
        this.walk = walk;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getWalk() {
        return walk;
    }

    public void setWalk(int walk) {
        this.walk = walk;
    }
    public Coordinates move(Coordinates position){

    }
}
class Coordinates{
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
