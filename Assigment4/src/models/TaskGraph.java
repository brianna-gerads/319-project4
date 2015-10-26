package models;

import java.util.List;

public class TaskGraph {
	
	private List<Task> tasks;
	
	public TaskGraph(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	public List<Task> getTasks(){
		return tasks;
	}
	
	public void addTasks(Task task){
		tasks.add(task);
	}

}
