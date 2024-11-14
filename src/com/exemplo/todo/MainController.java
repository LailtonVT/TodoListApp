package com.exemplo.todo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class MainController {
	
	@FXML
	private TextField titleField;
	
	@FXML
	private TextField descriptionField;
	
	@FXML
	private ListView<TodoItem> listView;
	
	@FXML
	private Button addButton;
	
	@FXML
	private Button editButton;
	
	@FXML
	private Button deleteButton;
	
	private TodoList todoList;
	
	public MainController() {
		todoList = new TodoList();
	}
    
	@FXML
	public void initialize() {
	//Inicializar os botoes com os eventos
	addButton.setOnAction(event -> addItem());
	editButton.setOnAction(event -> editItem());
	deleteButton.setOnAction(event -> deleteItem());

	//Desabilita os botoes de editar e excluir se nao houver item selecionado
	listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
		boolean itemSelected = newValue != null;
		editButton.setDisable(!itemSelected);
		deleteButton.setDisable(!itemSelected);
	});
	
	
	}
	
	public void addItem() {
		//Criar um novo item da tarefa
		String title = titleField.getText();
		String description = descriptionField.getText();
		
		if (!title.isEmpty() && !description.isEmpty()) {
			TodoItem newItem = new TodoItem(title, description);
			todoList.addItem(newItem);
			listView.getItems().add(newItem);
			titleField.clear();
			descriptionField.clear();
		}
	}
	
	public void editItem() {
		TodoItem selectedItem = listView.getSelectionModel().getSelectedItem();
		
		if(selectedItem != null) {
			//Preenhcer os campos do texto com dados da tarefa selecionada
			titleField.setText(selectedItem.getTitle());
			descriptionField.setText(selectedItem.getDescription());
			
			//Quando o usuario clicar em salvar, atualizar a tarefa
			addButton.setText("Save");
			addButton.setOnAction(event -> {
				selectedItem.setTitle(titleField.getText());
				selectedItem.setDescription(descriptionField.getText());
				listView.refresh(); //Atualizar a listView
				addButton.setText("Add");
				addButton.setOnAction(e -> addItem()); //Reseta acao do botao
				titleField.clear();
				descriptionField.clear();
			});
		}
	}
	
	public void deleteItem() {
	    TodoItem selectedItem = listView.getSelectionModel().getSelectedItem();

	    if (selectedItem != null) {
	        listView.getItems().remove(selectedItem);
	        titleField.clear();
	        descriptionField.clear();
	    }
	}

	
}
