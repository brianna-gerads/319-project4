package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Task;
import models.TaskGraph;
import algorithms.ReadInput;
import algorithms.CriticalPath;
import algorithms.PDM;

public class Main {

	public static void main(String args[]) throws FileNotFoundException {
		//read input file
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter your file name: ");
		String fileName = reader.next();
		File file = new File(fileName);
		
		//initialize taskgraph and criticalpath graph
		TaskGraph graph = new TaskGraph(new ArrayList<Task>());
		TaskGraph crit = new TaskGraph(new ArrayList<Task>());

		//read file and create initial task graph
		graph = ReadInput.readFile(file);
		List<Character> initialIds = graph.getInitialTaskIds();
		//System.out.println(initialIds.toString());

		//System.out.println(graph.getFinalTasksIds().toString());
		/*
		System.out.println(graph.getNextTaskIds(new Character('A')));
		System.out.println(graph.getNextTaskIds(new Character('B')));
		System.out.println(graph.getNextTaskIds(new Character('C')));
		System.out.println(graph.getNextTaskIds(new Character('D')));
		System.out.println(graph.getNextTaskIds(new Character('E')));
		System.out.println(graph.getNextTaskIds(new Character('F')));
		System.out.println(graph.getNextTaskIds(new Character('G')));
		System.out.println(graph.getNextTaskIds(new Character('H')));
		System.out.println(graph.getNextTaskIds(new Character('I')));
		System.out.println(graph.getNextTaskIds(new Character('J')));
		System.out.println(graph.getNextTaskIds(new Character('K')));
		System.out.println(graph.getNextTaskIds(new Character('L')));
		*/

		//call scheduler
		graph = PDM.calculateEarly(graph);
		//graph = PDM.calculatePDM(graph);
		
		//calculate critical path
		crit = algorithms.CriticalPath.criticalPath(graph);
		
		System.out.println();
		//print out PDM for task graph
		for(Task t : graph.getTasks()) {
			System.out.println("[ES: " + t.getES() + " EF: " + t.getEF() + " Task: " + t.getId() + " Duration: " + t.getDuration() + " LS: " + t.getLS() + " LF: " + t.getLF() + "]");
		}
		
		//print our critical path
		System.out.print("\n" + "Critical Path: ");
		for(Task t : crit.getTasks()) {
			System.out.print(t.getId() + ", ");
		}
		
		
	}
	
}
