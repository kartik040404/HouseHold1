package com.example.household;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class UserAfterBooking extends AppCompatActivity {
    ListView mylistview;
    ArrayList<String> myArrayList=new ArrayList<>();
    DatabaseReference mRef;
    String ServiceName="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_after_booking);

        Intent intent = getIntent();
        String user_username = intent.getStringExtra("username");
        String user_name = intent.getStringExtra("name");
        String user_email = intent.getStringExtra("email");
        String user_phoneNo = intent.getStringExtra("phoneNo");
        String user_passowrd = intent.getStringExtra("password");
        String service=getIntent().getStringExtra("Service");
        ServiceName = service;
        String username=getIntent().getStringExtra("Usernames");
        ArrayAdapter<String> myArrayAdapter=new ArrayAdapter<String>(UserAfterBooking.this, android.R.layout.simple_list_item_1,myArrayList);
        mylistview=(ListView) findViewById(R.id.listview1);
        mylistview.setAdapter(myArrayAdapter);
        mRef= FirebaseDatabase.getInstance().getReference().child(ServiceName).child(username).child("ServiceProvider");
        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                String value=snapshot.getValue(String.class);
                String value=snapshot.getKey();
                myArrayList.add(value);
                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//                String value=snapshot.getValue(String.class);
                String value=snapshot.getKey();
                myArrayList.remove(value);
                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });







        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String getuname=myArrayList.get(position);
                mRef= FirebaseDatabase.getInstance().getReference().child(ServiceName).child(username).child("ServiceProvider").child(getuname);
                mRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                                  String key=snapshot.getKey();
//                                    if(getuname.equals(key)){
                        String username11=snapshot.child("user_name").getValue().toString();
                        String phone_no=snapshot.child("phone_No").getValue().toString();
//                        String prob=snapshot.child("detailsProblem").getValue().toString();

                        Intent intent12=new Intent(UserAfterBooking.this,fullDescriptionOfServiceProviderResponce.class);
                        intent12.putExtra("UserName",username11);
                        intent12.putExtra("Phone_no",phone_no);
                        intent12.putExtra("service",ServiceName);
                        intent12.putExtra("User_name",username);
                        intent12.putExtra("serviceProviderName",getuname);
                        startActivity(intent12);
//                        intent11.putExtra("Problem",prob);
//                        intent11.putExtra("User",getuname);
//                        startActivity(intent11);
//                                      Toast.makeText(MainServiceProvider.this, "hello", Toast.LENGTH_SHORT).show();
//                        Toast.makeText(UserAfterBooking.this, "Values:\n"+address+"\n"+phone+"\n"+prob, Toast.LENGTH_SHORT).show();
                    }
//                              }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}