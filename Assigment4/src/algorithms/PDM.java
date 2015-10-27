package algorithms;

import java.util.ArrayList;

import models.Task;
import models.TaskGraph;

public class PDM {
	
	/*
	 * calculate first
	 */
	public static TaskGraph calculateEarly(TaskGraph input) {	
		for(Task t : input.getInitialTasks()) {
			t.setES(0);
			t.setEF(t.getDuration());
		}
		for(Task t : input.getTasks()) {
			Character[] depen = t.getDependencies();
			if (t.hasDependencies()) {
				int len = depen.length;
				
				//retrieve latest EF from previous tasks
				int prevEF = 0;
				for (int i = 0; i < len; i++) {
					Task n = input.getTaskFromId(depen[i]);
					if (n.getEF() > prevEF) prevEF = n.getEF();
				}
				
				//set ES and EF now
				t.setES(prevEF);
				t.setEF(t.getDuration() + prevEF);
			}
		}
		return input;
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
		input = calculateEarly(input);
		input = calculateLate(input);
		
		return input;
	}

}
