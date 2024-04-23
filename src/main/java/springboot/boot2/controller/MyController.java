package springboot.boot2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springboot.boot2.model.User;
import springboot.boot2.service.UserService;

@Controller
public class MyController {
    private UserService userService;

    public MyController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/users")
    public String showCreateUserForm(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "list";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "user-info";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        userService.createOreUpdateUser(user);
        redirectAttributes.addFlashAttribute("message", "User created successfully!");
        return "redirect:/users";
    }

    @RequestMapping("/updateInfo")//получаем работника по id
    public String updateUser(@RequestParam("userId") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user-info";
    }

    @RequestMapping("/deleteInfo")
    public String deleteUser(@RequestParam("userId") long id, Model model) {
        model.addAttribute("user", userService.deleteUser(id));
        return "redirect:/users";
    }
}





