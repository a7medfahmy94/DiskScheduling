package Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CLook extends DiskSchedulingAlgorithm {
	public CLook(List<Integer> l,Integer i,
			Integer d, Integer e){
		super(l, i, d ,e );
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
					this.totalTime += mx-mn-1; 
					break;					
				}
			}
			res.addAll(scan(mn-1,this.direction));
		}else{
			for(int i = 0 ; i < this.sequence.size() ; i++){
				if(this.sequence.get(i) > this.initialPosition){
					this.totalTime += mx-mn;
					break;					
				}
			}
			
			res.addAll(scan(mx+1,this.direction));
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
				//System.out.println(this.totalTime+"KKKKKKK");
			}
		}
		return newRes;
	}
}
