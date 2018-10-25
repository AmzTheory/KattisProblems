import java.util.ArrayList;
import java.util.HashMap;

public class Arithmetic {

    public String octalToBin(long octal){
      //convert to Binary
        Long dec=octalToDec(octal);
      //split groups of four
        //ArrayList<String> split=splitFour(bin);
      //convert to hex
        //String res=binToHex(split);
        return Long.toString(dec,16).toUpperCase();
    }
    public long octalToDec(long octal){
        String num=Long.toString(octal);
        long sum=0;
        int powerIndex=0;
        for(int i=num.length()-1;i>-1;i--){
            int current=Integer.parseInt(""+num.charAt(i));
            sum+=current*Math.pow(8,powerIndex++);
        }
        return sum;
    }
    private int decToBinary(long dec){
        String value="";
        if(dec==0)
            return 0;
        for(long i=dec;i>0;i/=2){
            double temp=(double)i/2;
            if(temp % 1==0.0)
                value="0"+value;
            else
                value="1"+value;
        }
        return Integer.parseInt(value);
    }
    public String octalDigitToBin(long oct){
        String res="";
        String octStr=Long.toString(oct);
        for(int i=0;i<octStr.length();i++)
        {
            char a=octStr.charAt(i);
            Integer current=Integer.parseInt(a+"");
            String r=Long.toString(decToBinary(current));
            if(r.length()==2)
                r="0"+r;
            else if(r.length()==1)
                r="00"+r;

            res+=r;
        }
        return res;
    }
    private ArrayList<String> splitFour(String bin){
        ArrayList<String> values=new ArrayList<>();
        if(bin.length()<=4){
            values.add(bin);
            return values;
        }

        String temp="";
        int limit=4;
        for(int i=bin.length()-1;i>=0;i--){
            if(temp.length()==limit) {
                values.add(temp);
                temp = "";
                if(i==3)
                    values.add(bin.charAt(0)+""+bin.charAt(1)+""+bin.charAt(2)+""+bin.charAt(3));
                else if(i==2)
                    values.add(bin.charAt(0)+""+bin.charAt(1)+""+bin.charAt(2));
                else if(i==1)
                    values.add(bin.charAt(0)+""+bin.charAt(1));
                else if(i==0)
                    values.add(""+bin.charAt(0));
                else
                    i+=1;

                continue;
            }
            temp=bin.charAt(i)+temp;
        }
        return values;
    }
    private String lessThan(int i){
        return "";
    }
    private int binToDec(String str){
        int res=0;
        int powerCounter=0;
        for (int i=str.length()-1;i>=0;i--){
            res+=Integer.parseInt(""+str.charAt(i))*Math.pow(2,powerCounter++);
        }
        return res;
    }
    private String binToHex(ArrayList<String> values){
        String res="";
        HashMap<Integer,Character> map=new HashMap<>();
        map.put(0,'A');map.put(1,'B');map.put(2,'C');map.put(3,'D');map.put(4,'E');map.put(5,'F');
        for(int i=0;i<values.size();i++){
            int value=binToDec(values.get(i));
            if(value<10)
                res=value+res;
            else
                res=map.get(value-10)+res;
        }
        return res;
    }
    private String trimZero(String str){
        for (int i=0;i<str.length();i++){
            if(str.charAt(i)!='0')
                return str.substring(i);
        }
        return "";
    }
}
