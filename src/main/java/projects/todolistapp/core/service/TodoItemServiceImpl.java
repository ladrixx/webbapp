package projects.todolistapp.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.todolistapp.core.model.TodoItem;
import projects.todolistapp.core.repository.TodoItemRepository;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    @Autowired
    private TodoItemRepository todoItemRepository;

    @Override
    public void addItem(TodoItem item) {
        todoItemRepository.save(item);
    }

    @Override
    public void removeItem(int id) {
        todoItemRepository.deleteById(id);
    }

    @Override
    public TodoItem getItem(int id) {
        return todoItemRepository.findById(id);
    }
}