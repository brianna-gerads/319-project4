package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import algorithms.ReadInput;
import models.Task;
import models.TaskGraph;

public class Main {

	public static void main(String args[]) throws FileNotFoundException {
		//read input file
		//File file = new File("InputSample1");
		File file = new File("InputSample2");
		TaskGraph graph = new TaskGraph(new ArrayList<Task>());

		graph = ReadInput.readFile(file);
		List<Character> initialIds = graph.getInitialTaskIds();
		System.out.println(initialIds.toString());
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
	}
	
}
