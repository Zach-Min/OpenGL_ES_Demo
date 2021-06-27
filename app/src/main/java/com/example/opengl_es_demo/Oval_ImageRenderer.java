package com.example.opengl_es_demo;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;

import com.example.opengl_es_demo.common.BaseGLSL;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class Oval_ImageRenderer implements GLSurfaceView.Renderer {
    private FloatBuffer vertexBuffer;
    private float radius=0.5f;
    float[] f;
    private float[] mViewMatrix=new float[16];
    private float[] mProjectMatrix=new float[16];
    private float[] mMVPMatrix=new float[16];
    private int mPositionHandle;
    private int mColorHandle;
    float color[] = { 1.0f, 1.0f, 1.0f, 1.0f };
    private final String vertexShaderCode =
            "attribute vec4 vPosition;" +
                    "void main() {" +
                    "  gl_Position = vPosition;" +
                    "}";

    private final String fragmentShaderCode =
            "precision mediump float;" +
                    "uniform vec4 vColor;" +
                    "void main() {" +
                    "  gl_FragColor = vColor;" +
                    "}";

    private int mProgram;

    public Oval_ImageRenderer(Context context) {
        Float height = 0.0f;
        ArrayList<Float> data=new ArrayList<>();
        data.add(0.0f);
        data.add(0.0f);
        data.add(height);
        float angDegSpan=360.0f/360;
        for(float i=0; i<360 + angDegSpan ;i+=angDegSpan){
            data.add((float) (radius*Math.sin(i*Math.PI/180f)));
            data.add((float)(radius*Math.cos(i*Math.PI/180f)));
            data.add(height);
        }
        Log.e("zwx302570","the data size =" + data.size());
        f=new float[data.size()];
        for (int i=0;i<f.length;i++){
            f[i]=data.get(i);
        }
        ByteBuffer bb = ByteBuffer.allocateDirect( f.length * 4);
        bb.order(ByteOrder.nativeOrder());
        vertexBuffer = bb.asFloatBuffer();
        vertexBuffer.put(f);
        vertexBuffer.position(0);
    }

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        GLES20.glClearColor(1.0f,0.0f,0.0f,1.0f);// 申请底色空间
        mProgram = BaseGLSL.createOpenGLProgram(vertexShaderCode,fragmentShaderCode);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        GLES20.glUseProgram(mProgram);

        //获取顶点着色器的vPosition成员句柄
        mPositionHandle = GLES20.glGetAttribLocation(mProgram, "vPosition");
        //启用三角形顶点的句柄
        GLES20.glEnableVertexAttribArray(mPositionHandle);
        //准备三角形的坐标数据
        GLES20.glVertexAttribPointer(mPositionHandle, 3, GLES20.GL_FLOAT, false, 0, vertexBuffer);
        //获取片元着色器的vColor成员的句柄
        mColorHandle = GLES20.glGetUniformLocation(mProgram, "vColor");
        //设置绘制三角形的颜色
        GLES20.glUniform4fv(mColorHandle, 1, color, 0);
        //绘制三角形
        GLES20.glDrawArrays(GLES20.GL_TRIANGLE_FAN, 0, f.length/3);
        //禁止顶点数组的句柄
        GLES20.glDisableVertexAttribArray(mPositionHandle);
    }
}
