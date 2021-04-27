package com.example.assignment2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment2.Modols.CV;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    Spinner spinneredu;
    private EditText editwork;
    Button finish;
    CheckBox remember_me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        spinneredu = findViewById(R.id.spinneredu);
        spinneredu();
        editwork = findViewById(R.id.editwork);

        remember_me = findViewById(R.id.remember_me);
        finish = findViewById(R.id.finish);


        Intent intent = getIntent();


        String fullName = intent.getStringExtra("Full Name");

        String email = intent.getStringExtra("Email Address");

        String country = intent.getStringExtra("Country");


        String DateofBirth = intent.getStringExtra("Data OF Birth");

        String age = intent.getStringExtra("Age");

        String male = intent.getStringExtra("Male");
        String Female = intent.getStringExtra("Female");

        String reading = intent.getStringExtra("Reading");
        String writing = intent.getStringExtra("Writing");
        String printing = intent.getStringExtra("Printing");

        String phone = intent.getStringExtra("Phone Number");


        String data= spinneredu.getSelectedItem().toString();
        intent.putExtra("Education Level",data);

        String edu_level= intent.getStringExtra("Education Level");
        try {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            Gson gson = new Gson();
            String str = prefs.getString("cv", "");
            CV cv = gson.fromJson(str, CV.class);
            if (str.trim().length() != 0) {
                editwork.setText(cv.getExperienceWork());
                for (int i = 0; i <=5; i++) {
                    if (cv.getAddress().equals(spinneredu.getItemAtPosition(i).toString())) {
                        spinneredu.setSelection(i);
                        break;
                    }
                }
            }

            } catch(Exception e){
                System.out.println();
            }
        }


        private void spinneredu () {

            ArrayList<String> educationLevel = new ArrayList<>();
            educationLevel.add("Diploma");
            educationLevel.add("Bachelor's");
            educationLevel.add("Master's");
            educationLevel.add("Doctoral");
            educationLevel.add("professor");


            ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_item, educationLevel);
            spinneredu.setAdapter(adapter1);

        }


    public void saveOnclick(View view) {


        Intent intent = getIntent();


        String fullName = intent.getStringExtra("Full Name");

        String email = intent.getStringExtra("Email Address");

        String address = intent.getStringExtra("Country");


        String dateOfBirth = intent.getStringExtra("Data OF Birth");

        String age = intent.getStringExtra("Age");
        String phone = intent.getStringExtra("Phone Number");
        String gender= intent.getStringExtra("gender");


         String hobbies = intent.getStringExtra("hobbies");


        CV userInfo = new CV ( fullName,  email,  address,  dateOfBirth,age,  phone,  gender,  hobbies,

                spinneredu.getSelectedItem().toString(), editwork.getText().toString());

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity2.this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String cvString = gson.toJson(userInfo);

        editor.putString("cv", cvString);


        editor.commit();
        Toast.makeText(MainActivity2.this, "Data Saved:\n" + cvString, Toast.LENGTH_SHORT).show();


        System.out.println(cvString);
        Log.d("userInfo", cvString);

    }
}
