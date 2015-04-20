package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Algorithms.CLook;
import Algorithms.CSan;
import Algorithms.DiskSchedulingAlgorithm;
import Algorithms.FCFS;
import Algorithms.Look;
import Algorithms.SSTF;
import Algorithms.Scan;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer>seq = new ArrayList<Integer>();
		System.out.println("Enter The Number Of Sequence : \n");
		Scanner in = new Scanner(System.in);
		Integer input=in.nextInt();
		Integer x=input;
		System.out.println("Enter The Sequence : \n");
		for(int i = 0 ; i < x ; i++){
			input=in.nextInt();
			seq.add(input);
			
		}
		System.out.println("Enter The InitialPosition :");
		input=in.nextInt();
		Integer initialPosition = input;
		System.out.println("Enter The Direction :");
		input=in.nextInt();	
		Integer direction = input ;
		System.out.println("Enter The Number Of Cylinder :");
		input=in.nextInt();	
		Integer cylinder = input ;
		DiskSchedulingAlgorithm algo = new Scan(seq, initialPosition, direction,cylinder-1);
		ArrayList<Integer> answer = (ArrayList<Integer>)algo.execute();
		System.out.print("Sequence : ");
		for(Integer i: answer){
			System.out.print(i + " ");
		}
		System.out.println(" \n"+"Total Time : "+algo.getTotalTime());
	}

}