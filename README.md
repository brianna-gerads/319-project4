# 319-project4

<b>To Run:</b>
  1. Run Main. This will ask the user to input their sample file name. The sample file should be saved in the package or you will need to provide the path to the file.
  2. Once you run Main, this will automatically call our PDM scheduler and will print it out in the following pattern:
      [ES: # EF: # Task: taskID Duration: # LS: # LF: #]
  3. Following, it will call our critical path calculater and print out a list of the tasks found in the critical path.

<b>Test Files:</b>
  - Two test files have been included with the code.
      - SampleInput1 : This was the shorter example posted on BlackBoard
      - SampleInput2 : This was the more complex example completed for homework assignment 3
      - SampleInput3 : This was used for testing. It contains a duration that is not an int and exemplifies that our program catches it
      - SampleInput4 : This was used for testing. It contains a task with a predecessor that does not exist yet and exemplifies that our program catches this error
      - SampleInput5 : This was used for testing. It contains tasks with a cycle in the task dependencies and exemplifies that our program catches this error
  
<b>Program Explained</b>
- <i>models:</i> The user will notice there is a models package with 2 models: Task and TaskGraph
    - <i>Task:</i> This is the task and all its characteristics (id, duration, es, ef, ls, lf, an array of dependencies)
    - <i>TaskGraph:</i> This is a Graph containing all of the tasks read in from the user's file
- <i>algorithms:</i> There are three algorithm classes. We created each class to represent each part listed in the homework description
    - <i>ReadInput:</i> This is where the file is read. Each task is created, assigned an id and duration and then stored into a TaskGraph. This is also where all of the input checks take place.
    - <i>PDM:</i> This is where the scheduler algorithm is. It is broken into 3 methods.
      - One method calculates the early start and finish because this only relies on already declared information. This does so by first calculating the initial tasks with no dependencies, then calculates the rest of the tasks by pulling the longest running dependency and using its ef as the es.
      - The second method calculates the late start and finish - This was also seperated from the first method for cleanliness and testing purposes. This method works backwards through the tasks to identify the late finish first.
      - The third method calculates the two together so this is what is called in Main for the user.
    - <i>CriticalPath:</i> This first calculates the initial tasks and checks if the es is equal to the ls and if the ef is equal to the lf. Next it calculates this for all tasks. If it fits these criteria at any point, it is added to a TaskGraph storing only the critical path. This is then called in Main and printed out for the user.
- <i>main:</i> This is where the user is asked for the file containing their tasks, then it processes the readinput, pdm and critical path and prints all the necessary user information to the console.
