package com.example.opengl_es_demo.common;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class BaseGLSurfaceView extends GLSurfaceView {

    public BaseGLSurfaceView(Context context) {
        super(context);
        initEGLContext();
    }

    private void initEGLContext(){
        setEGLContextClientVersion(2);
    }
}
