package cc.koumakan.gensokyo.OpenGL;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import java.util.List;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import cc.koumakan.gensokyo.OpenGL.Entity.Model;

/**
 * Create by Remilia Scarlet
 * at 2015/10/30 18:39
 **/
public class MyRenderer implements GLSurfaceView.Renderer {
    private Context context;
    private Camera camera;
    private List<Model> list;

    public short frame = 0;
    public int vertex = 0;
    public int triangle = 0;

    public MyRenderer(Context context, Camera camera, List list) {
        this.context = context;
        this.camera = camera;
        this.list = list;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);
        gl.glShadeModel(GL10.GL_SMOOTH);//阴影平滑
        gl.glClearDepthf(1.0f);
        gl.glEnable(GL10.GL_DEPTH_TEST);//启用深度测试
        gl.glDepthFunc(GL10.GL_LEQUAL);
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);//透视修正

        gl.glDisable(GL10.GL_DITHER);//禁止抖动
        gl.glFrontFace(GL10.GL_CCW);    // 正前面为逆时针方向
        gl.glEnable(GL10.GL_CULL_FACE);//打开忽略"后面"设置

        for (Model t : list) {
            t.loadTexture(gl, context);
        }

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);//重置视口大小
        gl.glMatrixMode(GL10.GL_PROJECTION);//选择投影矩阵
        gl.glLoadIdentity();//重置投影矩阵
        GLU.gluPerspective(gl, 45.0f, (float) width / (float) height, 0.0001f, 300.0f);//设置视口范围
        gl.glMatrixMode(GL10.GL_MODELVIEW);//选择模型观察矩阵
        gl.glLoadIdentity();//重置模型观察矩阵
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);//清除屏幕和深度缓存
        gl.glLoadIdentity();//重置模型观察矩阵

        camera.change(gl);
        vertex = 0;
        triangle = 0;
        for (Model t : list) {
            t.draw(gl);
            vertex += t.getVertext();
            triangle += t.getTriangle();
        }

        frame++;
    }
}
