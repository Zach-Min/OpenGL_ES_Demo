package com.example.opengl_es_demo;
import android.content.Context;

import com.example.opengl_es_demo.common.BaseGLSurfaceView;

public class ImageGLSurfaceView extends BaseGLSurfaceView {
    public ImageGLSurfaceView(Context context) {
        super(context);
        setRenderer(new ImageRenderer(context));
    }
}
