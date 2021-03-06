package com.example.opengl_es_demo;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.opengl_es_demo.common.ImageGLSurfaceView;

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
                setContentView(new ImageGLSurfaceView(mContext, 0));
            }
        });

        Button show_blur = findViewById(R.id.blur);
        show_blur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Opengles.this,"模糊处理,未完成",Toast.LENGTH_SHORT).show();
                mContext = getApplicationContext();
                setContentView(new ImageGLSurfaceView(mContext, 1));
            }
        });

        Button show_triangle = findViewById(R.id.triangle);
        show_triangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Opengles.this,"Triangle",Toast.LENGTH_SHORT).show();
                mContext = getApplicationContext();
                setContentView(new ImageGLSurfaceView(mContext, 2));
            }
        });

        Button show_triangle_color = findViewById(R.id.triangle_color);
        show_triangle_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Opengles.this,"Triangle with color",Toast.LENGTH_SHORT).show();
                mContext = getApplicationContext();
                setContentView(new ImageGLSurfaceView(mContext, 3));
            }
        });

        Button show_cube = findViewById(R.id.cube);
        show_cube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Opengles.this,"show cube",Toast.LENGTH_SHORT).show();
                mContext = getApplicationContext();
                setContentView(new ImageGLSurfaceView(mContext, 4));
            }
        });

        Button show_oval = findViewById(R.id.oval);
        show_oval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Opengles.this,"show oval",Toast.LENGTH_SHORT).show();
                mContext = getApplicationContext();
                setContentView(new ImageGLSurfaceView(mContext, 5));
            }
        });
    }
}
