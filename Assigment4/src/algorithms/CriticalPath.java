package algorithms;

import java.util.ArrayList;
import java.util.List;

import models.Task;
import models.TaskGraph;

public class CriticalPath {

	public static TaskGraph criticalPath(TaskGraph graph) {
		TaskGraph critPath = new TaskGraph(new ArrayList<Task>());
		
		//get tasks without dependencies
		List<Task> initTasks = graph.getInitialTasks();
		//iterate through tasks
		//check that es == ls && ef == lf
		for (Task t : initTasks) {
			if ((t.getES() == t.getLS()) && (t.getEF() == t.getLF())) {
				critPath.addTasks(t);
			}
		}
		
		//get tasks of critpathTask
		for (Task t : critPath.getTasks()) {
			List<Task> next = critPath.getNextTasks(t.getId());
			for (Task n : next) {
				if ((n.getES() == n.getLS()) && (n.getEF() == n.getLF())) {
					critPath.addTasks(n);
				}
			}
		}
		
		return critPath;
		
	}
}
