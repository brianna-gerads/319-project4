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
			//check that task does not already exist (task cycle check)
			if (graph.getTaskFromId(id) != null) {
				System.err.println("Error in input file. ReListed a task that has already been created. Please check your file.");
				System.exit(0);
			}
			
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
						System.err.println("This is either a cycle in dependencies or an error in your list of tasks. Please check your file.");
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
}
