package com.example.household;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Dashboard extends AppCompatActivity {
    EditText uOrSp;
    Button submitBtn;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        uOrSp = findViewById(R.id.userorserviceprovider);
        submitBtn = findViewById(R.id.sub);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = getIntent();
                String user_username = intent.getStringExtra("username");
                String user_name = intent.getStringExtra("name");
                String user_email = intent.getStringExtra("email");
                String user_phoneNo = intent.getStringExtra("phoneNo");
                String user_passowrd = intent.getStringExtra("password");

                String key = uOrSp.getText().toString();

                if(key.equals("0") || key.equals("1")){
                    rootNode = FirebaseDatabase.getInstance();

                    reference = rootNode.getReference("users");
                    UserHelperClass helperClass = new UserHelperClass(key);
                    reference.child(user_username).child("key").setValue(helperClass);

                    Toast.makeText(Dashboard.this, "Success", Toast.LENGTH_SHORT).show();
                }
                else{
                    uOrSp.setError("Value must Either 0 or 1");
                }

                Intent intent1;
                if(key.equals("1")){
                    intent1 = new Intent(Dashboard.this, UserProfile.class);
                }
                else{
                    intent1 = new Intent(Dashboard.this, SelectService.class);
                }
                startActivity(intent1);


//                rootNode = FirebaseDatabase.getInstance();
//
//                reference = rootNode.getReference("users");
//                UserHelperClass helperClass = new UserHelperClass(key);
//                reference.child(user_username).child("key").setValue(helperClass);
//
//                Toast.makeText(Dashboard.this, "Success", Toast.LENGTH_SHORT).show();

            }
        });
    }

//    private void getUserName() {
//
//
//        Intent intent = getIntent();
//        String user_username = intent.getStringExtra("username");
//        String user_name = intent.getStringExtra("name");
//        String user_email = intent.getStringExtra("email");
//        String user_phoneNo = intent.getStringExtra("phoneNo");
//        String user_passowrd = intent.getStringExtra("password");
//
//    }
}