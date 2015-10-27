package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaskGraph {
	
	private List<Task> tasks;
	private HashMap<Character, List<Character>> edgeMap; 
	
	public TaskGraph(ArrayList<Task> arrayList) {
		this.tasks = arrayList;
		edgeMap = new HashMap<Character, List<Character>>();
	}

	public List<Task> getTasks(){
		return tasks;
	}
	
	public void addTasks(Task task){
		tasks.add(task);
	}
	
	public void addEdge(Character from, Character to) {
		List<Character> taskList = edgeMap.get(from);
		if(taskList == null) {
			taskList = new ArrayList<Character>();
		}
		taskList.add(to);
		edgeMap.put(from, taskList);
	}
	
	public List<Character> getNextTasks(Character from) {
		return edgeMap.get(from);
	}
	
	public Task getTaskFromId(Character id) {
		for(Task t : tasks) {
			if(t.getId() == id) {
				return t;
			}
		}
		return null;
	}
}
