package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import models.Task;
import models.TaskGraph;
import algorithms.ReadInput;

public class Main {

	public static void main(String args[]) throws FileNotFoundException {
		//read input file
		//File file = new File("InputSample1");
		File file = new File("InputSample2");
		TaskGraph graph = new TaskGraph(new ArrayList<Task>());

		graph = ReadInput.readFile(file);
		
		
		//call scheduler
		
		//calculate critical path
	}
	
}
