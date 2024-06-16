package com.example.household;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BookService extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] Plumber = {"One Tap Installation / Repair", "Balcony Pipe Blockage", "Drainage Pipe ( Overground Blockage)", "Drainage Pipe (underground Blockage)", "Kitchen sink Blockage"};
    String[] Electrician = {"Fuse Replacement", "Bulbs & Tube Ligh Replacement (5 nos)", "Fan Installation", "Ceiling Fan Regulator Replacement", "Internal Wiring (per 5m)"};
    String[] Carpenter = {"Drill, Nail & Hang ( upto 2 Drill )", "Bed Support & Legs Repair", "Door Stopper or Handle Installation", "Door Lock Installation", "Dining Table Assembly"};
    String[] HomePainting = {"Gate Painting", "Window Painting", "Wall Painting", "Appliances Painting", "1 BHK Home Painting"};
    String[] carcleaning = {"Full Car Cleaning", "Internal Car Cleaning", "External Car Cleaning", "Bike Cleaning", "Car + Bike Cleaning"};
    String[] Ac = {"Fridge Reapair", "Washing Machine Rapair", "Tv Repair", "Ac Repair", "Cooler Repair"};
    String[] HomeCleaning = {"1 Bathroom Deep Cleaning", "Basic Kitchen Cleaning", "Chimney Deep Clenaing only", "1 BHK Full Home Deep Cleaning", "Water Tank Cleaning Upto 1000 Ltrs"};
    String[] PestControl = {"Cockroack + Ant Control for 1 BHK", "Rat Control for 1 BHK", "Bedbugs Control for 1 BHK", "General Pest Control for 1 BHK", "General Pest Control for 2 BHK"};
    String DetailsDescription = "";
    String sr = "";
    String finalString = "";
    String superfinalString = "";
    int multiplier = 0;
    int price = 0;
    EditText qty;
    String Quantity;
    TextView tv1;
    String demo = "";
    Button updatePrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_book_service);
//        FirebaseDatabase rootNode;
//        DatabaseReference reference;
        EditText address = findViewById(R.id.address);
//        EditText pd = findViewById(R.id.pd);
        qty = findViewById(R.id.qty);
        Quantity = qty.getText().toString();
        tv1 = findViewById(R.id.tv1);
        Button btn = findViewById(R.id.button2);
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        updatePrice = findViewById(R.id.btnypdate);

        Intent intent = getIntent();
        String service = intent.getStringExtra("service");
        String user_username = intent.getStringExtra("username");
        String user_name = intent.getStringExtra("name");
        String user_email = intent.getStringExtra("email");
        String user_phoneNo = intent.getStringExtra("phoneNo");
        String user_passowrd = intent.getStringExtra("password");


        switch (service) {
            case "Plumber": {
                ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Plumber);
                ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(ad);
                sr = "0";
                break;
            }
            case "Electrician": {
                ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Electrician);
                ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(ad);
                sr = "1";
                break;
            }
            case "Carpenter": {
                ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Carpenter);
                ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(ad);
                sr = "2";
                break;
            }
            case "HomePainting": {
                ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, HomePainting);
                ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(ad);
                sr = "3";
                break;
            }
            case "carcleaning": {
                ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, carcleaning);
                ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(ad);
                sr = "4";
                break;
            }
            case "Ac": {
                ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Ac);
                ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(ad);
                sr = "5";
                break;
            }
            case "HomeCleaning": {
                ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, HomeCleaning);
                ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(ad);
                sr = "6";
                break;
            }
            case "PestControl": {
                ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, PestControl);
                ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(ad);
                sr = "7";
                break;
            }
        }


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase rootNode;
                DatabaseReference reference, reffanother;

                Intent intent = getIntent();
                String service = intent.getStringExtra("service");
                String user_username = intent.getStringExtra("username");
                String user_name = intent.getStringExtra("name");
                String user_email = intent.getStringExtra("email");
                String user_phoneNo = intent.getStringExtra("phoneNo");
                String user_passowrd = intent.getStringExtra("password");

                String DetailsAddress = address.getText().toString();

//                String DetailsDescription = pd.getText().toString();
                String DetailsPhoneNo = user_phoneNo;

                //Delete
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users").child(user_name).child("Booking");

                if (TextUtils.isEmpty(DetailsAddress)) {
                    address.setError("Please Enter the Address");
                    return;
                }
                if (TextUtils.isEmpty(Quantity)) {
                    address.setError("Please Enter Quantity");
                    return;
                }


                reffanother = rootNode.getReference();
                Intent intent3 = new Intent(getApplicationContext(), UserAfterBooking.class);


                //Delete


                switch (service) {
                    case "Plumber": {

                        UserHelperClass helperClass = new UserHelperClass(DetailsAddress, superfinalString, DetailsPhoneNo);
                        reference.child("Plumber").setValue(helperClass);
                        UserHelperClass2 helperClass2 = new UserHelperClass2(DetailsAddress, superfinalString, DetailsPhoneNo);
                        reffanother.child("Plumber").child(user_name).setValue(helperClass2);
                        Toast.makeText(BookService.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent4 = new Intent(getApplicationContext(), UserAfterBooking.class);
                        intent4.putExtra("Service","Plumber");
                        intent4.putExtra("Usernames",user_username);
                        startActivity(intent4);
                        break;
                    }
                    case "Electrician": {
                        UserHelperClass helperClass = new UserHelperClass(DetailsAddress, superfinalString, DetailsPhoneNo);
                        reference.child("Electrician").setValue(helperClass);
                        UserHelperClass2 helperClass2 = new UserHelperClass2(DetailsAddress, superfinalString, DetailsPhoneNo);
                        reffanother.child("Electrician").child(user_name).setValue(helperClass2);
                        Toast.makeText(BookService.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent4 = new Intent(getApplicationContext(), UserAfterBooking.class);
                        intent4.putExtra("Service","Plumber");
                        intent4.putExtra("Usernames",user_username);
                        startActivity(intent4);
                        break;
                    }
                    case "Carpenter": {
                        UserHelperClass helperClass = new UserHelperClass(DetailsAddress, superfinalString, DetailsPhoneNo);
                        reference.child("Carpenter").setValue(helperClass);
                        UserHelperClass2 helperClass2 = new UserHelperClass2(DetailsAddress, superfinalString, DetailsPhoneNo);
                        reffanother.child("Carpenter").child(user_name).setValue(helperClass2);
                        Toast.makeText(BookService.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent4 = new Intent(getApplicationContext(), UserAfterBooking.class);
                        intent4.putExtra("Service","Plumber");
                        intent4.putExtra("Usernames",user_username);
                        startActivity(intent4);
                        break;
                    }
                    case "HomePainting": {
                        UserHelperClass helperClass = new UserHelperClass(DetailsAddress, superfinalString, DetailsPhoneNo);
                        reference.child("HomePainting").setValue(helperClass);
                        UserHelperClass2 helperClass2 = new UserHelperClass2(DetailsAddress, superfinalString, DetailsPhoneNo);
                        reffanother.child("HomePainting").child(user_name).setValue(helperClass2);
                        Toast.makeText(BookService.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent4 = new Intent(getApplicationContext(), UserAfterBooking.class);
                        intent4.putExtra("Service","Plumber");
                        intent4.putExtra("Usernames",user_username);
                        startActivity(intent4);
                        break;
                    }
                    case "carcleaning": {
                        UserHelperClass helperClass = new UserHelperClass(DetailsAddress, superfinalString, DetailsPhoneNo);
                        reference.child("carcleaning").setValue(helperClass);
                        UserHelperClass2 helperClass2 = new UserHelperClass2(DetailsAddress, superfinalString, DetailsPhoneNo);
                        reffanother.child("carcleaning").child(user_name).setValue(helperClass2);
                        Toast.makeText(BookService.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent4 = new Intent(getApplicationContext(), UserAfterBooking.class);
                        intent4.putExtra("Service","Plumber");
                        intent4.putExtra("Usernames",user_username);
                        startActivity(intent4);
                        break;
                    }
                    case "Ac": {
                        UserHelperClass helperClass = new UserHelperClass(DetailsAddress, superfinalString, DetailsPhoneNo);
                        reference.child("Ac").setValue(helperClass);
                        UserHelperClass2 helperClass2 = new UserHelperClass2(DetailsAddress, superfinalString, DetailsPhoneNo);
                        reffanother.child("Ac").child(user_name).setValue(helperClass2);
                        Toast.makeText(BookService.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent4 = new Intent(getApplicationContext(), UserAfterBooking.class);
                        intent4.putExtra("Service","Plumber");
                        intent4.putExtra("Usernames",user_username);
                        startActivity(intent4);
                        break;
                    }
                    case "HomeCleaning": {
                        UserHelperClass helperClass = new UserHelperClass(DetailsAddress, superfinalString, DetailsPhoneNo);
                        reference.child("HomeCleaning").setValue(helperClass);
                        UserHelperClass2 helperClass2 = new UserHelperClass2(DetailsAddress, superfinalString, DetailsPhoneNo);
                        reffanother.child("HomeCleaning").child(user_name).setValue(helperClass2);
                        Toast.makeText(BookService.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent4 = new Intent(getApplicationContext(), UserAfterBooking.class);
                        intent4.putExtra("Service","Plumber");
                        intent4.putExtra("Usernames",user_username);
                        startActivity(intent4);
                        break;
                    }
                    case "PestControl": {
                        UserHelperClass helperClass = new UserHelperClass(DetailsAddress, superfinalString, DetailsPhoneNo);
                        reference.child("PestControl").setValue(helperClass);
                        UserHelperClass2 helperClass2 = new UserHelperClass2(DetailsAddress, superfinalString, DetailsPhoneNo);
                        reffanother.child("PestControl").child(user_name).setValue(helperClass2);
                        Toast.makeText(BookService.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent4 = new Intent(getApplicationContext(), UserAfterBooking.class);
                        intent4.putExtra("Service","Plumber");
                        intent4.putExtra("Usernames",user_username);
                        startActivity(intent4);
                        break;
                    }
                }
            }
        });

        updatePrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (finalString.equals("One Tap Installation / Repair")) {
                    multiplier = 200;
                    Quantity = qty.getText().toString();
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Balcony Pipe Blockage")) {
                    Quantity = qty.getText().toString();
                    multiplier = 350;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Drainage Pipe (underground Blockage)")) {
                    Quantity = qty.getText().toString();
                    multiplier = 450;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Drainage Pipe ( Overground Blockage)")) {
                    Quantity = qty.getText().toString();
                    multiplier = 300;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Kitchen sink Blockage")) {
                    Quantity = qty.getText().toString();
                    multiplier = 280;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Bulbs & Tube Ligh Replacement (5 nos)")) {
                    Quantity = qty.getText().toString();
                    multiplier = 100;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Fuse Replacement")) {
                    Quantity = qty.getText().toString();
                    multiplier = 100;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Ceiling Fan Regulator Replacement")) {
                    Quantity = qty.getText().toString();
                    multiplier = 100;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Fan Installation")) {
                    Quantity = qty.getText().toString();
                    multiplier = 200;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Internal Wiring (per 5m)")) {
                    Quantity = qty.getText().toString();
                    multiplier = 200;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Door Stopper or Handle Installation")) {
                    Quantity = qty.getText().toString();
                    multiplier = 300;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Bed Support & Legs Repair")) {
                    Quantity = qty.getText().toString();
                    multiplier = 400;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Drill, Nail & Hang ( upto 2 Drill )")) {
                    Quantity = qty.getText().toString();
                    multiplier = 160;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Door Lock Installation")) {
                    Quantity = qty.getText().toString();
                    multiplier = 500;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Dining Table Assembly")) {
                    Quantity = qty.getText().toString();
                    multiplier = 450;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Gate Painting")) {
                    Quantity = qty.getText().toString();
                    multiplier = 100;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Window Painting")) {
                    Quantity = qty.getText().toString();
                    multiplier = 100;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Wall Painting")) {
                    Quantity = qty.getText().toString();
                    multiplier = 600;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Appliances Painting")) {
                    Quantity = qty.getText().toString();
                    multiplier = 500;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("1 BHK Home Painting")) {
                    Quantity = qty.getText().toString();
                    multiplier = 7500;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Full Car Cleaning")) {
                    Quantity = qty.getText().toString();
                    multiplier = 1000;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Internal Car Cleaning")) {
                    Quantity = qty.getText().toString();
                    multiplier = 500;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("External Car Cleaning")) {
                    Quantity = qty.getText().toString();
                    multiplier = 600;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Bike Cleaning")) {
                    Quantity = qty.getText().toString();
                    multiplier = 200;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Car + Bike Cleaning")) {
                    Quantity = qty.getText().toString();
                    multiplier = 1500;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Cooler Repair")) {
                    Quantity = qty.getText().toString();
                    multiplier = 2000;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Ac Repair")) {
                    Quantity = qty.getText().toString();
                    multiplier = 4500;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Tv Repair")) {
                    Quantity = qty.getText().toString();
                    multiplier = 3600;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Washing Machine Rapair")) {
                    Quantity = qty.getText().toString();
                    multiplier = 6200;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Fridge Reapair")) {
                    Quantity = qty.getText().toString();
                    multiplier = 6500;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Water Tank Cleaning Upto 1000 Ltrs")) {
                    Quantity = qty.getText().toString();
                    multiplier = 800;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("1 BHK Full Home Deep Cleaning")) {
                    Quantity = qty.getText().toString();
                    multiplier = 3600;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Chimney Deep Clenaing only")) {
                    Quantity = qty.getText().toString();
                    multiplier = 500;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Basic Kitchen Cleaning")) {
                    Quantity = qty.getText().toString();
                    multiplier = 900;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("1 Bathroom Deep Cleaning")) {
                    Quantity = qty.getText().toString();
                    multiplier = 480;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("General Pest Control for 2 BHK")) {
                    Quantity = qty.getText().toString();
                    multiplier = 1200;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("General Pest Control for 1 BHK")) {
                    Quantity = qty.getText().toString();
                    multiplier = 1000;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Bedbugs Control for 1 BHK")) {
                    Quantity = qty.getText().toString();
                    multiplier = 1400;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Rat Control for 1 BHK")) {
                    Quantity = qty.getText().toString();
                    multiplier = 950;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                } else if (finalString.equals("Cockroack + Ant Control for 1 BHK")) {
                    Quantity = qty.getText().toString();
                    multiplier = 750;
                    price = parseInt(Quantity) * multiplier;
                    demo = ". Total Price :  rs " + price;
                    tv1.setText(demo);
                    superfinalString = finalString + demo;
                }


            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (sr.equals("0")) {
            finalString = Plumber[position];
        } else if (sr.equals("1")) {
            finalString = Electrician[position];
        } else if (sr.equals("2")) {
            finalString = Carpenter[position];
        } else if (sr.equals("3")) {
            finalString = HomePainting[position];
        } else if (sr.equals("4")) {
            finalString = carcleaning[position];
        } else if (sr.equals("5")) {
            finalString = Ac[position];
        } else if (sr.equals("6")) {
            finalString = HomeCleaning[position];
        } else if (sr.equals("7")) {
            finalString = PestControl[position];
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}