package com.tatvaSoftAssignment.assignment_6;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etEmail, etPhone, etAddress, etDate;
    private CheckBox checkReading, checkChess, checkDrawing;
    private Button btnSignIn;
    private Spinner spinnerCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_id();
        setDateOfBirth();
        setCountry();

        btnSignIn.setOnClickListener(v -> {
            if (isValid()) {
                Toast.makeText(this, getString(R.string.Sign_In_SuccessFully), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void init_id() {
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etAddress = findViewById(R.id.etAddress);
        etDate = findViewById(R.id.etDate);
        checkReading = findViewById(R.id.checkReading);
        checkChess = findViewById(R.id.checkChess);
        checkDrawing = findViewById(R.id.checkDrawing);
        btnSignIn = findViewById(R.id.btnSignIn);
        spinnerCountry = findViewById(R.id.spinnerCountry);
    }

    private void setDateOfBirth() {
        etDate.setOnClickListener(v -> {
            int date, set_month, set_year;
            GregorianCalendar gc = new GregorianCalendar();
            date = gc.get(Calendar.DAY_OF_MONTH);
            set_month = gc.get(Calendar.MONTH);
            set_year = gc.get(Calendar.YEAR);
            DatePickerDialog dpd = new DatePickerDialog(this, (datePicker, year, month, day) -> {
                String launchDate = day + "/" + (month + 1) + "/" + year;
                etDate.setText(launchDate);
            }, set_year, set_month, date);
            dpd.show();
        });

    }

    private void setCountry() {
        String[] country = getResources().getStringArray(R.array.countryArray);
        ArrayAdapter<String> countryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, country);
        spinnerCountry.setAdapter(countryAdapter);
    }

    private Boolean isValid() {
        boolean valid = true;
        String pattern =
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";
        if (etName.getText().toString().length() == 0) {
            Toast.makeText(this, getString(R.string.Enter_Name), Toast.LENGTH_LONG).show();
            valid = false;
        } else if (etEmail.getText().toString().isEmpty()) {
            etEmail.setError(getString(R.string.Enter_Email));
            Toast.makeText(getApplicationContext(), getString(R.string.Enter_Email), Toast.LENGTH_SHORT).show();
            valid = false;
        } else if (!etEmail.getText().toString().matches(pattern)) {
            etEmail.setError(getString(R.string.invalid_email_address));
            Toast.makeText(getApplicationContext(), getString(R.string.invalid_email_address), Toast.LENGTH_SHORT).show();
            valid = false;
        } else if (etDate.getText().toString().length() == 0) {
            Toast.makeText(this, getString(R.string.select_date), Toast.LENGTH_LONG).show();
            valid = false;
        } else if (etAddress.getText().toString().length() == 0) {
            Toast.makeText(this, getString(R.string.Enter_address), Toast.LENGTH_LONG).show();
            valid = false;
        } else if (etPhone.getText().toString().length() != 10) {
            Toast.makeText(this, getString(R.string.Enter_Contact_Number), Toast.LENGTH_LONG).show();
            valid = false;
        } else if (!checkReading.isChecked() && !checkChess.isChecked() && !checkDrawing.isChecked()) {
            Toast.makeText(this, getString(R.string.select_at_least_one_hobby), Toast.LENGTH_LONG).show();
            valid = false;
        }
        return valid;
    }
}