package projects.todolistapp.webb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import projects.todolistapp.core.model.User;
import projects.todolistapp.core.service.UserService;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void init() {
        User user = new User();
        user.setEmail("user@email.com");
        user.setPassword("qwerty");
        user.setUsername("Anthony");
        userService.saveUser(user);
    }

    @GetMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView model = new ModelAndView();
        model.setViewName("/login");

        return model;
    }

    @GetMapping(value = "/signup")
    public ModelAndView signup() {
        ModelAndView model = new ModelAndView();
        User user = new User();
        model.addObject("user", user);
        model.setViewName("/signup");

        return model;
    }

    @PostMapping(value = "/signup")
    public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView();
        User userExists = userService.findByEmail(user.getEmail());

        if(userExists != null) {
            bindingResult.rejectValue("email", "error.user", "This email already exists!");
        } else if(bindingResult.hasErrors()) {
            model.setViewName("user/signup");
        } else {
            userService.saveUser(user);
            model.addObject("user", new User());
            model.addObject("msg", "User registered successfully!");
            model.setViewName("/signup");
        }
        return model;
    }

    @GetMapping(value = "/access_denied")
    public ModelAndView accessDenied() {
        ModelAndView model = new ModelAndView();
        model.setViewName("/access_denied");
        return model;
    }
}