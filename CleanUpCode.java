import java.util.ArrayList;

public class CleanUpCode {
    private int[] pushes;
    public CleanUpCode(ArrayList<Integer> pushes){
        this.pushes=new int[365];
        define(pushes);
    }
    private void define(ArrayList<Integer> items){
        for(Integer i :items)
            this.pushes[i-1]=i;
    }
    public int solve(){
        int cleans=0;
        int dirt=0;
        int adder=0;
        for(int i=309;i<this.pushes.length;i++){
            //check dirtness
            if(dirt+adder>=20){
                dirt=0;
                cleans+=1;
                adder=0;
            }else// add dirtness
                dirt+=adder;

            //check if there was push at teh day
            if(pushes[i]!=0)
                adder+=1;
        }
        if(dirt>0 || adder >0) {
            cleans += 1;
        }

        return cleans;
    }
}
