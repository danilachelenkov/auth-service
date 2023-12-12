package ru.netology.authservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class User {

    @NotNull
    @NotBlank
    @Size(min=1, max = 50)
    private String user;
    @NotBlank
    @Size(min=5, max = 15)
    private String password;

    public User() {
    }

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User userObj = (User) o;
        return Objects.equals(this.user, userObj.user) && Objects.equals(this.password, userObj.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.user, this.password);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + this.user + '\'' +
                ", password='" + this.password + '\'' +
                '}';
    }
}
