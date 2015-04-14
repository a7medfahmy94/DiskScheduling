package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class FCFS extends DiskSchedulingAlgorithm {
	
	public FCFS(List<Integer> l,Integer i,
			Integer d, Integer e){
		super(l, i, d,e);
	}
	public List<Integer> execute(){
		this.totalTime = Math.abs(this.initialPosition - this.sequence.get(0));
		for(int i = 0 ; i < this.sequence.size()-1 ; i++){
			this.totalTime += 
				Math.abs(this.sequence.get(i+1)-this.sequence.get(i));
		}
		return this.sequence;
	}
	public Integer getTotalTime(){
		return this.totalTime;
	}

}
