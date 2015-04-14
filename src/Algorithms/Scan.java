package Algorithms;

import java.util.ArrayList;
import java.util.List;


public class Scan extends DiskSchedulingAlgorithm {
	public Scan(List<Integer> l,Integer i,
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
		ArrayList<Integer> res = new ArrayList<Integer>();
		res.addAll(scan(this.initialPosition,this.direction));
		if(this.direction > 0){
			for(int i = 0 ; i < this.sequence.size() ; i++){
				if(this.sequence.get(i) < this.initialPosition){
					int mx = getMax();
					if(mx < this.initialPosition){
						mx = this.endPoint - initialPosition  ;
					}else{
						mx = this.endPoint - mx ;
					}
					this.totalTime += 
							this.endPoint - initialPosition +
							mx;
					break;					
				}
			}
		}else{
			for(int i = 0 ; i < this.sequence.size() ; i++){
				if(this.sequence.get(i) > this.initialPosition){
					int mn = getMin();
					if(mn > this.initialPosition){
						mn = this.initialPosition;
					}
					this.totalTime += this.initialPosition + mn;
					break;					
				}
			}			
		}
		res.addAll(scan(this.initialPosition,-this.direction));
		return res;
	}
	public Integer getTotalTime(){
		return this.totalTime;
	}
	public List<Integer> scan(Integer start , Integer step){
		ArrayList<Integer> newRes= new ArrayList<Integer>();
		int pre = start;
		while(start >= 0 && start <= this.endPoint){
			start+=step;
			for(int i = 0 ; i < this.sequence.size() ; i++){
				if(start.equals(this.sequence.get(i))){
					newRes.add(this.sequence.get(i));
					this.totalTime += Math.abs(start - pre);
					pre = start;
				}
			}
		}
		return newRes;
	}
}
