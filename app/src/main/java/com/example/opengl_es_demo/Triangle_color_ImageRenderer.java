package com.example.opengl_es_demo;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import com.example.opengl_es_demo.common.BaseGLSL;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class Triangle_color_ImageRenderer implements GLSurfaceView.Renderer {

    private FloatBuffer vertexBuffer,colorBuffer;
    private int mProgram;
    private int glHPosition;
    private int mColorHandle;
    private int mMatrixHandler;
    private float[] mMVPMatrix=new float[16];
    private float[] mViewMatrix=new float[16];
    private float[] mProjectMatrix=new float[16];
    static float triangleCoords[] = {
            0.5f,  0.5f, 0.0f, // top
            -0.5f, -0.5f, 0.0f, // bottom left
            0.5f, -0.5f, 0.0f  // bottom right
    };
    //设置颜色
    float color[] = {
            0.0f, 1.0f, 0.0f, 1.0f ,
            1.0f, 0.0f, 0.0f, 1.0f,
            0.0f, 0.0f, 1.0f, 1.0f
    };
    private final String vertexShaderCode =
            "attribute vec4 vPosition;" +
                    "varying  vec4 vColor;"+
                    "attribute vec4 aColor;"+
                    "void main() {" +
                    "  gl_Position = vPosition;" +
                    "  vColor=aColor;"+
                    "}";

    private final String fragmentShaderCode =
            "precision mediump float;" +
                    "varying vec4 vColor;" +
                    "void main() {" +
                    "  gl_FragColor = vColor;" +
                    "}";


    public Triangle_color_ImageRenderer(Context context) {
        ByteBuffer bb = ByteBuffer.allocateDirect(triangleCoords.length*4);
        bb.order(ByteOrder.nativeOrder());

        vertexBuffer = bb.asFloatBuffer();
        vertexBuffer.put(triangleCoords);
        vertexBuffer.position(0);

        ByteBuffer dd = ByteBuffer.allocateDirect(color.length * 4);
        dd.order(ByteOrder.nativeOrder());
        colorBuffer = dd.asFloatBuffer();
        colorBuffer.put(color);
        colorBuffer.position(0);
    }

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        GLES20.glClearColor(1.0f,0.0f,0.0f,0.0f);// 申请底色空间
        mProgram = BaseGLSL.createOpenGLProgram(vertexShaderCode,fragmentShaderCode);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT| GLES20.GL_DEPTH_BUFFER_BIT);
        GLES20.glUseProgram(mProgram);

        glHPosition = GLES20.glGetAttribLocation(mProgram,"vPosition");
        GLES20.glEnableVertexAttribArray(glHPosition);
        GLES20.glVertexAttribPointer(glHPosition, 3, GLES20.GL_FLOAT, false, 12, vertexBuffer);

        mColorHandle = GLES20.glGetAttribLocation(mProgram, "aColor");
        GLES20.glEnableVertexAttribArray(mColorHandle);
        GLES20.glVertexAttribPointer(mColorHandle,4,GLES20.GL_FLOAT,false,0,colorBuffer);

        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, 3);
        GLES20.glDisableVertexAttribArray(glHPosition);
    }
}
