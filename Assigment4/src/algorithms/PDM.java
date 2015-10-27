package algorithms;

import java.util.ArrayList;

import models.Task;
import models.TaskGraph;

public class PDM {
	
	/*
	 * calculate first
	 */
	public static TaskGraph calculateEarly(TaskGraph input) {
		TaskGraph output = new TaskGraph(new ArrayList<Task>());
		
		return output;
	}
	
	/*
	 * Calculate the Late part after early because you need early to calculate late
	 */
	public static TaskGraph calculateLate(TaskGraph input) {
		TaskGraph output = new TaskGraph(new ArrayList<Task>());
		
		return output;
	}
	
	/*
	 * compile the taskgraph with all things compiled
	 */
	public static TaskGraph calculatePDM(TaskGraph input) {
		TaskGraph output = new TaskGraph(new ArrayList<Task>());
		output = calculateEarly(input);
		output = calculateLate(output);
		
		return output;
	}

}
