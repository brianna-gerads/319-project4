package models;

public class Edge {
	private Task from;
	private Task to;
	
	public Edge(Task from, Task to){
		this.from = from;
		this.to = to;
	}
	
	public Task getFrom() {
		return from;
	}

	public void setFrom(Task from) {
		this.from = from;
	}

	public Task getTo() {
		return to;
	}

	public void setTo(Task to) {
		this.to = to;
	}

	@Override
	public boolean equals(Object obj){
		Edge e = (Edge) obj;
		return this.from == e.getFrom() && this.to == e.getTo();
	}

}
