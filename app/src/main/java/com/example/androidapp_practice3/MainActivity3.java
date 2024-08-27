package com.example.androidapp_practice3;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity3 extends AppCompatActivity {

    private MaterialToolbar topAppBar;
    private FloatingActionButton fab;
    private MaterialButton materialButton;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Подключение элементов интерфейса к их представлениям в XML
        topAppBar = findViewById(R.id.topAppBar);
        fab = findViewById(R.id.fab);
        materialButton = findViewById(R.id.button);
        progressBar = findViewById(R.id.progressBar);

        // Установка слушателя для Floating Action Button
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity3.this, "Floating Action Button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setProgress(50);
                progressBar.setVisibility(View.VISIBLE);

                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(MainActivity3.this, "Success", Toast.LENGTH_SHORT).show();
                    }
                }, 4000);

                Toast.makeText(MainActivity3.this, "Material Button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Установка слушателя для кликов на Toolbar
        topAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity3.this, "Navigation clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}