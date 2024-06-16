package com.example.household;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SelectService extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_service);
        ImageView plumber = findViewById(R.id.plumber);
        ImageView elect = findViewById(R.id.elect);
        ImageView carpenter = findViewById(R.id.carp);
        ImageView homeP = findViewById(R.id.homep);
        ImageView carcleaning = findViewById(R.id.carclean);
        ImageView ac = findViewById(R.id.ac);
        ImageView homeC = findViewById(R.id.homepcleaning);
        ImageView pest = findViewById(R.id.pest);


        Intent intent = getIntent();
        String user_username = intent.getStringExtra("username");
        String user_name = intent.getStringExtra("name");
        String user_email = intent.getStringExtra("email");
        String user_phoneNo = intent.getStringExtra("phoneNo");
        String user_passowrd = intent.getStringExtra("password");


        plumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), BookService.class);

                intent3.putExtra("service", "Plumber");
                intent3.putExtra("name", user_username);
                intent3.putExtra("username", user_name);
                intent3.putExtra("email", user_email);
                intent3.putExtra("phoneNo", user_phoneNo);
                intent3.putExtra("password", user_passowrd);
                startActivity(intent3);
            }
        });

        elect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), BookService.class);

                intent3.putExtra("service", "Electrician");
                intent3.putExtra("name", user_username);
                intent3.putExtra("username", user_name);
                intent3.putExtra("email", user_email);
                intent3.putExtra("phoneNo", user_phoneNo);
                intent3.putExtra("password", user_passowrd);
                startActivity(intent3);
            }
        });

        carpenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), BookService.class);

                intent3.putExtra("service", "Carpenter");
                intent3.putExtra("name", user_username);
                intent3.putExtra("username", user_name);
                intent3.putExtra("email", user_email);
                intent3.putExtra("phoneNo", user_phoneNo);
                intent3.putExtra("password", user_passowrd);
                startActivity(intent3);
            }
        });

        homeP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), BookService.class);

                intent3.putExtra("service", "HomePainting");
                intent3.putExtra("name", user_username);
                intent3.putExtra("username", user_name);
                intent3.putExtra("email", user_email);
                intent3.putExtra("phoneNo", user_phoneNo);
                intent3.putExtra("password", user_passowrd);
                startActivity(intent3);
            }
        });

        carcleaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), BookService.class);

                intent3.putExtra("service", "carcleaning");
                intent3.putExtra("name", user_username);
                intent3.putExtra("username", user_name);
                intent3.putExtra("email", user_email);
                intent3.putExtra("phoneNo", user_phoneNo);
                intent3.putExtra("password", user_passowrd);
                startActivity(intent3);
            }
        });

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), BookService.class);

                intent3.putExtra("service", "Ac");
                intent3.putExtra("name", user_username);
                intent3.putExtra("username", user_name);
                intent3.putExtra("email", user_email);
                intent3.putExtra("phoneNo", user_phoneNo);
                intent3.putExtra("password", user_passowrd);
                startActivity(intent3);
            }
        });

        homeC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), BookService.class);

                intent3.putExtra("service", "HomeCleaning");
                intent3.putExtra("name", user_username);
                intent3.putExtra("username", user_name);
                intent3.putExtra("email", user_email);
                intent3.putExtra("phoneNo", user_phoneNo);
                intent3.putExtra("password", user_passowrd);
                startActivity(intent3);
            }
        });

        pest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), BookService.class);

                intent3.putExtra("service", "PestControl");
                intent3.putExtra("name", user_username);
                intent3.putExtra("username", user_name);
                intent3.putExtra("email", user_email);
                intent3.putExtra("phoneNo", user_phoneNo);
                intent3.putExtra("password", user_passowrd);
                startActivity(intent3);
            }
        });


    }
}