package Main;

import java.util.ArrayList;
import java.util.List;

import Algorithms.CLook;
import Algorithms.CSan;
import Algorithms.DiskSchedulingAlgorithm;
import Algorithms.FCFS;
import Algorithms.Look;
import Algorithms.SSTF;
import Algorithms.Scan;

public class Main {
	
	public static List<Integer> getInput(){
		
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(86);
		l.add(1470);
		l.add(913);
		l.add(1774);
		l.add(948);
		l.add(1509);
		l.add(1022);
		l.add(1750);
		l.add(130);
		return l;
	}
	public static Integer getDirection(){
		return -1;
	}
	public static Integer getInitialPosition(){
		return 143;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> seq = (ArrayList<Integer>)getInput();
		Integer direction = getDirection();
		Integer initialPosition = getInitialPosition();
		DiskSchedulingAlgorithm algo = new Look(seq, initialPosition, direction,4999);
		ArrayList<Integer> answer = (ArrayList<Integer>)algo.execute();
		for(Integer i: answer){
			System.out.print(i + " ");
		}
		System.out.println(algo.getTotalTime());
	}

}