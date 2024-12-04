package com.weekly_bump.Controller;

import com.weekly_bump.Service.UserService;
import com.weekly_bump.Model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // Show login page
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        User user = userService.getUserByEmail(email).orElse(null);
        if (user == null) {
            System.out.println("User not found.");
            model.addAttribute("error", "Invalid credentials.");
            return "login";
        }

        System.out.println("User found: " + user.getEmail() + ", Role: " + user.getRole());

        if (user.getPassword().equals(password)) {
            session.setAttribute("loggedInUser", user);
            if ("ROLE_ADMIN".equals(user.getRole())) {
                return "redirect:/admin/dashboard";
            } else {
                return "redirect:/home";
            }
        } else {
            System.out.println("Incorrect password.");
            model.addAttribute("error", "Invalid credentials.");
            return "login";
        }
    }



    // Register page
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";  // Show registration page
    }

    @PostMapping("/register")
    public String registerUser(User user, Model model) {
        if (userService.getUserByEmail(user.getEmail()).isPresent()) {
            model.addAttribute("error", "Email already in use.");
            return "register";  // Return to register page if email is taken
        }
        user.setRole("ROLE_USER");  // Default role is user
        userService.saveUser(user);  // Save new user
        return "redirect:/login";  // Redirect to login page after successful registration
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
