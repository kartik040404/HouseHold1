package com.example.household;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.Nullable;

public class service_provider_track_module extends AppCompatActivity {
    Button b1, b2, b3, b4;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    String val = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_track);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        b4 = findViewById(R.id.button2);
        String service = getIntent().getStringExtra("service");
        String username = getIntent().getStringExtra("user");
        String getuname = getIntent().getStringExtra("serviceProvider");
        reference = FirebaseDatabase.getInstance().getReference().child(service).child(username).child("ServiceProvider").child(getuname).child("Track").child("val");
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                val = String.valueOf(snapshot.getValue());
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(service_provider_track_module.this, "Step 1 Update Successful", Toast.LENGTH_SHORT).show();
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(service).child(username).child("ServiceProvider").child(getuname).child("Track");
                UserHelperClassForTrack helperClass = new UserHelperClassForTrack("1", "0", "0", "0", val);
                reference.setValue(helperClass);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Step 2 Update Successful", Toast.LENGTH_SHORT).show();
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(service).child(username).child("ServiceProvider").child(getuname).child("Track");
                UserHelperClassForTrack helperClass = new UserHelperClassForTrack("1", "1", "0", "0", val);
                reference.setValue(helperClass);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Step 3 Update Successful", Toast.LENGTH_SHORT).show();
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(service).child(username).child("ServiceProvider").child(getuname).child("Track");
                UserHelperClassForTrack helperClass = new UserHelperClassForTrack("1", "1", "1", "0", val);
                reference.setValue(helperClass);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Step 4 Update Successful", Toast.LENGTH_SHORT).show();
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(service).child(username).child("ServiceProvider").child(getuname).child("Track");
                UserHelperClassForTrack helperClass = new UserHelperClassForTrack("1", "1", "1", "1", val);
                reference.setValue(helperClass);
            }
        });
    }
}