package com.example.Csoport.controller;

import com.example.Csoport.domain.LoginForm;
import com.example.Csoport.domain.RegisterForm;
import com.example.Csoport.domain.Users;
import com.example.Csoport.repository.UsersRepository;
import com.example.Csoport.service.UsersService;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    @Autowired
    private UsersRepository usersRepository;
    UsersService usersService;
    @Autowired
    private void setUsersService(UsersService us){this.usersService=us;}

    @GetMapping("")
    public String landing(){
        return "landing";
    }

    @GetMapping("/login")
    public String displayForm(LoginForm loginForm){
        return "login";
    }

    @GetMapping("/onlyvote")
    public String displayForm(){
        return "onlyVote";
    }

    @GetMapping("/register")
    public String index(Model model){
        model.addAttribute("registerForm", new RegisterForm());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute Users users, Model model){
        model.addAttribute("registerForm", new RegisterForm());

        //model.addAttribute("username", users.getUsername());
        //model.addAttribute("password", users.getPassword());

        Users userSaved = usersRepository.save(users);
        model.addAttribute("message", "Sikeres regisztráció.");
        return "register";
    }



    @PostMapping("/")
    public String login(@Valid LoginForm loginForm, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("usernameError", "Nem megfelelő felhasználónév");
            model.addAttribute("passwordError", "Nem megfelelő jelszó");
            return "login";
        }

        if(usersService.checkUser(loginForm.getUsername(), loginForm.getPassword())){
            model.addAttribute("user", null);
            return "vote";
        }else{
            model.addAttribute("error", "Nem megfelelő bejelentkezési adatok");
            return "login";
        }

    }

}
