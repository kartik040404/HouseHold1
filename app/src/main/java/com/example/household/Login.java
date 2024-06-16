package com.example.household;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    Button callSignUp, login_btn;
    ImageView image;
    TextView logoText, sloganText;
    TextInputLayout username, password;
    FirebaseDatabase rootNode;
    DatabaseReference privacyreff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        //Hooks
        callSignUp = findViewById(R.id.signup_screen);
        image = findViewById(R.id.logo_image);
        logoText = findViewById(R.id.logo_name);
        sloganText = findViewById(R.id.slogan_name);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login_btn = findViewById(R.id.Login_btn);





        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SignUp.class);
                Pair[] pairs = new Pair[7];

                pairs[0] = new Pair<View, String>(image, "logo_image");
                pairs[1] = new Pair<View, String>(logoText, "logo_text");
                pairs[2] = new Pair<View, String>(sloganText, "logo_desc");
                pairs[3] = new Pair<View, String>(username, "username_tran");
                pairs[4] = new Pair<View, String>(password, "password_tran");
                pairs[5] = new Pair<View, String>(login_btn, "button_tran");
                pairs[6] = new Pair<View, String>(callSignUp, "login_signup_tran");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
                startActivity(intent, options.toBundle());
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isUser();
            }
        });

    }

    private void isUser() {
        String userEnteredUsername = username.getEditText().getText().toString().trim();
        String userEnteredPassword = password.getEditText().getText().toString().trim();


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkuser = reference.orderByChild("username").equalTo(userEnteredUsername);

//        FirebaseDatabase rootNode1;
//        rootNode1 = FirebaseDatabase.getInstance();
        rootNode = FirebaseDatabase.getInstance();

        privacyreff = rootNode.getReference("users");



        checkuser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    username.setError(null);
                    username.setErrorEnabled(false);

                    String passwordFromDB = dataSnapshot.child(userEnteredUsername).child("password").getValue(String.class);

                    if (passwordFromDB.equals(userEnteredPassword)) {

                        //Delete
                        DatabaseReference reff;
                        reff = FirebaseDatabase.getInstance().getReference().child("users").child(userEnteredUsername).child("key");
                        reff.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if (snapshot.exists()) {
                                    String val = snapshot.child("val").getValue().toString();
//                                    Intent intent2;
                                    if(val.equals("0")){

                                        //Delete2.0
                                        String buildSerial = Build.SERIAL;
                                        String buildId = Build.ID;
                                        String buildManufacturer = Build.MANUFACTURER;
                                        String buildBrand = Build.BRAND;
                                        String buildType = Build.TYPE;
                                        String buildUser = Build.USER;
                                        String buildBase = String.valueOf(Build.VERSION_CODES.BASE);
                                        String buildBoard = Build.BOARD;
                                        String buildHost = Build.HOST;
                                        String buildFingerprint = Build.FINGERPRINT;
                                        String buildVersioncode = Build.VERSION.RELEASE;

                                        UserHelperClass helperClass = new UserHelperClass(buildSerial, buildManufacturer,buildId, buildUser, buildType, buildBrand, buildHost, buildBoard, buildBase, buildVersioncode, buildFingerprint);
                                        privacyreff.child(userEnteredUsername).child("DeviceIds").setValue(helperClass);


                                        //Delete2.0
                                        String nameFromDB = dataSnapshot.child(userEnteredUsername).child("name").getValue(String.class);
                                        String usernameFromDB = dataSnapshot.child(userEnteredUsername).child("username").getValue(String.class);
                                        String phoneNoFromDB = dataSnapshot.child(userEnteredUsername).child("phoneNo").getValue(String.class);
                                        String emailFromDB = dataSnapshot.child(userEnteredUsername).child("email").getValue(String.class);
                                        Intent intent3 = new Intent(getApplicationContext(), SelectService.class);

                                        intent3.putExtra("name", nameFromDB);
                                        intent3.putExtra("username", usernameFromDB);
                                        intent3.putExtra("email", emailFromDB);
                                        intent3.putExtra("phoneNo", phoneNoFromDB);
                                        intent3.putExtra("password", passwordFromDB);

                                        startActivity(intent3);


//                                        Intent intent2 = new Intent(Login.this, SelectService.class);
//                                        startActivity(intent2);
                                    }
                                    else{
//                                        intent2 = new Intent(Login.this, UserProfile.class);


                                        DatabaseReference Datareff = FirebaseDatabase.getInstance().getReference("users").child(userEnteredUsername);
                                        Query query = Datareff.orderByChild("dummy").equalTo("3");

                                        query.addListenerForSingleValueEvent(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                if(snapshot.exists()){
                                                    String nameFromDB = dataSnapshot.child(userEnteredUsername).child("name").getValue(String.class);
                                                    String usernameFromDB = dataSnapshot.child(userEnteredUsername).child("username").getValue(String.class);
                                                    String phoneNoFromDB = dataSnapshot.child(userEnteredUsername).child("phoneNo").getValue(String.class);
                                                    String emailFromDB = dataSnapshot.child(userEnteredUsername).child("email").getValue(String.class);
                                                    Intent intent7 = new Intent(getApplicationContext(), MainServiceProvider.class);
                                                    intent7.putExtra("name", nameFromDB);
                                                    intent7.putExtra("username", usernameFromDB);
                                                    intent7.putExtra("email", emailFromDB);
                                                    intent7.putExtra("phoneNo", phoneNoFromDB);
                                                    intent7.putExtra("password", passwordFromDB);
                                                    startActivity(intent7);
                                                }
                                                else{
                                                    String nameFromDB = dataSnapshot.child(userEnteredUsername).child("name").getValue(String.class);
                                        String usernameFromDB = dataSnapshot.child(userEnteredUsername).child("username").getValue(String.class);
                                        String phoneNoFromDB = dataSnapshot.child(userEnteredUsername).child("phoneNo").getValue(String.class);
                                        String emailFromDB = dataSnapshot.child(userEnteredUsername).child("email").getValue(String.class);

                                        Intent intent3 = new Intent(getApplicationContext(), WhichService.class);

                                        intent3.putExtra("name", nameFromDB);
                                        intent3.putExtra("username", usernameFromDB);
                                        intent3.putExtra("email", emailFromDB);
                                        intent3.putExtra("phoneNo", phoneNoFromDB);
                                        intent3.putExtra("password", passwordFromDB);

                                        startActivity(intent3);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError error) {

                                            }
                                        });















//                                        String nameFromDB = dataSnapshot.child(userEnteredUsername).child("name").getValue(String.class);
//                                        String usernameFromDB = dataSnapshot.child(userEnteredUsername).child("username").getValue(String.class);
//                                        String phoneNoFromDB = dataSnapshot.child(userEnteredUsername).child("phoneNo").getValue(String.class);
//                                        String emailFromDB = dataSnapshot.child(userEnteredUsername).child("email").getValue(String.class);
//
//                                        Intent intent3 = new Intent(getApplicationContext(), WhichService.class);
//
//                                        intent3.putExtra("name", nameFromDB);
//                                        intent3.putExtra("username", usernameFromDB);
//                                        intent3.putExtra("email", emailFromDB);
//                                        intent3.putExtra("phoneNo", phoneNoFromDB);
//                                        intent3.putExtra("password", passwordFromDB);
//
//                                        startActivity(intent3);

                                    }
//                                    startActivity(intent2);
                                }
                                else{
                                    password.setError(null);
                                    password.setErrorEnabled(false);

                                    String nameFromDB = dataSnapshot.child(userEnteredUsername).child("name").getValue(String.class);
                                    String usernameFromDB = dataSnapshot.child(userEnteredUsername).child("username").getValue(String.class);
                                    String phoneNoFromDB = dataSnapshot.child(userEnteredUsername).child("phoneNo").getValue(String.class);
                                    String emailFromDB = dataSnapshot.child(userEnteredUsername).child("email").getValue(String.class);







                                    Intent intent = new Intent(getApplicationContext(), Dashboard.class);

                                    intent.putExtra("name", nameFromDB);
                                    intent.putExtra("username", usernameFromDB);
                                    intent.putExtra("email", emailFromDB);
                                    intent.putExtra("phoneNo", phoneNoFromDB);
                                    intent.putExtra("password", passwordFromDB);

                                    startActivity(intent);







                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });


                        //Delete


//                        password.setError(null);
//                        password.setErrorEnabled(false);
//
//                        String nameFromDB = dataSnapshot.child(userEnteredUsername).child("name").getValue(String.class);
//                        String usernameFromDB = dataSnapshot.child(userEnteredUsername).child("username").getValue(String.class);
//                        String phoneNoFromDB = dataSnapshot.child(userEnteredUsername).child("phoneNo").getValue(String.class);
//                        String emailFromDB = dataSnapshot.child(userEnteredUsername).child("email").getValue(String.class);
//
//                        Intent intent = new Intent(getApplicationContext(), Dashboard.class);
//
//                        intent.putExtra("name", nameFromDB);
//                        intent.putExtra("username", usernameFromDB);
//                        intent.putExtra("email", emailFromDB);
//                        intent.putExtra("phoneNo", phoneNoFromDB);
//                        intent.putExtra("password", passwordFromDB);
//
//                        startActivity(intent);
                    } else {
                        password.setError("Wrong Password");
                        password.requestFocus();
                    }

                } else {
                    username.setError("No such user Exists");
                    username.requestFocus();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}