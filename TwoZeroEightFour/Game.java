package TwoZeroEightFour;

import java.util.Scanner;

public class Game {
    private Grid grid;
    private static Scanner scanner=new Scanner(System.in);
    public Game(int[][] cells){
        this.grid=new Grid(cells);
    }
    public static int[][] readState(){
        int[][] elements=new int[4][4];
        for(int i=0;i<4;i++){
            elements[i]=formLine(scanner.nextLine());
        }
        return elements;
    }
    private static int[] formLine(String line){
        String[] ln=line.split(" ");
        int[] values=new int[ln.length];
        int i=0;
        for(String s:ln){
            values[i]=Integer.parseInt(s);
            i++;
        }
        return values;
    }
    public static int readMove(){
        return Integer.parseInt(scanner.nextLine());
    }
    public void move(int direc){
        System.out.println(direc);
        if(direc==0){
            this.grid.moveLeft();
        }else if(direc==1){
            this.grid.moveUp();
        }else if(direc==2){
            this.grid.moveRight();
        }else if(direc==3){
            this.grid.moveDown();
        }
    }
    public void printGrid(){
        this.grid.printGrid();
    }
}
