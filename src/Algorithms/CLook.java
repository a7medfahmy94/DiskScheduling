package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class CLook extends DiskSchedulingAlgorithm {
	public CLook(List<Integer> l,Integer i,
			Integer d, Integer e){
		super(l, i, d ,e );
	}

	public List<Integer> execute(){
		return new ArrayList<Integer>();
	}
	public Integer getTotalTime(){
		return this.totalTime;
	}
}
