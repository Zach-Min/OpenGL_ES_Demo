package com.example.opengl_es_demo.common;

import android.content.Context;

import com.example.opengl_es_demo.Blur_ImageRenderer;
import com.example.opengl_es_demo.Cube_ImageRenderer;
import com.example.opengl_es_demo.ImageRenderer;
import com.example.opengl_es_demo.Oval_ImageRenderer;
import com.example.opengl_es_demo.Triangle_ImageRenderer;
import com.example.opengl_es_demo.Triangle_color_ImageRenderer;

public class ImageGLSurfaceView extends BaseGLSurfaceView {
    public ImageGLSurfaceView(Context context,int type) {
        super(context);
        if(type == 0) {
            setRenderer(new ImageRenderer(context));
        } else if(type == 1) {
            setRenderer(new Blur_ImageRenderer(context));
        } else if(type == 2) {
            setRenderer(new Triangle_ImageRenderer(context));
        } else if(type == 3) {
            setRenderer(new Triangle_color_ImageRenderer(context));
        } else if(type == 4) {
            setRenderer(new Cube_ImageRenderer(context));
        } else if(type == 5) {
            setRenderer(new Oval_ImageRenderer(context));
        }
    }
}
