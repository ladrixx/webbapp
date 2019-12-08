package projects.todolistapp.webb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import projects.todolistapp.core.model.TodoItem;
import projects.todolistapp.core.service.TodoItemService;
import projects.todolistapp.core.util.AttributeNames;
import projects.todolistapp.core.util.Mappings;
import projects.todolistapp.core.util.ViewNames;

@Controller
public class TodoItemController {

    @Autowired
    private TodoItemService todoItemService;

    @GetMapping(Mappings.ITEMS)
    public String items() {

        return ViewNames.ITEMS_LIST;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addItem(Model model) {
        TodoItem todoItem = new TodoItem();
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);

        return ViewNames.ADD_ITEM;
    }

    @PostMapping(value = "/addItem")
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem) {
        todoItemService.addItem(todoItem);

        return "redirect:/" + Mappings.ITEMS;
    }
}