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
		int maxEF = Integer.MIN_VALUE;
		for(Task t : input.getFinalTasks()) { //Find max EF
			int EF = t.getEF();
			if(maxEF < EF) {
				maxEF = EF;
			}
		}
		
		for(Task t : input.getFinalTasks()) {
			int duration = t.getDuration();
			t.setLF(maxEF);
			t.setLS(maxEF - duration);
			setLateOfDependencies(input, t);
		}
		
		return input;
	}
	
	private static void setLateOfDependencies(TaskGraph graph, Task t) {
		Character[] dependencies = t.getDependencies();
		if(dependencies == null) {
			return;
		}
		for(Character depen : dependencies) {
			Task task = graph.getTaskFromId(depen);
			int LF = t.getLS();
			int duration = task.getDuration();
			if(task.getLF() > LF) {
				task.setLF(LF);
				task.setLS(LF - duration);
			}
			
			
			setLateOfDependencies(graph, task);
		}
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
