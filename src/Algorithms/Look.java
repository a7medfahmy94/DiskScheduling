package Algorithms;
import java.util.ArrayList;
import java.util.List;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class Look extends DiskSchedulingAlgorithm {
	public Look(List<Integer> l,Integer i,
			Integer d, Integer e){
		super(l, i, d ,e);
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
			this.totalTime += getMax()-initialPosition ;
		}else{
			this.totalTime += this.initialPosition-getMin() ;
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
			Collections.sort(this.sequence);
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
