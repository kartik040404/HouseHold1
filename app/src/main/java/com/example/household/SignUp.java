package com.example.household;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class SignUp extends AppCompatActivity {
    int UserNameDuplicasy = -2;
    TextInputLayout regName, regUsername, regEmail, regPhoneNo, regPassword;
    Button regBtn, regToLoginBtn, rcheckotpbtn, rsendotpbtn;
    //
    FirebaseDatabase rootNode;
    DatabaseReference reference, reff, reffDashboard;
    String Dashboard = "3";
    private FirebaseAuth mAuth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    ProgressBar p1;
    String phno = "", finalphno = "";
    String verificationId1 = null;
    TextInputEditText rotp;
    EditText t1;
    Boolean CheckTheOtp = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        //Hooks
        TextInputEditText regName;
        TextInputEditText regUsername;
        TextInputEditText regEmail;
        TextInputEditText regPhoneNo;
        TextInputEditText regPassword;

        p1 = findViewById(R.id.progressBar);

        regName = (TextInputEditText) findViewById(R.id.rname);
        regUsername = (TextInputEditText) findViewById(R.id.rusername);
        regEmail = (TextInputEditText) findViewById(R.id.remail);
        regPhoneNo = (TextInputEditText) findViewById(R.id.rphone);
        regPassword = (TextInputEditText) findViewById(R.id.rpassword);
        t1 = regPhoneNo;
//        rotp = (TextInputEditText) findViewById(R.id.rotp);
        regBtn = findViewById(R.id.rbtn);
//        rsendotpbtn = findViewById(R.id.rsendotpbtn);
//        rcheckotpbtn = findViewById(R.id.rcheckotpbtn);
        regToLoginBtn = findViewById(R.id.rloginbtn);
        RadioButton ruser = findViewById(R.id.radUser);
        RadioButton rsp = findViewById(R.id.radServiceProvider);

//        phno=regPhoneNo.getText().toString().trim();
//        rsendotpbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (regPhoneNo.getText().toString().isEmpty()) {
//                    Toast.makeText(SignUp.this, "Please Enter your Phone Number", Toast.LENGTH_SHORT).show();
//                } else if (regPhoneNo.getText().toString().length() != 10) {
//                    Toast.makeText(SignUp.this, "Please Enter 10 Digit Number", Toast.LENGTH_SHORT).show();
//                } else {
//                    otpSend();
//                    rotp.setVisibility(View.VISIBLE);
//                    rcheckotpbtn.setVisibility(View.VISIBLE);
//                }
//            }
//
//
//        });
//
//        rcheckotpbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (rotp.getText().toString().isEmpty()) {
//                    Toast.makeText(SignUp.this, "Please Enter OTP", Toast.LENGTH_SHORT).show();
//                } else {
//                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId1, rotp.getText().toString().trim());
//                    FirebaseAuth
//                            .getInstance()
//                            .signInWithCredential(credential)
//                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                                @Override
//                                public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
//                                    if (task.isSuccessful()) {
////                                        p1.setVisibility(View.VISIBLE);
//                                      Toast.makeText(getBaseContext(), "Verified Succssfully", Toast.LENGTH_SHORT).show();
//                                      rcheckotpbtn.setVisibility(View.GONE);
//                                      rotp.setVisibility(View.GONE);
//                                        CheckTheOtp = true;
//
//                                    } else {
//                                        p1.setVisibility(View.GONE);
//                                        Toast.makeText(getBaseContext(), "Incorrect OTP", Toast.LENGTH_SHORT).show();
//                                        CheckTheOtp = false;
//                                    }
//                                }
//                            });
//                }
//            }
//        });


//        <Delete2.0>
        ruser.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Dashboard = "0";
//                Toast.makeText(SignUp.this, "Value of Dashboard is " + Dashboard, Toast.LENGTH_SHORT).show();
            }
        });

        rsp.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Dashboard = "1";
//                Toast.makeText(SignUp.this, "Value of Dashboard is " + Dashboard, Toast.LENGTH_SHORT).show();
            }
        });


        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");

                //get all the values
                String name = regName.getText().toString();
                String username = regUsername.getText().toString();
                String email = regEmail.getText().toString();
                String phoneNo = regPhoneNo.getText().toString();
                String password = regPassword.getText().toString();

                String NoWhiteSpace = "\\A\\w{4,20}\\z";
                String emailPattern = "[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (name.isEmpty()) {
                    regName.setError("Field cannot be empty");

                } else {
                    regName.setError(null);
                    if (username.isEmpty()) {
                        regUsername.setError("Field cannot be empty");
                    } else if (username.length() >= 15) {
                        regUsername.setError("Username too long");

                    } else if (!username.matches(NoWhiteSpace)) {
                        regUsername.setError("White Spaces are not allowed");
                    } else {
                        regUsername.setError(null);
                        if (email.isEmpty()) {
                            regEmail.setError("Field cannot be empty");
                        } else if (!email.matches(emailPattern)) {
                            regEmail.setError("Invalid email address");
                        } else {
                            regEmail.setError(null);
                            if (phoneNo.isEmpty()) {
                                regPhoneNo.setError("Field cannot be empty");
                            } else {

                                regPhoneNo.setError(null);
                                if (password.isEmpty()) {
                                    regPassword.setError("Field cannot be empty");
                                } else {

                                    regPassword.setError(null);
//                                    Toast.makeText(SignUp.this, "Success", Toast.LENGTH_SHORT).show();
                                    reference = FirebaseDatabase.getInstance().getReference().child("users").child(username);
                                    reff = FirebaseDatabase.getInstance().getReference().child("users");

                                    reference.addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            if (snapshot.exists()) {
                                                String unicisername = snapshot.child("username").getValue().toString();
                                                if (unicisername.equals(username)) {
//                                                    Toast.makeText(SignUp.this, "Username Already Exists", Toast.LENGTH_SHORT).show();
                                                    regUsername.setError("Username Already Exists");
                                                }
                                            } else {

                                                if (Dashboard.equals("3")) {
                                                    Toast.makeText(SignUp.this, "Select your role", Toast.LENGTH_SHORT).show();
                                                } else {

                                                    if (CheckTheOtp) {
                                                        UserHelperClass helperClass = new UserHelperClass(name, username, email, phoneNo, password);
                                                        reff.child(username).setValue(helperClass);
                                                        Toast.makeText(SignUp.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                                                        Intent intent = new Intent(SignUp.this, Login.class);

                                                        reffDashboard = rootNode.getReference("users");
                                                        UserHelperClass dash = new UserHelperClass(Dashboard);
                                                        reffDashboard.child(username).child("key").setValue(dash);

                                                        startActivity(intent);
                                                    } else {
                                                        Toast.makeText(SignUp.this, "Please Validate Your Mobile Number", Toast.LENGTH_SHORT).show();
                                                    }


                                                }


//                                                UserHelperClass helperClass = new UserHelperClass(name, username, email, phoneNo, password);
//                                                reff.child(username).setValue(helperClass);
//                                                Toast.makeText(SignUp.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
//                                                Intent intent = new Intent(SignUp.this, Login.class);
//
//                                                reffDashboard = rootNode.getReference("users");
//                                                UserHelperClass dash = new UserHelperClass(Dashboard);
//                                                reffDashboard.child(username).child("key").setValue(dash);
//
//                                                startActivity(intent);
                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });

//                                    if (UserNameDuplicasy > 0) {
//                                        UserHelperClass helperClass = new UserHelperClass(name, username, email, phoneNo, password);
//                                        reference.child(username).setValue(helperClass);
//                                    }
//                                    UserHelperClass helperClass = new UserHelperClass(name, username, email, phoneNo, password);
//                                    reference.child(username).setValue(helperClass);


                                }
                            }
                        }
                    }
                }

            }
        });

//        </Delete2.0>
        regToLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });
    }

    private void otpSend() {
        p1.setVisibility(View.VISIBLE);


        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) {

            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                p1.setVisibility(View.GONE);

                Toast.makeText(getBaseContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                p1.setVisibility(View.GONE);
                Toast.makeText(getBaseContext(), "OTP sent successfully.", Toast.LENGTH_SHORT).show();
                verificationId1 = verificationId;
            }
        };
        finalphno = t1.getText().toString();
        phno = "+91" + finalphno;
//        Toast.makeText(this, phno, Toast.LENGTH_SHORT).show();
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(phno)
                        .setTimeout(60L, TimeUnit.SECONDS)
                        .setActivity(this)
                        .setCallbacks(mCallbacks)
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }


}