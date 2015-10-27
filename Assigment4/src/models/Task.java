package models;

import java.util.List;

public class Task {
	
	private char id;
	private int duration;
	//private ArrayList<Task> dependencies = new ArrayList<Task>();
	private char[] dependencies;
	
	private int ES;
	private int EF;
	private int LS;
	private int LF;
	
	public Task(char id, int duration) {
		this.id = id;
		this.duration = duration;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setDependencies(char[] depen) {
		dependencies = depen;
	}
	
	public void setDependencies(List<Character> depen) {
		char[] arr = new char[depen.size()];
		for(int i = 0; i < depen.size(); i++) {
			arr[i] = (char) depen.get(i);
		}
		dependencies = arr;
	}
	
	public char[] getDependencies(char[] depen) {
		return dependencies;
	}

	public int getES() {
		return ES;
	}

	public void setES(int eS) {
		ES = eS;
	}

	public int getEF() {
		return EF;
	}

	public void setEF(int eF) {
		EF = eF;
	}

	public int getLS() {
		return LS;
	}

	public void setLS(int lS) {
		LS = lS;
	}

	public int getLF() {
		return LF;
	}

	public void setLF(int lF) {
		LF = lF;
	}
}
