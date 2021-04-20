package com.example.opengl_es_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Opengl = findViewById(R.id.opengles);
        Opengl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "进入OpenGL相关", Toast.LENGTH_SHORT).show();
                Intent intent_opengl = new Intent(MainActivity.this, Opengles.class);
                startActivity(intent_opengl);
            }
        });
    }
}