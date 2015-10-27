package algorithms;

import java.util.ArrayList;
import models.Task;
import models.TaskGraph;

public class CriticalPath {

	public static TaskGraph criticalPath(TaskGraph graph) {
		TaskGraph critPath = new TaskGraph(new ArrayList<Task>());

		//get tasks of critpathTask
		for (Task t : graph.getTasks()) {
			if ((t.getES() == t.getLS()) && (t.getEF() == t.getLF())) {
				critPath.addTasks(t);
			}
		}
		
		return critPath;
	}
}
