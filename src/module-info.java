module TodoListApp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.exemplo.todo to javafx.fxml;
    exports com.exemplo.todo;
}
