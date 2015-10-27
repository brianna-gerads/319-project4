package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import models.Task;
import models.TaskGraph;

public class ReadInput {
	
	public static TaskGraph readFile(File file) throws FileNotFoundException {
		Scanner s = new Scanner(file);
		TaskGraph graph = new TaskGraph(new ArrayList<Task>());
		
		while(s.hasNextLine()){
			String str = s.nextLine();
			Scanner lineScanner = new Scanner(str);
			List<Character> depen = new ArrayList<Character>();
			
			//initialize task with id and duration
			char id = (char) lineScanner.next().charAt(0);
			int duration = 0;
			
			//check that duration is an int
			try {
				duration = lineScanner.nextInt();
			} catch (Exception e) {
				System.err.println("Duration of Task was not found an int within the input file.");
				System.exit(0);
			}
			Task t = new Task(id, duration); 
			
			//check if task has dependencies
			if(lineScanner.hasNext()) {
				String depenString = lineScanner.next();
				List<String> strList = Arrays.asList(depenString.split(","));
				for(String string : strList) {
					Character c = string.charAt(0);
					
					//check that predecessor exists
					if (graph.getTaskFromId(c) != null) {
						//add dependencies and edge relationship
						depen.add(c);
						graph.addEdge(c, id);
					} else {
						System.err.println("Error in input file. Listed a task with a dependency that doesn't exist yet.");
						System.exit(0);
					}
				}
			}	
			if(!depen.isEmpty()) {
				t.setDependencies(depen);
			}
			graph.addTasks(t);
		}
		return graph;
	}
	
	
		/*
		
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
	
	//be aware of scanner probs**!**
	private static void checkDependencies(Task t, String dependencies, int numTasks) {
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
	}*/

}
