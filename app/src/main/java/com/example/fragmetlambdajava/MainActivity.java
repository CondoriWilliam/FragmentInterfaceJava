package com.example.fragmetlambdajava;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements ListenerFragmentComunication{
    private TextView edtUsername;
    private TextView edtFirtsName;
    private TextView edtLastName;
    private TextView edtEmail;
    private TextView edtPassword;
    private TextView edtPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtUsername = findViewById(R.id.edtUsernameActivity);
        edtFirtsName = findViewById(R.id.edtFirtsNameActivity);
        edtLastName = findViewById(R.id.edtLastNameActivity);
        edtEmail = findViewById(R.id.edtEmailActivity);
        edtPassword = findViewById(R.id.edtPasswordActivity);
        edtPhone = findViewById(R.id.edtPhoneActivity);

        AccountFragment accountFragment = new AccountFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, accountFragment)
                .commit();
    }
    public void listenerFragment(Usuario user){
        edtUsername.setText(user.getUserName());
        edtFirtsName.setText(user.getFirstName());
        edtLastName.setText(user.getLastName());
        edtEmail.setText(user.getEmail());
        edtPassword.setText(user.getPassword());
        edtPhone.setText(user.getPhone());
    }
}