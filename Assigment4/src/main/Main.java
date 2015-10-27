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
		
		//call scheduler
		graph = PDM.calculateEarly(graph);
		
		//calculate critical path
		//crit = algorithms.CriticalPath.criticalPath(graph);
		
		//print out PDM for task graph
		for(Task t : graph.getTasks()) {
			System.out.println("[ES: " + t.getES() + " EF: " + t.getEF() + " Task: " + t.getId() + " Duration: " + t.getDuration() + " LS: " + t.getLS() + " LF: " + t.getLF() + "]");
		}
		//print our critical path
		System.out.print("\n" + "Critical Path: ");
		/*
		for(Task t : crit.getTasks()) {
			System.out.println(t.getId() + " ");
		}
		*/
		
	}
	
}
