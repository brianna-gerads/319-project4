package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TaskGraph {
	
	private List<Task> tasks;
	private ConcurrentHashMap<Character, List<Character>> edgeMap; 
	
	public TaskGraph(ArrayList<Task> arrayList) {
		this.tasks = arrayList;
		edgeMap = new ConcurrentHashMap<Character, List<Character>>();
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
			edgeMap.put(from, taskList);
		}
		taskList.add(to);
		//edgeMap.put(from, taskList);
	}
	
	public List<Character> getNextTaskIds(Character from) {
		return edgeMap.get(from);
	}
	
	public List<Task> getNextTasks(Character from) {
		List<Character> nextTaskIds = getNextTaskIds(from);
		List<Task> nextTasks = getTasksFromIds(nextTaskIds);
		return nextTasks;
	}
	
	
	public List<Task> getTasksFromIds(List<Character> idList) {
		List<Task> taskList = new ArrayList<Task>();
		for(Character id : idList) {
			Task t = getTaskFromId(id);
			taskList.add(t);
		}
		return taskList;
	}
	
	public List<Character> getInitialTaskIds() {
		Set<Character> initialTaskIds = edgeMap.keySet();
		Set<Character> initialTaskIdsCopy = new HashSet<Character>(initialTaskIds);
		for(Character id : initialTaskIds) {
			List<Character> successors = edgeMap.get(id);
			if(successors != null) {
				initialTaskIdsCopy.removeAll(successors);
			}		
		}
		return new ArrayList<Character>(initialTaskIdsCopy);
	}
	
	public List<Task> getInitialTasks() {
		List<Character> initialTaskIds = this.getInitialTaskIds();
		List<Task> initialTasks = getTasksFromIds(initialTaskIds);
		return initialTasks;
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
