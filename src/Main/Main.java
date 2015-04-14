package Main;

import java.util.ArrayList;
import java.util.List;

import Algorithms.DiskSchedulingAlgorithm;
import Algorithms.FCFS;
import Algorithms.SSTF;
import Algorithms.Scan;

public class Main {
	
	public static List<Integer> getInput(){
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(8);
		l.add(3);
		return l;
	}
	public static Integer getDirection(){
		return -1;
	}
	public static Integer getInitialPosition(){
		return 5;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> seq = (ArrayList<Integer>)getInput();
		Integer direction = getDirection();
		Integer initialPosition = getInitialPosition();
		DiskSchedulingAlgorithm algo = new Scan(seq, initialPosition, direction,3000);
		ArrayList<Integer> answer = (ArrayList<Integer>)algo.execute();
		for(Integer i: answer){
			System.out.print(i + " ");
		}
		System.out.println(algo.getTotalTime());
	}

}