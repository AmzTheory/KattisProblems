import TwoZeroEightFour.*;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] line = (scanner.nextLine()).split(" ");
		int r=Integer.parseInt(line[0]);
		int b=Integer.parseInt(line[1]);
		int[] rooms=new int[r];
		for(int i=0;i<b;i++){
			rooms[Integer.parseInt(scanner.nextLine())-1]=1;
		}
		System.out.println((new BookingRoom(r,b,rooms)).solve());
	}
	public static ArrayList<Integer> listOfInteger(String[] str){
    	ArrayList<Integer> values=new ArrayList<>();
    	for(String s:str){
    		values.add(Integer.parseInt(s));
		}
    	return values;
	}
}
