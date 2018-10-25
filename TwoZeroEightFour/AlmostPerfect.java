package TwoZeroEightFour;

public class AlmostPerfect {
    public AlmostPerfect(int n){
        int sum=0;
        for(int i=n/2;i>0;i--){
            if(n%i==0) {
                sum+=i;
            }
        }
        int diff=n-sum;
        if(diff==0)
            System.out.println(n+" perfect");
        else if(diff>=-2 && diff <=2)
            System.out.println(n+" almost perfect");
        else
            System.out.println(n+" not perfect");

    }
}
