public class AlienNumbers {
    public AlienNumbers(String alphabets){
        String[] alp=alphabets.split("");
        int count=0;
        int digits=0;
        while(count<9){
            for(int i=0;i<alp.length && count <9;i++){
                String current=alp[i];
                for(int j=0;j<digits;j++){
                    current+=alp[j];
                }
                count+=1;
                System.out.println(current);
            }
            digits+=1;
        }
    }
}
