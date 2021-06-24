package com.example.opengl_es_demo;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Opengles extends AppCompatActivity {

    Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opengles);
        Button show_texture = findViewById(R.id.show_texture);
        show_texture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Opengles.this, "展示纹理", Toast.LENGTH_SHORT).show();
                mContext = getApplicationContext();
                setContentView(new ImageGLSurfaceView(mContext));
            }
        });
    }
}
