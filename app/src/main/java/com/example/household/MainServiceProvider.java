package com.example.household;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class MainServiceProvider extends AppCompatActivity {
    ListView mylistview;
    ArrayList<String> myArrayList = new ArrayList<>();
    DatabaseReference mRef, mReff7;
    String exp = "0";
String temp="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_service_provider);
        Intent intent = getIntent();
        String user_username = intent.getStringExtra("username");
        String user_name = intent.getStringExtra("name");
        String user_email = intent.getStringExtra("email");
        String user_phoneNo = intent.getStringExtra("phoneNo");
        String user_passowrd = intent.getStringExtra("password");


        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>(MainServiceProvider.this, android.R.layout.simple_list_item_1, myArrayList);
        mylistview = (ListView) findViewById(R.id.listview);
        mylistview.setAdapter(myArrayAdapter);


        //<Delete3.O>
        mReff7 = FirebaseDatabase.getInstance().getReference().child("users").child(user_username).child("exp").child("spexp");
        mReff7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                exp = String.valueOf(snapshot.getValue());
//                exp = String.valueOf(snapshot.child("spexp").getValue());
                if (exp.equals("0")) {
                    mRef = FirebaseDatabase.getInstance().getReference().child("Plumber");
                }

                else if (exp.equals("1")) {
                    mRef = FirebaseDatabase.getInstance().getReference().child("Electrician");
                }

                else if (exp.equals("2")) {
                    mRef = FirebaseDatabase.getInstance().getReference().child("Carpenter");
                }

                else if (exp.equals("3")) {
                    mRef = FirebaseDatabase.getInstance().getReference().child("HomePainting");
                }

                else if (exp.equals("4")) {
                    mRef = FirebaseDatabase.getInstance().getReference().child("carcleaning");
                }

                else if (exp.equals("5")) {
                    mRef = FirebaseDatabase.getInstance().getReference().child("Ac");
                }

                else if (exp.equals("6")) {
                    mRef = FirebaseDatabase.getInstance().getReference().child("HomeCleaning");
                }

                else if (exp.equals("7")) {
                    mRef = FirebaseDatabase.getInstance().getReference().child("PestControl");
                }

                else {
                    Toast.makeText(MainServiceProvider.this, "Error", Toast.LENGTH_SHORT).show();
                }



                mRef.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                String value=snapshot.getValue(String.class);
                        String value = snapshot.getKey();
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
                        String value = snapshot.getKey();
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
                        String getuname = myArrayList.get(position);



                        if (exp.equals("0")) {
                            temp="Plumber";
                            mRef = FirebaseDatabase.getInstance().getReference().child("Plumber").child(getuname);

                        }

                        else if (exp.equals("1")) {
                            temp="Electrician";
                            mRef = FirebaseDatabase.getInstance().getReference().child("Electrician").child(getuname);
                        }

                        else if (exp.equals("2")) {
                            temp="Carpenter";
                            mRef = FirebaseDatabase.getInstance().getReference().child("Carpenter").child(getuname);
                        }

                        else if (exp.equals("3")) {
                            temp="HomePainting";
                            mRef = FirebaseDatabase.getInstance().getReference().child("HomePainting").child(getuname);
                        }

                        else if (exp.equals("4")) {
                            temp="carcleaning";
                            mRef = FirebaseDatabase.getInstance().getReference().child("carcleaning").child(getuname);
                        }

                        else if (exp.equals("5")) {
                            temp="Ac";
                            mRef = FirebaseDatabase.getInstance().getReference().child("Ac").child(getuname);
                        }

                        else if (exp.equals("6")) {
                            temp="HomeCleaning";
                            mRef = FirebaseDatabase.getInstance().getReference().child("HomeCleaning").child(getuname);
                        }

                        else if (exp.equals("7")) {
                            temp="PestControl";
                            mRef = FirebaseDatabase.getInstance().getReference().child("PestControl").child(getuname);
                        }


//                mRef = FirebaseDatabase.getInstance().getReference().child("Electrician").child(getuname);
                        mRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                                  String key=snapshot.getKey();
//                                    if(getuname.equals(key)){
                                String address = Objects.requireNonNull(snapshot.child("detailsAddress").getValue()).toString();
                                String phone = Objects.requireNonNull(snapshot.child("detailsPhone").getValue()).toString();
                                String prob = Objects.requireNonNull(snapshot.child("detailsProblem").getValue()).toString();

                                Intent intent11 = new Intent(MainServiceProvider.this, fullDescriptionOfUserRequest.class);
                                intent11.putExtra("Address", address);
                                intent11.putExtra("Phone", phone);
                                intent11.putExtra("Problem", prob);
                                intent11.putExtra("User", getuname);
                                intent11.putExtra("UserName", user_username);
                                intent11.putExtra("Name", user_name);
                                intent11.putExtra("Service_Phone",user_phoneNo);
intent11.putExtra("EXP",temp);
                                startActivity(intent11);
//                                      Toast.makeText(MainServiceProvider.this, "hello", Toast.LENGTH_SHORT).show();
                                Toast.makeText(MainServiceProvider.this, "Values:\n" + address + "\n" + phone + "\n" + prob, Toast.LENGTH_SHORT).show();
                            }
//                              }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //</Delete3.O>


        //<Orinal code>

//        mRef = FirebaseDatabase.getInstance().getReference().child("Electrician");

        //</Orinal code>




    }
}