package com.example.opengl_es_demo;

import android.content.Context;

import com.example.opengl_es_demo.common.BaseGLSurfaceView;
import com.example.opengl_es_demo.common.ImageRenderer;

public class ImageGLSurfaceView extends BaseGLSurfaceView {
    public ImageGLSurfaceView(Context context) {
        super(context);
        setRenderer(new ImageRenderer(context));
    }

}
