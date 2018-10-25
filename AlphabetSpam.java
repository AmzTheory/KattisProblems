public class AlphabetSpam {
    String line;
    public AlphabetSpam(String line){
        this.line=line;
    }
    public double[] solve(){
        int nWhite=0;
        int nUpperCase=0;
        int nLowerCase=0;
        int nSymbols=0;
        double len=this.line.length();
        char cam;
        for(int i=0;i<this.line.length();i++){
            cam=this.line.charAt(i);
            if(cam=='_')
                nWhite+=1;
            else if(Character.isUpperCase(cam))
                nUpperCase+=1;
            else if(Character.isLowerCase(cam))
                nLowerCase+=1;
            else
                nSymbols+=1;
        }
        return new double[]{nWhite/len,nLowerCase/len,nUpperCase/len,nSymbols/len};
    }
}
