package com.example.household;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class fullDescriptionOfServiceProviderResponce extends AppCompatActivity {
    EditText t1,t2;
    DatabaseReference ref;
    Button b;
    Button b1;
    String val1="0",val2="0",val3="0",val4="0";
    View v1,v2,v3,v4;
    ConstraintLayout ut;
    LinearLayout l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_description_of_service_provider_responce);
        b=(Button)findViewById(R.id.go);
        t1=(EditText)findViewById(R.id.rating);
        t2=(EditText)findViewById(R.id.phone_no);
        ut=(ConstraintLayout)findViewById(R.id.usert);
        l=(LinearLayout)findViewById(R.id.usermain);
        String username12=getIntent().getStringExtra("UserName");
        String phone=getIntent().getStringExtra("Phone_no");
        String service=getIntent().getStringExtra("service");
        String getuname=getIntent().getStringExtra("serviceProviderName");
        String username=getIntent().getStringExtra("User_name");
        t1.setText(username12);
        t2.setText(phone);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(fullDescriptionOfServiceProviderResponce.this,User_Track_module.class);
//                intent.putExtra("service",service);
//                intent.putExtra("User_name",username);
                String service=getIntent().getStringExtra("service");
                String getuname=getIntent().getStringExtra("serviceProviderName");
                String username=getIntent().getStringExtra("User_name");
//                intent.putExtra("serviceProviderName",getuname);
                UserHelperClassForTrack obj=new UserHelperClassForTrack("0","0","0","0","1");
                ref= FirebaseDatabase.getInstance().getReference().child(service).child(username).child("ServiceProvider").child(getuname).child("Track");
                ref.setValue(obj);
//                startActivity(intent);
                ut.setVisibility(View.VISIBLE);
//                l.setVisibility(View.GONE);

                b1=findViewById(R.id.button);
                v1=findViewById(R.id.viewOrderplace);
                v2=findViewById(R.id.vieworderconf);
                v3=findViewById(R.id.viewordprocess);
                v4=findViewById(R.id.viewordready);
//                String service=getIntent().getStringExtra("service");
//                String getuname=getIntent().getStringExtra("serviceProviderName");
//                String username=getIntent().getStringExtra("User_name");
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
        });
    }
}