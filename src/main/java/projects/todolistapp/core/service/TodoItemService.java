package projects.todolistapp.core.service;

import projects.todolistapp.core.model.TodoItem;

public interface TodoItemService {

    void addItem(TodoItem item);

    void removeItem(int id);

    TodoItem getItem(int id);
}