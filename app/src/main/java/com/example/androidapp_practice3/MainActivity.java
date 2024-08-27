package com.example.androidapp_practice3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText usersecond;
    CheckBox genderM;
    CheckBox genderF;
    boolean male = false;
    boolean female = false;
    Toast message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.userName);
        usersecond = findViewById(R.id.userSecondName);
        genderM = findViewById(R.id.chckMale);
        genderF = findViewById(R.id.chckFemale);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void clickToNewActivity(View view) {
        genderM = findViewById(R.id.chckMale);
        genderF = findViewById(R.id.chckFemale);
        male = false;
        female = false;
        male = genderM.isChecked();
        female = genderF.isChecked();

        if(male && female){
            message = Toast.makeText(getApplicationContext(),
                    "Check only one gender", Toast.LENGTH_SHORT);
            message.show();
        } else if (!male) {
            Bundle bundle = new Bundle();
            bundle.putString("firstName", username.getText().toString());
            bundle.putString("secondName", usersecond.getText().toString());
            bundle.putString("gender", genderF.getText().toString());
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtras(bundle);
            startActivity(intent);
        } else if (!female) {
            Bundle bundle = new Bundle();
            bundle.putString("firstName", username.getText().toString());
            bundle.putString("secondName", usersecond.getText().toString());
            bundle.putString("gender", genderM.getText().toString());
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        else {
            message = Toast.makeText(getApplicationContext(),
                    "Check at least one gender", Toast.LENGTH_SHORT);
            message.show();
        }
    }
}