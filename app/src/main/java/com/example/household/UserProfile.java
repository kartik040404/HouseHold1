package com.example.household;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class UserProfile extends AppCompatActivity {

    EditText fullName, eMail, PhoneNo, passWord;
    TextView FullNameLabel, userNameLabel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        //Hooks
            fullName = findViewById(R.id.full_name_field);
            eMail = findViewById(R.id.email_profile);
            PhoneNo = findViewById(R.id.phone_no_profile);
            passWord = findViewById(R.id.password_profile);
            FullNameLabel = findViewById(R.id.full_name_profile);
            userNameLabel = findViewById(R.id.username_field);

            showAllUserData();
            
    }

    private void showAllUserData() {
        Intent intent = getIntent();
        String user_username = intent.getStringExtra("username");
        String user_name = intent.getStringExtra("name");
        String user_email = intent.getStringExtra("email");
        String user_phoneNo = intent.getStringExtra("phoneNo");
        String user_passowrd = intent.getStringExtra("password");

        FullNameLabel.setText(user_name);
        userNameLabel.setText(user_username);
        fullName.setText(user_name);
        eMail.setText(user_email);
        passWord.setText(user_passowrd);

    }
}