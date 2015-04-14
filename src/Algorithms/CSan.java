package Algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class CSan extends DiskSchedulingAlgorithm {
	public CSan(List<Integer> l,Integer i,
			Integer d , Integer e){
		super(l, i, d , e);
	}

	public int getMax(){
		int mx = -1;
		for(Integer i: this.sequence){
			if(i > mx)mx = i;
		}
		return mx;
	}
	public int getMin(){
		int mn = 1000000;
		for(Integer i: this.sequence){
			if(i < mn)mn = i;
		}
		return mn;
	}
	public List<Integer> execute(){
		int mx =getMax();
		int mn=getMin();
		ArrayList<Integer> res = new ArrayList<Integer>();
		res.addAll(scan(this.initialPosition,this.direction));
		if(this.direction > 0){
			for(int i = 0 ; i < this.sequence.size() ; i++){
				if(this.sequence.get(i) < this.initialPosition){
					this.totalTime += this.endPoint+(this.endPoint-mx); 
					break;					
				}
			}
			res.addAll(scan(0,this.direction));
		}else{
			
			for(int i = 0 ; i < this.sequence.size() ; i++){
				if(this.sequence.get(i) > this.initialPosition){
					this.totalTime += mn+this.endPoint;
					break;					
				}
			}
			
			res.addAll(scan(this.endPoint,this.direction));
		}
		
		return res;
	}
	public Integer getTotalTime(){
		return this.totalTime;
	}
	public List<Integer> scan(Integer start , Integer step){
		ArrayList<Integer> newRes= new ArrayList<Integer>();
		ArrayList<Integer> newSeq = (ArrayList<Integer>) this.sequence;
		int pre = start;
		while(start >= 0 && start <= this.endPoint){
			start+=step;
			int idx=0;
			Collections.sort(this.sequence);
			for(int i = 0 ; i < this.sequence.size() ; i++){
				if(start.equals(this.sequence.get(i))){
					newRes.add(this.sequence.get(i));
					this.totalTime += Math.abs(start - pre);
					pre = start;
					newSeq.remove(i);
				}
			}
		}
		return newRes;
	}
}
