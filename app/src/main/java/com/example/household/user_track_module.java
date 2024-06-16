package com.example.household;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class user_track_module extends AppCompatActivity {
    Button b1;
    String val1="0",val2="0",val3="0",val4="0";
    View v1,v2,v3,v4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_track);

        b1=findViewById(R.id.button);
        v1=findViewById(R.id.viewOrderplace);
        v2=findViewById(R.id.vieworderconf);
        v3=findViewById(R.id.viewordprocess);
        v4=findViewById(R.id.viewordready);
        String service=getIntent().getStringExtra("service");
        String getuname=getIntent().getStringExtra("serviceProviderName");
        String username=getIntent().getStringExtra("User_name");
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(service).child(username).child("ServiceProvider").child(getuname).child("Track");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                val1 = snapshot.child("val1").getValue().toString();
                val2 = snapshot.child("val2").getValue().toString();
                val3 = snapshot.child("val3").getValue().toString();
                val4 = snapshot.child("val4").getValue().toString();
                if(val1.equals("0")){
                    v1.setBackgroundResource(R.drawable.shape_status_remaining);
                }
                else{
                    v1.setBackgroundResource(R.drawable.shape_status_complete);

                }

                if(val2.equals("0")){
                    v2.setBackgroundResource(R.drawable.shape_status_remaining);
                }
                else{
                    v2.setBackgroundResource(R.drawable.shape_status_complete);

                }

                if(val3.equals("0")){
                    v3.setBackgroundResource(R.drawable.shape_status_remaining);
                }
                else{
                    v3.setBackgroundResource(R.drawable.shape_status_complete);

                }
                if(val4.equals("0")){
                    v4.setBackgroundResource(R.drawable.shape_status_remaining);
                }
                else{
                    v4.setBackgroundResource(R.drawable.shape_status_complete);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}