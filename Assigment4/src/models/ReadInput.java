package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class ReadInput {
	
	private TaskGraph readFile(File file) throws FileNotFoundException {
		Scanner s = new Scanner(file);
		TaskGraph graph = new TaskGraph(new ArrayList<Task>());
		int numTasks = 0;
		
		while (s.hasNext()) {
			char id = s.next().charAt(0);
			int duration = 0;
			try {
				duration = s.nextInt();
			} catch (Exception e) {
				System.err.println("Duration of Task was not found an int within the input file. \n" + e.getMessage());
			}
			
			Task t = new Task (id, duration);
			graph.addTasks(t);
			numTasks++;
			
			// Check for dependencies
			String dependencies = s.nextLine();
			checkDependencies(t, dependencies, numTasks);
		}
		s.close();
		return graph;
	}
	
	private void checkDependencies(Task t, String dependencies, int numTasks) {
		// **NOTE** Make char array expandable
		
		dependencies.replaceAll("\\s+", "");
		Scanner dep = new Scanner(dependencies);;
		char[] depen = new char[numTasks];
		
		if (!dependencies.equals("")) {
			dep.useDelimiter(",");
			int i = 0;
			while (dep.hasNext()) {
				depen[i++] = dep.next().charAt(0);
			}
			dep.close();
			t.setDependencies(depen);
		}
		
		// **NOTE** ensure that dependencies have been run below!
		
		// **NOTE** check for a cycle of tasks' dependencies
	}

}
