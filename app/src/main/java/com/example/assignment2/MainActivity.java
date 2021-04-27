package com.example.assignment2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment2.Modols.CV;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText editFullName;
    private EditText editEmailAddress;
    Spinner spinner;
    private EditText editDateOfBirth;
    private EditText editAge;
    RadioButton male,female;
    CheckBox reading,writing,printing;
    private EditText editPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editFullName = findViewById(R.id.editFullName);
        editEmailAddress = findViewById(R.id.editEmailAddress);
        spinner = findViewById(R.id.spinner);
        spinner();
        editDateOfBirth = findViewById(R.id.editDateOfBirth);
        editAge = findViewById(R.id.editAge);
        editPhone = findViewById(R.id.editPhone);
        female = findViewById(R.id.female);
        male = findViewById(R.id.male);
         reading= findViewById(R.id.reading);
         writing=findViewById(R.id.writing);
         printing=findViewById(R.id.printing);

        try {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            Gson gson = new Gson();
            String str = prefs.getString("cv", "");
            CV cv = gson.fromJson(str, CV.class);
            if (str.trim().length() != 0) {
                editFullName.setText(cv.getFullName());
                editEmailAddress.setText(cv.getEmail());

                editPhone.setText(cv.getPhone());
                editAge.setText(cv.getAge());
                editDateOfBirth.setText(cv.getDateOfBirth().toString());

                System.out.println(cv.getGender().toLowerCase());
                System.out.println("here");

                if (cv.getGender().toLowerCase().equals("male")) {
                    male.setSelected(true);
                }
                else if (cv.getGender().toLowerCase().equals("female")) {
                    female.setSelected(true);
                }
                for(int i=0;i<=7;i++) {
                    if (cv.getAddress().equals(spinner.getItemAtPosition(i).toString())) {
                        spinner.setSelection(i);
                        break;
                    }
                }
                if (cv.getHobbies().toLowerCase().equals("Reading")) {
                    reading.setChecked(true);
                }
                else if (cv.getHobbies().toLowerCase().equals("Writing")) {
                    writing.setChecked(true);
                }
                else if  (cv.getHobbies().toLowerCase().equals("Printing")) {
                    printing.setChecked(true);
                }
            }
        } catch (Exception e) {
            System.out.println();
        }


    }





    private void spinner() {

        ArrayList<String> gender = new ArrayList<>();
        gender.add("Ramallah");
        gender.add("Hebron");
        gender.add("Betlaheem");
        gender.add("jerusalem");
        gender.add("Nablus");
        gender.add("Tobas");
        gender.add("jenen");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, gender);
        spinner.setAdapter(adapter);

    }


    public void btn_OnClick(View view) {

        Intent intent = new Intent(this, MainActivity2.class);


        intent.putExtra("Full Name", editFullName.getText().toString());
        intent.putExtra("Email Address", editEmailAddress.getText().toString());
        intent.putExtra("Country",spinner.getSelectedItem().toString());
        intent.putExtra("Data OF Birth",editDateOfBirth.getText().toString());
        intent.putExtra("Age",editAge.getText().toString());
        if (male.isChecked()) {
            intent.putExtra("gender", male.getText().toString());

        } else if (female.isChecked()) {
            intent.putExtra("gender", female.getText().toString());
        }
        if (writing.isChecked()) {
            intent.putExtra("hobbies", writing.getText().toString());

        } else if (reading.isChecked()) {
            intent.putExtra("hobbies", reading.getText().toString());
        }
        else if (printing.isChecked()){
            intent.putExtra("hobbies", printing.getText().toString());
        }
        intent.putExtra("Phone Number",editPhone.getText().toString());
        startActivity(intent);




    }

}
