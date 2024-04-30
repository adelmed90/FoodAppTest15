package dz.mradel.foodapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import dz.mradel.foodapp.R;
import dz.mradel.foodapp.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity {

    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setVariable();

    }

    private void setVariable() {
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=binding.userEdt.getText().toString();
                String password=binding.passEdt.getText().toString();

                if (!email.isEmpty()&&!password.isEmpty()){
                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, task -> {
                        if(task.isSuccessful()){
                            startActivity(new Intent(LoginActivity.this,MainActivity.class));
                        }else {
                            Toast.makeText(LoginActivity.this, "Authentication failed",Toast.LENGTH_SHORT).show();
                        }
                    });
                }else {
                    Toast.makeText(LoginActivity.this, "please fill username and password",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}