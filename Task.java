package main;

public class Task {
	
	String taskID;
	String name;
	String description;
	
	public static void testValidLength(String word, int charLimit) throws IllegalArgumentException {
		if ((word == null || !(word.length() <= charLimit))) throw new IllegalArgumentException ("The " + word + " is null or too long");
	}
	
	// Constructor of Task
	public Task (String taskID, String name, String description) {
		
		testValidLength(taskID, 10); 
		testValidLength(name, 20);
		testValidLength(description, 50);
		
		this.taskID = taskID;
		this.name = name;
		this.description = description;
		
	}
	
	// Getters and Setters
	public String getTaskID () {
		return taskID;
	}
	public void setTask (String taskID) {
		this.taskID = taskID;
	}
	
	public String getName () {
		return name;
	}
	public void setName (String name) {
		this.name = name;
	}
	
	public String getDescription () {
		return description;
	}
	public void setDescription (String description) {
		this.description = description;
	}

}
