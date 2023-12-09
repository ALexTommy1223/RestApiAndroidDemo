package com.example.fromcornytopro.services;

import com.example.fromcornytopro.model.Auth;
import com.example.fromcornytopro.repository.RegisterRepository;
import com.example.fromcornytopro.serverinterface.AuthServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthServices implements AuthServiceInterface {
    @Autowired
    private RegisterRepository registerRepository;
    @Override
    public void registerUser(Auth register) {
        String email=register.getEmail().toLowerCase();
        // kiểm tra xem người dùng đã tồn tại chưa
        if(email==null || register.getPassword()==null){
            throw new RuntimeException("Email và mật khẩu không được để trống");
        }
        if (registerRepository.findByEmail(register.getEmail()).isPresent()) {
            throw new RuntimeException("Email đã tồn tại");
        }
        register.setPassword(register.getPassword());
        registerRepository.save(register);
    }

    @Override
    public List<Auth> getAllUser() {
        return registerRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }
    @Override
    public boolean loginUser(String email,String password){
        if(email==null|| password==null){
            throw new RuntimeException("Email và mật khẩu không được để trống");
        }
        Auth login=registerRepository.findByEmail(email).orElseThrow(()->new RuntimeException("Email không tồn tại"));
        // đăng nhập thành công
        return password.equalsIgnoreCase(login.getPassword());
    }

    @Override
    public Optional<Auth> getAuthById(int id) {
        return registerRepository.findById(id);
    }

    @Override
    public Auth updateAuth(int id, Auth auth) {
        Auth result=registerRepository.findById(id).orElseThrow();
        result.setEmail(auth.getEmail());
        result.setPassword(auth.getPassword());
        result.setName(auth.getName());
        result.setGender(auth.getGender());
        result.setHometown(auth.getHometown());
        return registerRepository.save(result);
    }

    @Override
    public void delete(int id) {
        registerRepository.deleteById(id);
    }

    @Override
    public Auth saveAuth(Auth auth) {
        return registerRepository.save(auth);
    }

}
