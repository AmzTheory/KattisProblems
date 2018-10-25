import java.util.ArrayList;

public class ArmyStrength {
    Battle battle;
    public ArmyStrength(ArrayList<Integer> mech,ArrayList<Integer> godz){
        battle=new Battle(new Army(mech),new Army(godz));
    }
    public String start(){
        return battle.fight();
    }
}
class Battle{
    private Army mecha;
    private Army godzilla;
    public Battle(Army mecha,Army godzilla){
        this.mecha=mecha;
        this.godzilla=godzilla;
    }

    public String fight(){
        int mlow=mecha.lowest();
        int glow=godzilla.lowest();

        if(mecha.get(mlow)<godzilla.get(glow))
            mecha.kick(mlow);
        else if(mecha.get(glow)>godzilla.get(glow))
            godzilla.kick(glow);
        else
            mecha.kick(mlow);

        String msg=finish();
        boolean cont=msg=="not" ? true :false;
        if(cont)
            return fight();
        else
            return msg;
    }
    private String finish(){
        if(mecha.allDied()) {
            return "Godzilla";
        }else if(godzilla.allDied()){
            return "MechaGodzilla";
        }
        return "not";
    }
}
class Army{
    private ArrayList<Integer> monsters;
    public Army(ArrayList<Integer> numOfMonsters){
        this.monsters=numOfMonsters;
    }
    public int lowest(){
        int lowest=0;
        for(int i=1;i<monsters.size();i++){
            if(monsters.get(i)<monsters.get(lowest))
                lowest=0;

        }
        return lowest;
    }
    public int get(int i){
        return monsters.get(i);
    }
    public void kick(int i){
        this.monsters.remove(i);
    }
    public boolean allDied(){
        return this.monsters.size()==0;
    }


}
