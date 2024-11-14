package com.exemplo.todo;

public class TodoItem {
	private String title;
	private String description;
	
	//Construtor
	public TodoItem(String title, String description) {
		this.title = title;
		this.description = description;
	}
	
	//Getters e Setters
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString( ) {
		return title + ": " + description;
	}
	
}
