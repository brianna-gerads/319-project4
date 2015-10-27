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

public class Main {

	public static void main(String args[]) throws FileNotFoundException {
		//read input file
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter your file name: ");
		String fileName = reader.next();
		File file = new File(fileName);
		//File file = new File("InputSample1");
		//File file = new File("InputSample2");
		TaskGraph graph = new TaskGraph(new ArrayList<Task>());
		TaskGraph crit = new TaskGraph(new ArrayList<Task>());

		graph = ReadInput.readFile(file);
		List<Character> initialIds = graph.getInitialTaskIds();
		System.out.println(initialIds.toString());
		System.out.println(graph.getFinalTasksIds().toString());
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
		
		//calculate critical path
		//crit = algorithms.CriticalPath.criticalPath(graph);
		
		//print out PDM for task graph
		for(Task t : graph.getTasks()) {
			System.out.println("ES: " + t.getES() + "EF: " + t.getEF() + "Task: " + t.getId() + "LS: " + t.getLS() + "LF: " + t.getLF() + "\n");
		}
		//print our critical path
		System.out.print("Critical Path: ");
		/*
		for(Task t : crit.getTasks()) {
			System.out.println(t.getId() + " ");
		}
		*/
		
	}
	
}
