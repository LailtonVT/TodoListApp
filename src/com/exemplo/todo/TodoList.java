package com.exemplo.todo;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
	private List<TodoItem> items;
	
	public TodoList() {
		items = new ArrayList<>();
	}
	
	public void addItem(TodoItem item) {
		items.add(item);
	}
	
	public void removeItem(TodoItem item) {
		items.remove(item);
	}
	
	public List<TodoItem> getItems() {
		return items;
	}
}
