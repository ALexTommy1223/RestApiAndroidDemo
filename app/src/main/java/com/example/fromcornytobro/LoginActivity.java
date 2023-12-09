package com.example.fromcornytobro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.fromcornytobro.api.AuthApiServer;
import com.example.fromcornytobro.databinding.ActivityLoginBinding;
import com.example.fromcornytobro.model.Auth;
import com.example.fromcornytobro.retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private AuthApiServer apiServer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        apiServer= RetrofitClient.getInstance().create(AuthApiServer.class);
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=binding.loginEmail.getText().toString().trim();
                String password=binding.loginPass.getText().toString().trim();
                Auth auth=new Auth();
                auth.setEmail(name);
                auth.setPassword(password);
                Call<String> call=apiServer.login(auth);
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if(response.isSuccessful()){
                            startActivity(new Intent(LoginActivity.this,MainActivity.class));
                            Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            if(name==null||password==null||password.length()<12){
                                Toast.makeText(LoginActivity.this, "email và password không được để trống", Toast.LENGTH_SHORT).show();
                            }
                            Toast.makeText(LoginActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Lỗi không load data", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Intent(LoginActivity.this,RegisterActivity.class);
            }
        });
    }
}