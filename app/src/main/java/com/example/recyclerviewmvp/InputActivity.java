package com.example.recyclerviewmvp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {

    EditText name, email;
    Button createBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        name = findViewById(R.id.editText_name);
        email = findViewById(R.id.editText_email);
        createBtn = findViewById(R.id.btn_create);

        int index = getIntent().getIntExtra("key_index", -1);
        if(index != -1){
            name.setText(getIntent().getStringExtra("key_name"));
            email.setText(getIntent().getStringExtra("key_email"));
        }

        createBtn.setOnClickListener(v -> {
            String nameString = name.getText().toString();
            String emailString = email.getText().toString();
            Intent intent = new Intent();
            intent.putExtra("key_name", nameString);
            intent.putExtra("key_email", emailString);
            intent.putExtra("key_index", index);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}