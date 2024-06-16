package com.example.household;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class fullDescriptionOfUserRequest extends AppCompatActivity {
    EditText t1, t2, t3;
    Button b,b1,b2,b3,b4;
    DatabaseReference ref;
    DatabaseReference reference;
    int temp = 0;
    String val = "0";
    LinearLayout m,t,nu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_description_of_user_request);
        t1 = (EditText) findViewById(R.id.address);
        t2 = (EditText) findViewById(R.id.problem);
        t3 = (EditText) findViewById(R.id.phone);
        b = (Button) findViewById(R.id.approve);
        m=(LinearLayout) findViewById(R.id.main);
        t=(LinearLayout) findViewById(R.id.track);
        nu=(LinearLayout) findViewById(R.id.nouser);
        String address = getIntent().getStringExtra("Address");
        String phone = getIntent().getStringExtra("Phone");
        String prob = getIntent().getStringExtra("Problem");
        t1.setText(address);
        t3.setText(phone);
        t2.setText(prob);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String user_name = intent.getStringExtra("Name");
//                String user_phoneNo = intent.getStringExtra("phoneNo");
                String user_username = intent.getStringExtra("UserName");
                String phoneNo = getIntent().getStringExtra("Service_Phone");
                String sname = getIntent().getStringExtra("name");
                String uname = getIntent().getStringExtra("User");
                String EXP = getIntent().getStringExtra("EXP");
                temp = 1;
//                    b.setVisibility(View.INVISIBLE);
//                Intent intent22 = new Intent(getApplicationContext(), ServiceProvider_track_module.class);
//                intent22.putExtra("service", EXP);
//                intent22.putExtra("user", uname);
//                intent22.putExtra("serviceProvider", user_name);
//                String test = "serviceProvider";
//        ref= FirebaseDatabase.getInstance().getReference().child("Plumber").child("pratik").child("ServiceProvider");
//        userhelper obj=new userhelper(test);
//        ref.setValue(obj);


                //original
                ref = FirebaseDatabase.getInstance().getReference().child(EXP).child(uname).child("ServiceProvider").child(user_name);
////                String rating = "5.0", phone = "1212121212";
                userhelper2 obj2 = new userhelper2(user_username, phoneNo);
                ref.setValue(obj2);
                reference = FirebaseDatabase.getInstance().getReference().child(EXP).child(uname).child("ServiceProvider").child(user_name).child("Track");
                UserHelperClassForTrack obj = new UserHelperClassForTrack("0", "0", "0", "0", "0");
                reference.setValue(obj);

                nu.setVisibility(View.VISIBLE);
                m.setVisibility(View.GONE);
                ref = FirebaseDatabase.getInstance().getReference().child(EXP).child(uname).child("ServiceProvider").child(user_name).child("Track");
                ref.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                        val = String.valueOf(snapshot.getValue());
//        Toast.makeText(fullDescriptionOfUserRequest.this, "Val="+val, Toast.LENGTH_SHORT).show();
                        if(val.equals("1")){
                            t.setVisibility(View.VISIBLE);
                            b1 = findViewById(R.id.btn1);
                            b2 = findViewById(R.id.btn2);
                            b3 = findViewById(R.id.btn3);
                            b4 = findViewById(R.id.button2);
//            String service = getIntent().getStringExtra("EXP");
//            String username = getIntent().getStringExtra("username");
//            String getuname = getIntent().getStringExtra("ServiceProvider");
                            ref = FirebaseDatabase.getInstance().getReference().child(EXP).child(uname).child("ServiceProvider").child(user_name).child("Track");
                            ref.addChildEventListener(new ChildEventListener() {
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
                                    Toast.makeText(getApplicationContext(), "Step 1 Update Successful", Toast.LENGTH_SHORT).show();
                                    ref = FirebaseDatabase.getInstance().getReference().child(EXP).child(uname).child("ServiceProvider").child(user_name).child("Track");
                                    UserHelperClassForTrack helperClass = new UserHelperClassForTrack("1", "0", "0", "0", val);
                                    ref.setValue(helperClass);

                                }
                            });

                            b2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Toast.makeText(getApplicationContext(), "Step 2 Update Successful", Toast.LENGTH_SHORT).show();
                                    ref = FirebaseDatabase.getInstance().getReference().child(EXP).child(uname).child("ServiceProvider").child(user_name).child("Track");
                                    UserHelperClassForTrack helperClass = new UserHelperClassForTrack("1", "1", "0", "0", val);
                                    ref.setValue(helperClass);
                                }
                            });

                            b3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Toast.makeText(getApplicationContext(), "Step 3 Update Successful", Toast.LENGTH_SHORT).show();
                                    ref = FirebaseDatabase.getInstance().getReference().child(EXP).child(uname).child("ServiceProvider").child(user_name).child("Track");
                                    UserHelperClassForTrack helperClass = new UserHelperClassForTrack("1", "1", "1", "0", val);
                                    ref.setValue(helperClass);
                                }
                            });
                            b4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Toast.makeText(getApplicationContext(), "Step 4 Update Successful", Toast.LENGTH_SHORT).show();
                                    ref = FirebaseDatabase.getInstance().getReference().child(EXP).child(uname).child("ServiceProvider").child(user_name).child("Track");
                                    UserHelperClassForTrack helperClass = new UserHelperClassForTrack("1", "1", "1", "1", val);
                                    ref.setValue(helperClass);
                                }
                            });


                        }
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



//b1.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        t.setVisibility(View.VISIBLE);
//    }
//});
                ////originalchetan

                //main//
//                    Intent intent33 = new Intent(getApplicationContext(), serviceProviderWait.class);
//                     intent33.putExtra("service", EXP);
//                     intent33.putExtra("user", uname);
//                     intent33.putExtra("serviceProvider", user_name);
//                    startActivity(intent33);
                //main////




//                ref = FirebaseDatabase.getInstance().getReference().child(EXP).child(uname).child("ServiceProvider").child(user_name).child("Track").child("val");
//                ref.addChildEventListener(new ChildEventListener() {
//                    @Override
//                    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                        val = String.valueOf(snapshot.getValue());
//
//
//                        if (val.equals("1")) {
//
//                            Toast.makeText(fullDescriptionOfUserRequest.this, val, Toast.LENGTH_SHORT).show();
//                        } else {
//                            Toast.makeText(fullDescriptionOfUserRequest.this, "No users", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//                    }
//
//                    @Override
//                    public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//                    }
//
//                    @Override
//                    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//                Toast.makeText(fullDescriptionOfUserRequest.this, "Username" + user_username + "\nService Provider" + uname, Toast.LENGTH_SHORT).show();
            }
        });


    }
}