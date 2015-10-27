package models;

import java.util.ArrayList;
import java.util.List;
import models.Task;

public class TaskGraph {
	
	private List<Task> tasks;
	
	public TaskGraph(ArrayList<Task> arrayList) {
		this.tasks = arrayList;
	}

	public List<Task> getTasks(){
		return tasks;
	}
	
	public void addTasks(Task task){
		tasks.add(task);
	}

}
