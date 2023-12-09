package com.example.fromcornytopro.serverinterface;

import com.example.fromcornytopro.model.Auth;

import java.util.List;
import java.util.Optional;

public interface AuthServiceInterface {
    void registerUser(Auth register);
    public List<Auth> getAllUser();
    boolean loginUser(String email,String password);

    public Optional<Auth> getAuthById(int id);
    public Auth updateAuth(int id, Auth auth);
    public void delete(int id);

    Auth saveAuth(Auth auth);
}
