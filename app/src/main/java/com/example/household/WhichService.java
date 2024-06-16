package com.example.household;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WhichService extends AppCompatActivity {
    FirebaseDatabase rootNode;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_which_service);
        Button plum = findViewById(R.id.plumberBtn);
        Button elect = findViewById(R.id.ElectricianBtn);
        Button carp = findViewById(R.id.CarpenterBtn);
        Button homepainting = findViewById(R.id.HomePaintingBtn);
        Button carcln = findViewById(R.id.CarcleaningBtn);
        Button apprpr = findViewById(R.id.ApplianceRepairBtn);
        Button fullhomeclean = findViewById(R.id.HomeFullCleaningBtn);
        Button pestControl = findViewById(R.id.PestControlBtn);

        Intent intent = getIntent();
        String user_username = intent.getStringExtra("username");
        String user_name = intent.getStringExtra("name");
        String user_email = intent.getStringExtra("email");
        String user_phoneNo = intent.getStringExtra("phoneNo");
        String user_passowrd = intent.getStringExtra("password");



        plum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reff = rootNode.getReference("users");
                UserHelperClass2 Exp = new UserHelperClass2("0","3");
                reff.child(user_username).child("exp").setValue(Exp);
                Toast.makeText(WhichService.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(WhichService.this, Login.class);
                startActivity(intent);

            }
        });

        elect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reff = rootNode.getReference("users");
                UserHelperClass2 Exp = new UserHelperClass2("1","3");
                reff.child(user_username).child("exp").setValue(Exp);

                Intent intent = new Intent(WhichService.this, Login.class);
                Toast.makeText(WhichService.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
        });

        carp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reff = rootNode.getReference("users");
                UserHelperClass2 Exp = new UserHelperClass2("2","3");
                reff.child(user_username).child("exp").setValue(Exp);
                Toast.makeText(WhichService.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(WhichService.this, Login.class);
                startActivity(intent);

            }
        });

        homepainting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reff = rootNode.getReference("users");
                UserHelperClass2 Exp = new UserHelperClass2("3","3");
                reff.child(user_username).child("exp").setValue(Exp);

                Intent intent = new Intent(WhichService.this, Login.class);
                Toast.makeText(WhichService.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
        });

        carcln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reff = rootNode.getReference("users");
                UserHelperClass2 Exp = new UserHelperClass2("4","3");
                reff.child(user_username).child("exp").setValue(Exp);
                Toast.makeText(WhichService.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(WhichService.this, Login.class);
                startActivity(intent);

            }
        });

        apprpr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reff = rootNode.getReference("users");
                UserHelperClass2 Exp = new UserHelperClass2("5","3");
                reff.child(user_username).child("exp").setValue(Exp);

                Intent intent = new Intent(WhichService.this, Login.class);
                Toast.makeText(WhichService.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
        });

        fullhomeclean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reff = rootNode.getReference("users");
                UserHelperClass2 Exp = new UserHelperClass2("6","3");
                reff.child(user_username).child("exp").setValue(Exp);
                Toast.makeText(WhichService.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(WhichService.this, Login.class);
                startActivity(intent);

            }
        });

        pestControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reff = rootNode.getReference("users");
                UserHelperClass2 Exp = new UserHelperClass2("7","3");
                reff.child(user_username).child("exp").setValue(Exp);

                Intent intent = new Intent(WhichService.this, Login.class);
                Toast.makeText(WhichService.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
        });

    }


}