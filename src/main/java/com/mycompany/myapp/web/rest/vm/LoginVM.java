package com.mycompany.myapp.web.rest.vm;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginVM {

    @NotNull
    @Size(min = 1, max = 50)
    private String username;

    @NotNull
    @Size(min = 4, max = 100)
    private String password;

    private boolean rememberMe;

    public LoginVM(String username, String password, boolean rememberMe) {
        this.username = username;
        this.password = password;
        this.rememberMe = rememberMe;
    }

    public LoginVM() {}

    public @NotNull @Size(min = 1, max = 50) String getUsername() {
        return username;
    }

    public void setUsername(@NotNull @Size(min = 1, max = 50) String username) {
        this.username = username;
    }

    public @NotNull @Size(min = 4, max = 100) String getPassword() {
        return password;
    }

    public void setPassword(@NotNull @Size(min = 4, max = 100) String password) {
        this.password = password;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    @Override
    public String toString() {
        return "LoginVM{" + "username='" + username + '\'' + ", password='" + password + '\'' + ", rememberMe=" + rememberMe + '}';
    }
}
