
import java.util.ArrayList;
import java.util.Arrays;

public class FourThought {
    ArrayList<Integer> values=new ArrayList<>();
    public FourThought(ArrayList list){
        this.values=list;
    }

    public void solve(){
        ArrayList<String> operations=new ArrayList<String>();
        operations.add("/");
        operations.add("*");
        operations.add("+");
        operations.add("-");

        for(Integer val:values){
            ArrayList<String> res=lookFor(new ArrayList<String>(),operations,val);
            if(res!=null)
                this.printLine(res,val);
            else
                System.out.println("no solution");
        }
    }
    private ArrayList<String> lookFor(ArrayList<String> operationChosen, ArrayList<String> operationCanBeChoosed, int val){
        //String[] operations={"/","*","+","-"};
        if(operationChosen.size()==3 && calculate(operationChosen)==val){
            return operationChosen;
        }else if(operationChosen.size()==3){
            return null;
        }else{
            String op;
            for(int i=0;i<operationCanBeChoosed.size();i++){
                op=operationCanBeChoosed.get(i);
                operationChosen.add(op);
                int total=calculate(operationChosen);
                //elimination
                ArrayList<String> operationPassed=new ArrayList<>();
                //if(total>=val){
                    operationPassed.add("/");
                    operationPassed.add("*");
                    operationPassed.add("+");
                    operationPassed.add("-");


                ArrayList<String> res=lookFor(operationChosen,operationPassed,val);
                if(res!=null)
                    return res;
                operationChosen.remove(op);
            }
        }
        return null;
    }
    private int calculate(ArrayList<String> operations){
        int total=4;
        for(int i=0;i<operations.size();i++){
            total=chooseOperation(operations.get(i),total);
        }
        return total;

    }
    private int chooseOperation(String op,int val){
        if(op.equals("+")){
            return val+4;
        }else if(op.equals("-")){
            return val-4;
        }else if(op.equals("/")){
            return val/4;
        }else if(op.equals("*")){
            return val*4;
        }
        return -1;
    }
    private void printLine(ArrayList<String> operations,int total){
        String line="4";
        for(int i=0;i<operations.size();i++){
            line+=" "+operations.get(i)+" 4";
        }
        line+=" = "+total;
        System.out.println(line);
    }


}
