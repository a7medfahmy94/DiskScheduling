package Algorithms;

import java.util.List;

public abstract class DiskSchedulingAlgorithm {
	protected List<Integer> sequence;
	protected Integer initialPosition ;
	protected Integer direction;
	protected Integer totalTime;
	protected Integer endPoint;
	public DiskSchedulingAlgorithm(List<Integer> l,Integer i,
			Integer d,Integer e){
		this.sequence = l;
		this.initialPosition = i;
		this.direction = d;
		this.endPoint = e;
		this.totalTime=0;
	}
	public abstract List<Integer> execute();
	public abstract Integer getTotalTime();
}
