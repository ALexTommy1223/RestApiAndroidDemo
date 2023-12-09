package com.example.fromcornytopro.controller;

import com.example.fromcornytopro.model.Auth;
import com.example.fromcornytopro.services.AuthServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private AuthServices authServices;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Auth login){
        String email=login.getEmail();
        String password=login.getPassword();

        if(authServices.loginUser(email,password)){
            return ResponseEntity.ok("Đăng nhập thành công");
        }
        else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Đăng nhập thất bại");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Auth register){
        Auth registerUserr=new Auth();
        registerUserr.setEmail(register.getEmail());
        registerUserr.setPassword(register.getPassword());
        try {
            authServices.registerUser(register);
            return ResponseEntity.ok("Đăng ký thành công");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Đăng ký thất bại");
        }
    }
    @GetMapping
    public List<Auth> getAllUser(){
        return authServices.getAllUser();
    }
    @PostMapping
    public Auth saveAuth(@RequestBody Auth auth) {
        return authServices.saveAuth(auth);
    }
    @GetMapping("/{id}")
    public Optional<Auth> getAuthById(@PathVariable int id){
        return authServices.getAuthById(id);
    }
    @PutMapping("/{id}")
    public Auth updateAuth(@PathVariable int id, @RequestBody Auth auth){
        return authServices.updateAuth(id,auth);
    }
    @DeleteMapping("/{id}")
    public void deleteAuth(@PathVariable int id){
        authServices.delete(id);
    }
 }
