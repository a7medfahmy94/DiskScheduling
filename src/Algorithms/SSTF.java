package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class SSTF extends DiskSchedulingAlgorithm {
	public SSTF(List<Integer> l,Integer i,
			Integer d, Integer e){
		super(l, i, d , e);
	}

	public List<Integer> execute(){
		
		int pos=this.initialPosition;
		ArrayList<Integer> newRes = new ArrayList<Integer>();
		ArrayList<Integer> newSeq = (ArrayList<Integer>) this.sequence;
		while(newSeq.size()!=0){
			int min=10000000;
			int idx=0;
			for(int i = 0 ; i < newSeq.size() ; i++){
				int res =Math.abs( pos-newSeq.get(i));
				if(res < min){
					min = res;
					idx=i;
				}
			}
			newRes.add(newSeq.get(idx));
			pos = newSeq.get(idx);
			this.totalTime+=min;
			newSeq.remove(idx);
 		}
		
		return newRes;
	}
	public Integer getTotalTime(){
		return this.totalTime;
	}
}
