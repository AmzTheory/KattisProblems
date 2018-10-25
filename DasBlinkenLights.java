import java.util.ArrayList;

public class DasBlinkenLights {
    private int s;
    private int p;
    private int q;
    public DasBlinkenLights(int p,int q,int s){
        this.s=s;
        this.p=p;
        this.q=q;
        solve();
    }
    private void solve(){
        ArrayList<Integer> first=new ArrayList<>();
        ArrayList<Integer> sec=new ArrayList<>();

        for(int i=1;(i*q)<=s || (i*p)<=s ;i++){
            int lightOne=i*p;
            int lightTwo=i*q;
            first.add(lightOne);
            sec.add(lightTwo);
            if(first.contains(lightTwo)){
                System.out.println("yes");
                return;
            }else if(sec.contains(lightOne)){
                System.out.println("yes");
                return;
            }
        }

        System.out.println("no");

    }
}
