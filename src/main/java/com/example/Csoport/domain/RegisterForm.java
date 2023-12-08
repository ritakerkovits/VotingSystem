package com.example.Csoport.domain;

import jakarta.validation.constraints.NotEmpty;

public class RegisterForm {

    @NotEmpty(message = "Az email nem lehet üres")
    private String email;
    @NotEmpty(message = "A felhasználónév nem lehet üres")
    private String username;
    @NotEmpty(message = "A jelszó nem lehet üres")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
