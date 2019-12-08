package projects.todolistapp.core.model;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                                            CascadeType.DETACH, CascadeType.REFRESH})
    private List<TodoItem> todoItems;

    public void addTodoItem(TodoItem todoItem) {
        if(todoItems == null) {
            todoItems = new ArrayList<>();
        }
        todoItems.add(todoItem);
        todoItem.setUser(this);
    }

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;
}